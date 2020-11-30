package Game;

public class PlayerEmplacement implements PlateauEmplacement {
	private Player player;

	public PlayerEmplacement(Player player) {
		this.player = player;
		
	}
	
	public String toString() {
		return player.getId() + "";
	}

	@Override
	public boolean accueillirPlayer(Plateau plateau, Player player) {
		return false;
	}
}
