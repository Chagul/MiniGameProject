package Game;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Menu {
	private String title =
	
		"                                                                                 \n" + 
		"                             .  .                                         .      \n" + 
		"                                                                                 \n" + 
		"                                 @&&&&     &&&&                                  \n" + 
		"                            &&(*&&&           &&,.&&(                            \n" + 
		"                        &&.*&&.                   &&..*&&                        \n" + 
		"                 %&&(&..*&&                           &@...&&./                  \n" + 
		"               &.  ..*/&                                 &....  .&               \n" + 
		"              &,......*&                                 &*......*&          .   \n" + 
		"            .&.....*&&((#&&                            &* ,&*..**..&        .    \n" + 
		"       .   &..%&   &&( /((###                       &#, ,,,/&&  &&**.&           \n" + 
		"         &(.&&        &&  ((##&&                  &*  ,,//&        &&*&&         \n" + 
		"        &.&%             &( (((#&&             &&, ,,*/&&            &&*&        \n" + 
		"      &&&&                 &&((((##&         &%,,,,/&&                 &*&&      \n" + 
		"     &.&                      &&((((#&&   &&,,,,//&                      &&&     \n" + 
		"     &&                         .&((((##&&,,,*/&&                         &&     \n" + 
		"                                   (&(&,,,,/&&                                   \n" + 
		"                                   &&,,,//&%#&                                   \n" + 
		"       .                         &*,,,/&&&((((#&&                                \n" + 
		"    .                         ##,,,/&&     &&(((#%&                              \n" + 
		"                            &,,,/*&#          &&(*##&&                           \n" + 
		"                         &&,,,/&&               %&(((#&&                         \n" + 
		"                       &%,,/%&                     &&((##&*                      \n" + 
		"                    &&,,//&%                          &%((#&&                    \n" + 
		"                  &&,,/&&                               &&((##&                  \n" + 
		"                   &(&                                     &&&(                  \n" + 
		"                                .                                                \n" +
		"                                                                                       		   \n" + 
		"                            TROUVEZ  VOTRE  PEPITE !!!                                            \n" + 
		"                                                                                       		   \n" + 
		"                                                                                       		   \n" +		
		"   ######   ##     ##  ########  ########    ######   ##     ##  ########  ##     ##  ########    \n" +
		"  ##    ##  ##     ##  ##        ##     ##  ##    ##  ##     ##  ##        ##     ##  ##     ##   \n" +
		"  ##        ##     ##  ##        ##     ##  ##        ##     ##  ##        ##     ##  ##     ##   \n" +
		"  ##        #########  ######    ########   ##        #########  ######    ##     ##  ########    \n" +
		"  ##        ##     ##  ##        ##   ##    ##        ##     ##  ##        ##     ##  ##   ##     \n" +
		"  ##    ##  ##     ##  ##        ##    ##   ##    ##  ##     ##  ##        ##     ##  ##    ##    \n" +
		"   ######   ##     ##  ########  ##     ##   ######   ##     ##  ########   #######   ##     ##   \n" +
		"                                                                                                  \n "+
		"                                                                                                  \n "+

		"                                                                                                   \n "+
		"                           ########     ####     #######   ########                                \n" +
		"                           ##     ##    ####    ##     ##  ##     ##                               \n" +
		"                           ##     ##     ##     ##     ##  ##     ##                               \n" +
		"                           ##     ##    ##      ##     ##  ########                                \n" +
		"                           ##     ##            ##     ##  ##   ##                                 \n" +
		"                           ##     ##            ##     ##  ##    ##                                \n" +
		"                           ########              #######   ##     ##                               \n" +
		"                                                                                                   \n "+
		"                                                                                                   \n "+
		"                                                                                                   \n "+
		"                                                                                                   \n "+
		"                                                                                                   \n "+
		"                                                                                                   \n ";
	

	
	static int maxHeroes = 6;
	ArrayList<Heroes> listHeroes ;

	public Menu(List<Heroes> aListHeroes) {
		this.listHeroes = (ArrayList<Heroes>) aListHeroes;
	}
	
	public Player[] affichageEcranPrincipal() {
		Player listPlayer[] = new Player[2];
		System.out.println(title + "\n" + "Appuyez sur une touche puis entrée pour démarrer");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		System.out.println("\nBienvenue dans chercheur d'or, votre but est de trouver une pépite d'or qui sera cachée sur la map parmi les rochers ou d'anéantir l'équipe adverse grâce aux compétences des héros que vous choisirez \n\nSur votre carte :\n\nR = Rocher à creuser afin de trouver la pépite\n! = Sortie où ramener la pépite pour gagner\n ");
		try {
			listPlayer = affichageSelection();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPlayer;
	}
	public Player[] affichageSelection() throws InterruptedException {
		Player[] listPlayer = new Player[2];
		Scanner sc = new Scanner(System.in);
		System.out.println("==> Quel est votre nom, premier joueur ?");
		String tmp = sc.nextLine();
		Player player1 = new Player(tmp);
		System.out.println("==> Quel est votre nom, second joueur ?");
		tmp = sc.next();
		Player player2 = new Player(tmp); 
		System.out.println("\n========== Bonjour " + player1.getName() + " choississez vos personnages en entrant leur numéro ==========\n");
		displayHeroes(player1, listHeroes);	
		System.out.println("\n========== Bonjour " + player2.getName() + "   choississez vos personnages  en entrant leur numéro ==========\n");
		displayHeroes(player2, listHeroes);
		listPlayer[0] = player1;
		listPlayer[1] = player2;
		return listPlayer;

	}

	public  void displayHeroes(Player player, ArrayList<Heroes> listHeroes) {
		int i = 0;
		int j = 0;
		int numHeroes = 0;
		Heroes[] listHeroesTMP = new Heroes[maxHeroes];
		for(int k = 0; k < listHeroes.size(); k++) {
			listHeroesTMP[k] = null;
		}
		while(i < listHeroes.size()) {
			//System.out.println(listHeroes.get(i).getName());
			//System.out.println(i);
			System.out.println(j++ + ":" + listHeroes.get(i).getName() + "\n \t Point de vie : " + listHeroes.get(i).getPdv() + "\n \t Skill " + listHeroes.get(i).getSkill_name() + " : " + listHeroes.get(i).getSkill_desc());
			i++;
		}
		Scanner sc = new Scanner(System.in);
		while(numHeroes < 4) {
			int index;
			System.out.println("\n==> Entrez le numéro correspondant au héro que vous voulez choisir");
			index = sc.nextInt();
			while(index < 0 || index > listHeroes.size()-1) {
				System.out.println("Mauvaise saisie");
				index = sc.nextInt();
			}
			if(listHeroesTMP[index] != null) {
				System.out.println("Vous avez déjà choisi ce héro !");
			}else {
				player.AddHero(listHeroes.get(index));
				listHeroesTMP[index] = listHeroes.get(index);
				numHeroes++;
			}
		}
	}
}
