import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	Board board;
	
	@Before
	public void setupTest() {
		this.board = new Board();
	}
	
	@Test 
	public void placeSymbolTest() {
		board.setSymbolAt(3, 3, 'X');
		assertEquals(board.getSymbolAt(3,3), 'X');
	}	

}
