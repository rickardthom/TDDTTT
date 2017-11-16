

public class GameManager {
	private Board board;
	private Rules rules;
	private Player player_1;
	protected Player player_2;
	protected Player current_player;
	private boolean game_active = true;
	
	public GameManager(Board board, Rules rules, Player player_1, Player player_2) {
		this.board = board;
		this.rules = rules;
		this.player_1  = player_1;
		this.player_2 = player_2;
		this.current_player = player_1;
	}
	
	public void start() {
		showTitle();
		
		while(game_active) {
			board.printBoard();
			while(!getUserRowCol(new UserInput(System.in, System.out)));
			board.setSymbolAt(current_player.getRow(), current_player.getCol(), current_player.getSymbol());
			game_active = checkGameState();
		}
	}
	
	private boolean checkGameState() {
		if (rules.playerWon(board)) {
			System.out.println("\n" + current_player.getName() + " won!\n");
			current_player.incrScore();
			return playAgain(new UserInput(System.in, System.out));
			
		}else if(board.isFull()) {
			System.out.print("Board is full, game is a draw!");
			return playAgain(new UserInput(System.in, System.out));
			
		}else {
			changePlayer();
			return true;
		}
	}
	
	private boolean playAgain(UserInput user_input) {
		char input = user_input.askUserForChar("Play again (y/n): ");
		if(input == 'y') {
			board.initBoard();
			return true;
		}else {
			return false;
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
			current_player = player_2;
		}else {
			current_player = player_1;
		}
	}
	
	public void showTitle() {
		System.out.println("Tic Tac Toe \n");
		System.out.println(player_1.getName() + " score: " + player_1.getScore());
		System.out.println(player_2.getName() + " score: " + player_2.getScore());
		System.out.println("");
	}
	
}
