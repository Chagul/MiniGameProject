package Game;
import java.util.Random;

public class Teleportation extends Skill{
	
	public Teleportation(String skill_name, String skill_desc) {
		super(skill_name, skill_desc);
	}

	@Override
	public void use(Player cible, Plateau p) {
		Random a = new Random();
		Random b = new Random();

		int x = a.nextInt(p.getLongueur());
		int y = b.nextInt(p.getLargeur());
		
		if(p.getEmplacement(new Position(x,y)) == null) {
			p.setEmplacement(cible.getPos(), null);
			cible.setPos(new Position(x,y));
		}

	}

}
