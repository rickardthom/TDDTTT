

public class GameManager {
	private Board board = new Board();
	private Rules rules = new Rules();
	private Player player_1 = new Player("Player 1", 'X');
	private Player player_2 = new Player("Player 2", 'O');
	private Player current_player = player_1;
	
	public void start() {
		showTitle();
		
		while(true) {
			board.printBoard();
			while(!getUserRowCol(new UserInput(System.in, System.out)));
			board.setSymbolAt(current_player.getRow(), current_player.getCol(), current_player.getSymbol());
		}
		
	}
	
	public boolean getUserRowCol(UserInput user_input) {
		System.out.println("\n" + current_player.getName() + ", place your marker '" + current_player.getSymbol() + "' in an empty spot! (0-2)");
		current_player.setRow(user_input.askUserForInt("row: "));
		current_player.setCol(user_input.askUserForInt("col: "));
		return board.validateRowCol(current_player.getRow(), current_player.getCol());
	}
	
	public void changePlayer() {
		if(current_player == player_1) {
			this.current_player = player_2;
		}else {
			this.current_player = player_1;
		}
	}
	
	public void randomStartingPlayer() {
		
	}
	
	public void showTitle() {
		System.out.println("Tic Tac Toe \n");
		System.out.println(player_1.getName() + " score: " + player_1.getScore());
		System.out.println(player_2.getName() + " score: " + player_2.getScore());
		System.out.println("");
	}
	
}
