import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RulesTest {
	Rules rules;
	BoardStub st_board;
	
	@Before
	public void setupTest() {
		this.rules = new Rules();
	}
	
	@Test
	public void testColWin() {
		this.st_board = new BoardStub();
		st_board.setColWinBoard();
		assertTrue(rules.colWin(st_board));
	}
	
	@Test
	public void testRowWin() {
		this.st_board = new BoardStub();
		st_board.setRowWinBoard();
		assertTrue(rules.rowWin(st_board));
	}
	
	@Test
	public void testDiagWin() {
		this.st_board = new BoardStub();
		st_board.setDiagWinBoard();
		assertTrue(rules.diagWin(st_board));
	}
	
	@Test
	public void testFullBoardNoWinner() {
		this.st_board = new BoardStub();
		st_board.setFullBoardWithNoWinner();
		
		assertFalse(rules.colWin(st_board));
		assertFalse(rules.rowWin(st_board));
		assertFalse(rules.diagWin(st_board));
	}
	
	@Test
	public void testEmptyBoard() {
		this.st_board = new BoardStub();
		
		assertFalse(rules.colWin(st_board));
		assertFalse(rules.rowWin(st_board));
		assertFalse(rules.diagWin(st_board));
	}
	
	class BoardStub extends Board {
		
		public void setColWinBoard(){
			setSymbolAt(1, 1, 'X');
			setSymbolAt(2, 1, 'X');
			setSymbolAt(3, 1, 'X');
		}
		
		public void setRowWinBoard(){
			setSymbolAt(1, 1, 'X');
			setSymbolAt(1, 2, 'X');
			setSymbolAt(1, 3, 'X');
			
		}
		
		public void setDiagWinBoard(){
			setSymbolAt(1, 1, 'X');
			setSymbolAt(2, 2, 'X');
			setSymbolAt(3, 3, 'X');
		}
		
		/*
		char [][] board =  {{'X','X','O'}, 
							{'O','O','X'}, 
							{'X','O','X'}};
		*/
		public void setFullBoardWithNoWinner(){
			setSymbolAt(1, 1, 'X');
			setSymbolAt(1, 2, 'X');
			setSymbolAt(1, 3, 'O');
			setSymbolAt(2, 1, 'O');
			setSymbolAt(2, 2, 'O');
			setSymbolAt(2, 3, 'X');
			setSymbolAt(3, 1, 'X');
			setSymbolAt(3, 2, 'O');
			setSymbolAt(3, 3, 'X');
			
		}
			
}
}
