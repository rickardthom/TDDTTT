
public class Player {
	private char symbol;
	private int score;
	private String name;
	private int row;
	private int col;
	
	public Player(String name, char symbol) {
		this.symbol = symbol;
		this.name = name;
	}
	
	public char getSymbol() {
		return symbol;
	}
	
	public void incrScore() {
		this.score++;
	}
	
	public int getScore() {
		return score;
	}
	
	public String getName() {
		return name;
	}
	
	public int getCol() {
		return col;
	}
	
	public int getRow() {
		return row;
	}
	
	public void setCol(int col) {
		this.col = col;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
}
