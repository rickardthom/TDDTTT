
public class Board {
	private char[][] board;
	private int row = 3;
	private int col = 3;
	
	public Board() {
		this.board = new char[row][col];
		initBoard();
	}
	
	public void initBoard() {
		for (int i = 0; i < col; i++) {
			for (int x = 0; x < row; x++) {
				this.board[i][x] = '-';
			}
		}
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
