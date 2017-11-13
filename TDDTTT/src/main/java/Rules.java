
public class Rules {

	public boolean boardIsFull(Board board){
		char[][] char_arr = board.getBoard();
		
		for (int i = 0; i < 3; i++) {
			for (int x = 0; x < 3; x++) {
				if (char_arr[i][x] == '-') {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean playerWon(Board board) {
		return colWin(board) || rowWin(board) || diagWin(board);
	}
	
	public boolean colWin(Board board) {
		char[][] char_arr = board.getBoard();
		
		for (int i = 0; i < 3; i++) {
			if (winCondMet(char_arr[0][i], char_arr[1][i], char_arr[2][i])) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean rowWin(Board board) {
		char[][] char_arr = board.getBoard();
		
		for (int i = 0; i < 3; i++) {
			if (winCondMet(char_arr[i][0], char_arr[i][1], char_arr[i][2])) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean diagWin(Board board) {
		char[][] char_arr = board.getBoard();
		return (winCondMet(char_arr[0][0], char_arr[1][1], char_arr[2][2])) || (winCondMet(char_arr[0][2], char_arr[1][1], char_arr[2][0]));
	}
	
	private boolean winCondMet(char c1, char c2, char c3) {
		return ((c1 != '-') && (c2 == c1) && (c3 == c2));
	}
}
