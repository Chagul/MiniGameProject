package Game;

public class Piege extends Skill{

	public Piege(String skill_name, String skill_desc) {
		super(skill_name, skill_desc);
	}

	@Override
	public void use(Player cible, Plateau p) {
		cible.setMoves(0);		
	}
}
