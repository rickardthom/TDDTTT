

public class GameManager {
	private Board board = new Board();
	private Rules rules = new Rules();
	private UserInput user_input = new UserInput(System.in, System.out);
	private Player player_1 = new Player("Player 1", 'X');
	private Player player_2 = new Player("Player 2", 'O');
	private Player current_player = player_1;
	
	public void start() {
		showTitle();
		while(!getUserRowCol());
		
	}
	
	public boolean getUserRowCol() {
		System.out.println("\n" + current_player.getName() + ", place your marker '" + current_player.getSymbol() + "' in an empty spot!");
		current_player.setRow(user_input.askUserForInt("row: "));
		current_player.setCol(user_input.askUserForInt("col: "));
		return board.validateRowCol(current_player.getRow(), current_player.getCol());
	}
	
	public void changePlayer() {
		
	}
	
	public void randomStartingPlayer() {
		
	}
	
	private void showTitle() {
		System.out.println("Tic Tac Toe \n");
		System.out.println(player_1.getName() + " score: " + player_1.getScore());
		System.out.println(player_2.getName() + " score: " + player_2.getScore());
		System.out.println("");
	}
	
}
