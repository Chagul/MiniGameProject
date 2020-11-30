package Game;

public class RocherEmplacement implements PlateauEmplacement {
	private boolean contientPepite = false;

	public String toString() {
		return "R";
	}

	public boolean contientPepite() {
		return this.contientPepite;
	}
	
	public void setContientPepite(boolean contientPepite) {
		this.contientPepite = contientPepite;
	}

	@Override
	public boolean accueillirPlayer(Plateau plateau, Player player) {
		if (this.contientPepite) {
			player.sethasNugget(true);
			System.out.println("Vous avez ramassé la pépite !");
		}
		else
			System.out.println("Le rocher est vide...");
		return true;
	}
}


