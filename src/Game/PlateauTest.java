package Game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlateauTest {
/*
	@Test
	void testDeplacer() throws IndeplacableException {
		Position pos1 = new Position(1, 2);
		Position pos2 = new Position(1, 3);
		Position pos3 = new Position(0, 0);

		Player player = new Player("a", pos1);
		Plateau p = new Plateau(5, 5, 3,3, new Player[] { player });

		p.deplacer(pos1, pos2);
		assertEquals(p.getEmplacement(pos1), null);
		assertEquals(p.getEmplacement(pos2).toString(), "P");

		boolean failed;

		failed = false;
		try {
			p.deplacer(pos1, new Position(-1, 0));
		}
		catch (IndeplacableException e) {
			failed = true;
		}
		assertTrue(failed);

		failed = false;
		try {
			p.deplacer(pos1, new Position(-1, 0));
		}
		catch (IndeplacableException e) {
			failed = true;
		}
		assertTrue(failed);

		failed = false;
		try {
			p.setEmplacement(pos3, new RocherEmplacement());
			p.deplacer(pos3, pos2);
		}
		catch (IndeplacableException e) {
			failed = true;
		}
		assertTrue(failed);
	}*/

	@Test
	void testDeplacerPlayer() throws IndeplacableException {
		Position pos1 = new Position(1, 2);
		Position pos2 = new Position(1, 3);
		Player player = new Player("a", pos1.copy());
		Plateau p = new Plateau(5, 5, 0, 0, new Player[] { player }, false);

		p.deplacerPlayer(player, 0, 1);
		assertEquals(pos2, player.getPos());
		assertNotEquals(p.getEmplacement(pos2), null);
		assertEquals(p.getEmplacement(pos1), null);
		
	}
}
