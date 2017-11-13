
public class Board {
	protected char[][] board;
	private int row = 3;
	private int col = 3;
	
	public Board() {
		this.board = new char[row][col];
		initBoard();
	}
	
	public void initBoard() {
		for (int i = 0; i < row; i++) {
			for (int x = 0; x < col; x++) {
				this.board[i][x] = '-';
			}
		}
	}
	
	public void setSymbolAt(int row, int col, char symbol) {
		this.board[row][col] = symbol;
	}
	
	public boolean validateRowCol(int usr_row, int usr_col) {
		if((usr_row >= 0) && (usr_row < 3)){
			if((usr_col >= 0) && (usr_col < 3)) {
				if(board[usr_row][usr_col] == '-') {
					return true;
				}
			}
		}
		return false;
	}
	
	public char[][] getBoard(){
		return board;
	}
	
	public void printBoard() {
		System.out.println("-------------");
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int x = 0; x < 3; x++) {
				System.out.print(board[i][x] + " | ");
			}
			System.out.println("");
		}
		System.out.println("-------------");
	}
}
