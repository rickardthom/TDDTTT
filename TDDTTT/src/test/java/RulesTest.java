import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

//Covers 100% of Rules
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
	
	@Test
	public void testPlayerWonNoWinner() {
		this.st_board = new BoardStub();
		st_board.setFullBoardWithNoWinner();
		assertFalse(rules.playerWon(st_board));
	}
	
	@Test
	public void testPlayerWonNWihWinner() {
		this.st_board = new BoardStub();
		st_board.setDiagWinBoard();
		assertTrue(rules.playerWon(st_board));
	}
	
	class BoardStub extends Board {
		
		public void setColWinBoard(){
			setSymbolAt(0, 0, 'X');
			setSymbolAt(1, 0, 'X');
			setSymbolAt(2, 0, 'X');
		}
		
		public void setRowWinBoard(){
			setSymbolAt(0, 0, 'X');
			setSymbolAt(0, 1, 'X');
			setSymbolAt(0, 2, 'X');
			
		}
		
		public void setDiagWinBoard(){
			setSymbolAt(0, 0, 'X');
			setSymbolAt(1, 1, 'X');
			setSymbolAt(2, 2, 'X');
		}
		
		/*
		char [][] board =  {{'X','X','O'}, 
							{'O','O','X'}, 
							{'X','O','X'}};
		*/
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
