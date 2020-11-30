package Game;

import java.util.Random;

public class Soin extends Skill{
	
	public Soin(String skill_name, String skill_desc) {
		super(skill_name, skill_desc);
	}

	@Override
	public void use(Player cible, Plateau p) {
		for(int i = 0; i < cible.personnages.length; i++) {
			Random r = new Random();
			int valeur = r.nextInt(10) + 20;
			cible.personnages[i].changePDV(valeur);
			System.out.println(cible.personnages[i].getName() + " a été soigné de " + valeur);
		}
	}

}
