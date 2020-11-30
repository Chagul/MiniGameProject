package Game;
import java.util.Random;

public class Evenement {
	
	private Plateau t;
	private Player p;
	
	public Evenement(Plateau plateau, Player player) {
		this.t = plateau;
		this.p = player;
		//this.t.setEmplacement(new Position(3,3), new EvenementPlacement());
		//this.t.setEmplacement(new Position(1,5), new EvenementPlacement());
		//this.t.setEmplacement(new Position(8,2), new EvenementPlacement());

	}
	
	public void PremierEve(Player p2){
		if(p.getPos() == new Position(3,3))	{
			System.out.println("CASE EVENEMENT !!!");
			System.out.println("Vous échangez de place, le joueur 1 prend la place du 2 et inversement !");	
			this.t.changePlayer(p, p2);
		}
	}
	
	
	public void DeuxiemeEve() {
		if(p.getPos() == new Position(5,5))	{
			System.out.println("CASE EVENEMENT !!!");
			System.out.println("Vous perdez aléatoirement 1 héros de votre équipe !");	
			System.out.println("Il a pris ses jambes à son cou et a donc décidé de quitter la mine qu'il trouve trop dangereuse !");	
			
			Random r = new Random();
			int valeur = r.nextInt(p.personnages.length);
			
			System.out.println("...");	
			System.out.println("...");	
			System.out.println("...");	
			
			System.out.println("C'est donc " + p.personnages[valeur].getName() + " qui quitte votre équipe");
			System.out.println("Pour ne pas perdre de temps suite à cette nouvelle, vous accélerez le rythme !");
			System.out.println("Vous jouerez 2 fois lors du prochain tour !");	

			p.changeMoves(1);
			p.changeMana(1);
			p.personnages[valeur] = null;
			
		}
	}
			
		
		
	public void TroisiemeEve() {
		if(p.getPos() == new Position(8,2))	{
			System.out.println("CASE EVENEMENT !!!");
			System.out.println("Toute votre équipe gagne 30 PV !");	
			
			for(int i = 0; i < this.p.personnages.length; i ++) {
				p.personnages[i].changePDV(30);
			}
			
			System.out.println("Pour fêter cela toute l'équipe organise une soirée !");	
			System.out.println("Malheureusement tout le monde est trop ivre pour reprendre le chemin !");
			System.out.println("Vous passez votre prochain tour !");
				
			p.setMoves(0);
			p.setMana(0);
		
		}
	}

}
