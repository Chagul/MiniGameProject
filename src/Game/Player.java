package Game;

public class Player {
	private final int nbHeroes = 4;
	
	
	private String name;
  
	private int mana = 1;
	private int moves = 1;
	private int id;
	private static int prochainId = 1;
    
	public Heroes[] personnages = new Heroes[nbHeroes];

	private Position pos;
	private boolean hasNugget = false;
	
	public Player(String name, Position pos){
		this.id = prochainId;
		prochainId++;
		this.name = name;
		this.pos = pos;
	}
	public int getId() {
		return this.id;
	}
	public Player(String name){
		this(name, new Position(1, 1));
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public int getMoves() {
		return moves;
	}
	public void setMoves(int moves) {
		this.moves = moves;
	}
	public int getMana() {
		return mana;
	}
	public void setMana(int mana) {
		this.mana = mana;
	}
	public Position getPos() {
		return pos;
	}
	public void setPos(Position pos) {
		this.pos = new Position(pos.getY(), pos.getX());
	}
	public boolean hasNugget() {
		return this.hasNugget;
	}
	public void sethasNugget(boolean b) {
		this.hasNugget = b;
	}
	
	
	public String getHeroes() {
		StringBuilder yes = new StringBuilder("");
		for (int i = 0; i < personnages.length; i++) {
			yes.append(this.personnages[i].getName() + ", ");
		}

		return yes.toString();
	}
	public Heroes[] getPersonnages() {
		return personnages;
	}

	public void setPersonnages(Heroes[] personnages) {
		this.personnages = personnages;
	}

	public String toString() {
		return "\nL'équipe de " + this.name + " contient " + this.getHeroes();
	}
	
	
        
	public String AddHero(Heroes h) {
		if (this.personnages[this.nbHeroes-1] != null)
			return "Votre équipe est pleine";

		int i = 0;
		while (this.personnages[i] != null) {
			i++;
		}

		this.personnages[i] = h;
		return "Héro ajouté à votre équipe";
	}

	public boolean changeMana(int changing) {
		if (this.mana + changing >= 0) {
			this.mana += changing;
			return true;
		}
		return false;
	}
	
	public boolean changeMoves(int changing) {
		if(this.moves + changing >= 0) {
			this.moves += changing;
			return true;
		}
		return false;
	}
	
	public void resetPlayer() {
		this.changeMoves(1) ;
		this.changeMana(1);
	}
	
	

	public static void main(String[] args) {

		Player uno = new Player("uno");

		Heroes un = new Heroes("Guerrier",45,"Ouïlle !"); un.Hero_skill = new Attaque("Coup","Attaque l'équipe d'un adversaire pour lui infliger 25");
		Heroes deux = new Heroes("Voleur",50, "Même pas mal"); deux.Hero_skill = new Piege("Piege","Empêche un joueur d'agir pour un tour");
		Heroes trois = new Heroes("Prêtre",40,"Prends ça"); trois.Hero_skill = new Soin("Soin","Soigne de 20-30 pv votre équipe");
		Heroes quatre = new Heroes("Mage",1,"Ouïlle !"); quatre.Hero_skill = new BoostPM("Boost","Gagne un boost permettant de jouer 2 tours");
		
		Heroes cinq = new Heroes("Mage",1,"Ouïlle !"); quatre.Hero_skill = new BoostPM("Boost","Gagne un boost permettant de jouer 2 tours");

		System.out.println(uno.AddHero(un));
		System.out.println(uno.AddHero(deux));
		System.out.println(uno.AddHero(trois));
		System.out.println(uno.AddHero(quatre));

		System.out.println(uno.AddHero(cinq));

		System.out.println("\n" + uno.toString() + "\n");

		System.out.println(uno.changeMana(-1));
		System.out.println(uno.changeMana(-1));
		System.out.println(uno.changeMana(2));
		System.out.println(uno.changeMana(-1));
		System.out.println(uno.changeMana(-1));
		System.out.println(uno.changeMana(-1));

	}
	public void deplacer(int dirX, int dirY) {
		/* ===================== SI on rencontre un caillou ou  creuser, mettre le code ici ============*/
		this.pos.setX(this.pos.getX() + dirX);
		this.pos.setY(this.pos.getY() + dirY);
	}
}
