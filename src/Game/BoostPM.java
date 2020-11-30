package Game;

public class BoostPM extends Skill{

	public BoostPM(String skill_name, String skill_desc) {
		super(skill_name, skill_desc);
	}

	@Override
	public void use(Player cible, Plateau p) {
		cible.changeMoves(1);
		System.out.println("Vous obtenez un point de déplacement en plus !");
	}

}
