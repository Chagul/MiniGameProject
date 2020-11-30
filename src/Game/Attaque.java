package Game;

public class Attaque extends Skill{

	public Attaque(String skill_name, String skill_desc) {
		super(skill_name, skill_desc);
	}

	@Override
	public void use(Player cible, Plateau p) {
		for(int i = 0; i < cible.personnages.length; i++) {
			cible.personnages[i].changePDV(-15);
		}
		System.out.println("Les héros de " + cible.getName() + " ont perdus 15 pv !");
	}
}
