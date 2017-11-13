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
		board.setSymbolAt(2, 2, 'X');
		assertEquals(board.getSymbolAt(2,2), 'X');
	}
	
	@Test 
	public void invalidRangeRowCol() {
		assertFalse(board.validateRowCol(1,4));
	}
	
	@Test 
	public void validRangeRowCol() {
		assertTrue(board.validateRowCol(2,2));
	}
	
	public class BoardStub extends Board {
		
		public char getSymbolAt(int row, int col) {
			return board[row][col];
		}
	}
}
