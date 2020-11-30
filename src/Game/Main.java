package Game;

import java.util.ArrayList;

public class Main{
	public static void main(String[] args) {
		Player[] listPlayer = new Player[2];
		ArrayList<Heroes> listHeroes = new ArrayList<Heroes>();

		Heroes un = new Heroes("Guerrier",45,"Ouïlle !"); un.Hero_skill = new Attaque("Coup","Attaque l'équipe d'un adversaire pour lui infliger 15 pv");
		Heroes deux = new Heroes("Voleur",50, "Même pas mal"); deux.Hero_skill = new Piege("Piege","Empêche un joueur d'agir pour un tour");
		Heroes trois = new Heroes("Prêtre",40,"Prends ça"); trois.Hero_skill = new Soin("Soin","Soigne de 20-30 pv votre équipe");
		Heroes quatre = new Heroes("Mage",35,"Aïeuh !"); quatre.Hero_skill = new BoostPM("Boost","Gagne un boost permettant de jouer 2 tours");
		Heroes cinq = new Heroes("Fou",30,"Hihihi !"); cinq.Hero_skill = new PileOuFace("Pile ou Face","Quitte ou double, inflige ou soigne vos héros de 35 pv");
		Heroes six = new Heroes("Ange",10,"Je suis là pour vous"); six.Hero_skill = new Teleportation("Téléportation","Se téléporte sur une case aléatoire du plateau");

		// Utiliser un spell : Player.personnages[i].Hero_skill.use(Player p);
		
		listHeroes.add(un);
		listHeroes.add(deux);
		listHeroes.add(trois);
		listHeroes.add(quatre);
		listHeroes.add(cinq);
		listHeroes.add(six);


		Menu menu = new Menu(listHeroes);
		listPlayer = menu.affichageEcranPrincipal();
		TextInterface ti = new TextInterface(listPlayer);
		listPlayer[0].setPos(new Position(1, 1));
		listPlayer[1].setPos(new Position(5, 16));
		Plateau p = new Plateau(5, 5, 3, 3, listPlayer);
		Evenement evt = new Evenement(p, listPlayer[1]);

		while(!p.isGameEnded()) {
			for(int i = 0; i < listPlayer.length && !p.isGameEnded(); i++) {
				ti.playTurn(listPlayer[i], p);
				listPlayer[i].resetPlayer();
				if(p.isGameEnded) System.out.println("Le joueur " + listPlayer[i].getName() + " a gagné !");
			}
		}
	}
}
