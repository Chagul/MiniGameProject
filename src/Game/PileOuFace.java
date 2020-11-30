package Game;
import java.util.Random;

public class PileOuFace extends Skill{
	
	
	public PileOuFace(String skill_name, String skill_desc) {
		super(skill_name, skill_desc);
	}

	
	public void use(Player cible, Plateau p) {
		Random r = new Random();	
		int chance = r.nextInt(1);
		
		if(chance == 0) {
			for(int i = 0; i < cible.personnages.length; i++) {
				cible.personnages[i].changePDV(-35);
			}
			System.out.println("Vos héros ont perdus 35 pv !");
		}
		else {
			for(int i = 0; i < cible.personnages.length; i++) {
				cible.personnages[i].changePDV(35);
			}
			System.out.println("Vos héros ont gagné 35 pv !");

		}
	}

}
