

public class GameManager {
	private Board board = new Board();
	private Rules rules = new Rules();
	private Player player_1 = new Player("Player 1", 'X');
	private Player player_2 = new Player("Player 2", 'O');
	private Player current_player = player_1;
	
	public void start() {
		getUserRowCol(new UserInput(System.in, System.out));
	}
	
	public int getUserRowCol(UserInput user_input) {
	    int input = user_input.askUserForInt("Give a number between 1 and 3");
	    while (input < 1 || input > 3)
	        input = user_input.askUserForInt("Wrong number, try again.");
	    return input;
	}
	
	public void changePlayer() {
		
	}
	
	public void randomStartingPlayer() {
		
	}
	
}
