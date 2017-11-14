import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

//Covers 100% of Player
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
		char symbol = player.getSymbol();
		assertEquals(symbol, 'X');
	}
	
	@Test
	public void testName() {
		String name = player.getName();
		assertEquals(name, "Player 1");
	}
	
	@Test
	public void testColAndRow() {
		player.setCol(0);
		player.setRow(2);
		
		player.getRow();
		player.getCol();
		
		assertEquals(2, player.getRow());
		assertEquals(0, player.getCol());
	}

}
