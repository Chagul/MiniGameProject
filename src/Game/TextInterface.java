package Game;

import java.util.Scanner;

public class TextInterface {
	public Player[] listPlayer;
	public int maxHeroes = 4;
	public int maxPlayer = 2;

	public TextInterface(Player[] theList) {
		this.listPlayer = theList;
	}

	public boolean playTurn(Player thePlayer, Plateau p) {
		System.out.println(p);
		Scanner sc = new Scanner(System.in);
		int choix = -1;
		int choix2 = -1;
		int tmpCompteurDeMort = 0;
		while (thePlayer.getMana() > 0 || thePlayer.getMoves() > 0 || choix != 5) {
			System.out.println("(" + thePlayer.getId() + ")" + thePlayer.getName() + " : Points de mouvements : "
					+ thePlayer.getMoves() + " Mana : " + thePlayer.getMana());
			System.out
					.println("\n \t 1 : Vous déplacer \n \t 2 : Utiliser une compétence \n \n \t 5 : Passer son tour");
			choix = sc.nextInt();
			while (choix != 1 && choix != 2 && choix != 5) {
				System.out.println("Mauvaise saisie !");
				choix = sc.nextInt();
			}
			if (choix == 1) {
				if (thePlayer.getMoves() > 0) {
						System.out.println(
								"Choissisez la direction dans laquelle vous voulez bouger à l'aide de Z Q S D pour réspéctivement haut gauche bas et droite");
						String tmp = sc.next();
						char tmpChar = tmp.charAt(0);
						try {
							boolean saisieInvalide = false;
							switch (tmpChar) {
							case 'q':
								System.out.println("Le joueur se déplace à gauche");
								p.deplacerPlayer(thePlayer, -1, 0);
								thePlayer.setMoves(thePlayer.getMoves() - 1);
								break;
							case 'z':
								p.deplacerPlayer(thePlayer, 0, -1);
								System.out.println("Le joueur se déplace en haut");
								break;
							case 'd':
								p.deplacerPlayer(thePlayer, 1, 0);
								System.out.println("Le joueur se déplace à droite");
								break;
							case 's':
								p.deplacerPlayer(thePlayer, 0, 1);
								System.out.println("Le joueur se déplace en bas");
								break;
							default:
								saisieInvalide = true;
								System.out.println("saisie invalide");
							}
							if (!saisieInvalide)
								thePlayer.setMoves(thePlayer.getMoves() - 1);
						} catch (IndeplacableException e) {
							System.out.println("Déplacement impossible");
						}
						System.out.println(p);
						tmp = "";
				} else {
					System.out.println("Vous n'avez pas de point de mouvement !");
				}
			} else if (choix == 2) {
				if (thePlayer.getMana() != 0) {
					for (int i = 0; i < maxHeroes; i++) {
						if (thePlayer.getPersonnages()[i].getPdv() == 0) {
							System.out.println("\t" + thePlayer.getPersonnages()[i].displayHeroes());
						} else {
							System.out.println(i + 1 + "\t" + thePlayer.getPersonnages()[i].displayHeroes());
						}
					}
					System.out.println("Faites votre choix");
					choix = saisie(maxHeroes);
					while (thePlayer.getPersonnages()[choix].getPdv() == 0) {
						choix = saisie(maxHeroes);
						System.out.println("Ce héros est mort !");
					}
					System.out.println(thePlayer.getPersonnages()[choix].getLine());
					System.out.println("Choississez la cible");
					for (int i = 0; i < maxPlayer; i++) {
						System.out.println(i + 1 + " \t" + listPlayer[i]);
					}
					choix2 = saisie(maxPlayer);
					thePlayer.getPersonnages()[choix].Hero_skill.use(listPlayer[choix2], p);
					thePlayer.changeMana(-1);
					for (int i = 0; i < maxHeroes; i++)
						if (listPlayer[choix2].getPersonnages()[i].getPdv() == 0)
							tmpCompteurDeMort++;
				} else {
					System.out.println("Vous n'avez plus de mana !");
				}
			}
			if (choix == 5) {
				return false;
			}
			if (tmpCompteurDeMort == maxHeroes)
				return true;
		}
		return false;
	}

	public int saisie(int max) {
		Scanner sc = new Scanner(System.in);
		int choix = sc.nextInt();
		while (choix <= 0 || choix > max) {
			System.out.println("Mauvaise saisie");
			choix = sc.nextInt();
		}
		return choix - 1;
	}
}
