package Game;

public class Heroes {

	private String name;
	private int pdv;
	private String line;

	public Skill Hero_skill;

	public Heroes(String name, int pdv, String line) {
		this.name = name;
		this.pdv = pdv;
		this.line = line;
	}

	public Heroes(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getPdv() {
		return pdv;
	}

	public boolean changePDV(int changing) {
		if(this.pdv + changing > 0) {
			this.pdv += changing;
			return true;
		}else if(this.pdv + changing <= 0 ) this.pdv = 0;
		return false;
	}

	public String getSkill_name() {
		return Hero_skill.getSkill_name();
	}

	public String getSkill_desc() {
		return Hero_skill.getSkill_desc();
	}

	public String getLine() {
		return line;
	}

	public String displayHeroes() {
		return this.name + "\t HP " + this.pdv + "\t " +  "\t " + this.getSkill_name() + " : " + this.getSkill_desc(); 
	}

	public static void main(String[] args) {
		Heroes un = new Heroes("Guerrier",40,"oui");
		System.out.println(un.getPdv());
		un.changePDV(10);
		
		System.out.println(un.getPdv());
	}

}
