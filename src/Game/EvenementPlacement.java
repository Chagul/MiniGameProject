package Game;

public class EvenementPlacement implements PlateauEmplacement{
	
	public String toString() {
		return "?";
	}

	public boolean estDeplacable() {
		return false;
	}

	public boolean accueillirPlayer(Plateau plateau, Player player) {
		return true;
	}
}
