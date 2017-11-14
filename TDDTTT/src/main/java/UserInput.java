import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class UserInput {
	   private Scanner scanner;
	   private PrintStream out;
	
	public UserInput(InputStream in, PrintStream out) {
        scanner = new Scanner(in);
        this.out = out;
	}
	
    public int askUserForInt(String message) {
        out.println(message);
        return scanner.nextInt();
    }
    
    public char askUserForChar(String message) {
        out.println(message);
        return scanner.next().charAt(0);
    }
}
