package Game;

public abstract class Skill {

	private String skill_name;
	private String skill_desc;
	
	public Skill(String skill_name, String skill_desc) {
		this.skill_name = skill_name;
		this.skill_desc = skill_desc;
	}
	
	public String getSkill_name() {
		return skill_name;
	}
	public String getSkill_desc() {
		return skill_desc;
	}
	
	public abstract void use(Player cible, Plateau p);

}
