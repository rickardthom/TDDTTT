import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

//Covers 56% of Player
public class PlayerTest {

	Player player;
	
	@Before
	public void setupTest() {
		this.player = new Player("Player 1", 'X');
	}
	
	@Test
	public void testScore() {
		player.incrScore();
		assertEquals(player.getScore(), 1);
	}
	
	@Test
	public void testSymbol() {
		char pl_symb = player.getSymbol();
		assertEquals(pl_symb, 'X');
	}
	

}
