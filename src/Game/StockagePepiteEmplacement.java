package Game;

public class StockagePepiteEmplacement implements PlateauEmplacement {
	public boolean estDeplacable() {
		return false;
	}

	public String toString() {
		return "!";
	}

	@Override
	public boolean accueillirPlayer(Plateau plateau, Player player) {
		if (player.hasNugget()) {
			plateau.setIsGameEnded(true);
			System.out.println("FINI!");
			return true;
		}
		return false;
	}
}