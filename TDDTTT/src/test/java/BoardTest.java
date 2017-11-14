import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

//Covers 100% of board
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
	public void invalidRangeRowColTest() {
		assertFalse(board.validateRowCol(-1, 3));
		assertFalse(board.validateRowCol(3, -1));
		assertFalse(board.validateRowCol(1, 3));
		assertFalse(board.validateRowCol(1, -3));
	}
	
	@Test 
	public void validRangeRowColTest() {
		assertTrue(board.validateRowCol(2,2));
		assertTrue(board.validateRowCol(0,0));
		assertTrue(board.validateRowCol(1,1));
	}
	
	@Test 
	public void validSymbolOnEmptyBoardTest() {
		for (int i = 0; i < 3; i++) {
			for (int x = 0; x < 3; x++) {
				assertTrue(board.validateRowCol(i, x));
			}
		}
	}
	
	@Test 
	public void validSymbolOnFullBoardTest() {
		board.setFullBoardWithNoWinner();
		for (int i = 0; i < 3; i++) {
			for (int x = 0; x < 3; x++) {
				assertFalse(board.validateRowCol(i, x));
			}
		}
	}
	
	@Test 
	public void getBoardTest() {
		board.setSymbolAt(1, 1, 'X');
		char[][] char_arr = board.getBoard();
		assertEquals(char_arr[1][1], board.getSymbolAt(1, 1));
	}
	
	@Test 
	public void boardIsFullTest() {
		assertFalse(board.isFull());
		board.setFullBoardWithNoWinner();
		assertTrue(board.isFull());
	}
	
	// no exception expected
	@Test(expected = Test.None.class)
	public void printEmptyAndFullBoardTest() {
		board.printBoard();
		board.setFullBoardWithNoWinner();
		board.printBoard();
	}
	
	public class BoardStub extends Board {
		
		public char getSymbolAt(int row, int col) {
			return board[row][col];
		}
		
		public void setFullBoardWithNoWinner(){
			setSymbolAt(0, 0, 'X');
			setSymbolAt(0, 1, 'X');
			setSymbolAt(0, 2, 'O');
			setSymbolAt(1, 0, 'O');
			setSymbolAt(1, 1, 'O');
			setSymbolAt(1, 2, 'X');
			setSymbolAt(2, 0, 'X');
			setSymbolAt(2, 1, 'O');
			setSymbolAt(2, 2, 'X');
		}
	}
}
