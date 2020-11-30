package Game;

import java.util.ArrayList;
import java.util.Random;

public class Plateau {

	private PlateauEmplacement[][] emplacements;
	private ArrayList<Player> players;
	protected boolean isGameEnded;
	private int longueur;
	private int largeur;
	public Plateau(int larg, int lon, int nbrRochers, Player[] players) {
		this(larg, lon, nbrRochers, 0, players);
	}

	public Plateau(int larg, int lon, int nbrRochers, int nbrEvents, Player[] players, boolean generate) {
		this.longueur = lon;
		this.largeur = larg;
		this.emplacements = new PlateauEmplacement[this.longueur][this.largeur];
		this.players = new ArrayList<Player>();
		for (Player p : players) {
			this.players.add(p);
		}

		genererEmplacements(nbrRochers, nbrEvents, generate);
	}
	public Plateau(int larg, int lon, int nbrRochers, int nbrEvents, Player[] players) {
		this(larg, lon, nbrRochers, 0, players, true);
	}

	public void deplacerPlayer(Player player, int dirX, int dirY) throws IndeplacableException {
		Position oldPos = player.getPos().copy();
		if (oldPos.getX() < 0 || oldPos.getX() >= this.emplacements[0].length || oldPos.getY() < 0
				|| oldPos.getY() >= this.emplacements.length) {
			throw new IndeplacableException();
		}
		player.deplacer(dirX, dirY);

		Position newPos = player.getPos().copy();
		if (newPos.getX() < 0 || newPos.getX() >= this.emplacements[0].length || newPos.getY() < 0
				|| newPos.getY() >= this.emplacements.length) {
			throw new IndeplacableException();
		}

		if (this.emplacements[newPos.getY()][newPos.getX()] != null) {
			boolean playerAccueilli = this.emplacements[newPos.getY()][newPos.getX()].accueillirPlayer(this, player);
			if (!playerAccueilli)
				throw new IndeplacableException();
		}
		deplacer(oldPos, newPos);
	}

	public void changePlayer(Player p1, Player p2) {
		Position tmp = p1.getPos();
		p1.setPos(p2.getPos());
		p2.setPos(tmp);
	}

	private void deplacer(Position oldPos, Position newPos) {
		PlateauEmplacement tmp = this.emplacements[oldPos.getY()][oldPos.getX()];
		this.emplacements[oldPos.getY()][oldPos.getX()] = null;
		this.emplacements[newPos.getY()][newPos.getX()] = tmp;
	}

	private void repartirEmplacements(PlateauEmplacement[] aPlacer) {
		Random rnd = new Random();
		double proba = (double) aPlacer.length / (this.emplacements[0].length * this.emplacements.length);
		int prochainEmplacementPlacable = 0;
		while (prochainEmplacementPlacable < aPlacer.length) {
			for (int i = 0; i < this.emplacements.length; i++) {
				for (int j = 0; j < this.emplacements[0].length; j++) {
					if (prochainEmplacementPlacable < aPlacer.length && rnd.nextDouble() < proba
							&& this.emplacements[i][j] == null) {
						this.emplacements[i][j] = aPlacer[prochainEmplacementPlacable];
						
						prochainEmplacementPlacable++;
					}
				}
			}
		}
	}

	private void genererEmplacements(int nbrRochers, int nbrEvents, boolean generate) {
		// générer stockage
		this.emplacements[this.emplacements.length / 2][this.emplacements[0].length
				/ 2] = new StockagePepiteEmplacement();

		// répartir emplacements players

		if (generate) {
			Random rnd = new Random();
			double proba = (double) this.players.size() / (this.emplacements[0].length * this.emplacements.length);
			int prochainEmplacementPlacable = 0;
			while (prochainEmplacementPlacable < this.players.size()) {
				for (int y = 0; y < this.emplacements.length; y++) {
					for (int x = 0; x < this.emplacements[0].length; x++) {
						if (prochainEmplacementPlacable < this.players.size() && rnd.nextDouble() < proba
								&& this.emplacements[y][x] == null) {
							this.emplacements[y][x] = new PlayerEmplacement(this.players.get(prochainEmplacementPlacable));
							this.players.get(prochainEmplacementPlacable).setPos(new Position(y, x));
							prochainEmplacementPlacable++;
						}
					}
				}
			}
			

			// répartir emplacements rochers
			RocherEmplacement[] rochers = new RocherEmplacement[nbrRochers];
			for (int i = 0; i < rochers.length; i++) {
				rochers[i] = new RocherEmplacement();
			}
			rochers[rnd.nextInt(rochers.length)].setContientPepite(true);
			repartirEmplacements(rochers);
			/*
			EvenementPlacement[] events = new EvenementPlacement[nbrEvents];
			for (int i = 0; i < rochers.length; i++) {
				events[i] = new EvenementPlacement();
			}
			repartirEmplacements(events);			*/
		}
		else {
			for (Player p : this.players) {
				this.emplacements[p.getPos().getY()][p.getPos().getX()] = new PlayerEmplacement(p);
			}
		}
	}

	public PlateauEmplacement getEmplacement(Position pos) {
		return this.emplacements[pos.getY()][pos.getX()];
	}

	public void setEmplacement(Position pos, PlateauEmplacement value) {
		this.emplacements[pos.getY()][pos.getX()] = value;
	}

	public String toString() {
		final char BORD_VERTICAL = '|';
		final char BORD_HORIZONTAL = '-';
		final char BORD_HAUT_GAUCHE = '-';
		final char BORD_HAUT_DROITE = '-';
		final char BORD_BAS_GAUCHE = '-';
		final char BORD_BAS_DROITE = '-';

		String str = "";

		String bordure = "";
		for (int i = 0; i < this.emplacements[0].length * 2 + 1 ; i++) {
			bordure += BORD_HORIZONTAL;
		}

		str += BORD_HAUT_GAUCHE + bordure + BORD_HAUT_DROITE + "\n";

		for (int i = 0; i < this.emplacements.length; i++) {
			str += BORD_VERTICAL + " ";
			for (int j = 0; j < this.emplacements[0].length; j++) {
				if (this.emplacements[i][j] == null)
					str += "  ";
				else
					str += this.emplacements[i][j] + " ";
			}
			str += BORD_VERTICAL + "\n";
		}

		str += BORD_BAS_GAUCHE + bordure + BORD_BAS_DROITE;
		return str;
	}

	public boolean isGameEnded() {
		return this.isGameEnded;
	}

	public void setIsGameEnded(boolean state) {
		this.isGameEnded = state;
	}

	// A faire une fois que l'arrivée sera crée, sert à la fin de la game
	public Position getPositionArrivee() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
}
