
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
		this.board[row-1][col-1] = symbol;
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
