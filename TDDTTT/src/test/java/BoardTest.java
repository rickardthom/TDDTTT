import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	BoardStub board;
	
	@Before
	public void setupTest() {
		this.board = new BoardStub();
	}
	
	@Test 
	public void placeSymbolTest() {
		board.setSymbolAt(3, 3, 'X');
		assertEquals(board.getSymbolAt(3,3), 'X');
	}
	
	@Test 
	public void invalidRangeRowCol() {
		assertFalse(board.validateRowCol(3,4));
	}
	
	@Test 
	public void validRangeRowCol() {
		assertTrue(board.validateRowCol(3,3));
	}
	
	public class BoardStub extends Board {
		
		public char getSymbolAt(int row, int col) {
			return board[row-1][col-1];
		}
	}
}
