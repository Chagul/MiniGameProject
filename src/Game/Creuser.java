package Game;

public class Creuser {

	private Plateau tab;
	private Player p;
	
	public Creuser(Plateau plateau, Player pla){
		this.tab = plateau;
		this.p = pla;
	}
	
	public boolean canDig() {
		if(this.tab.getEmplacement(p.getPos()).toString() == "R") return true;
		return false;
	}

	
}
