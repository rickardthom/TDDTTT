import static org.junit.Assert.*;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class UserInputTest {

	@Test
	public void getIntUserInputAsValidIntTest() {
	    String input = "5";
	    String message = "row:";
	    
		OutputStream os = new ByteArrayOutputStream();
		System.setOut(new PrintStream(os));
		
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);

	    UserInput user_input= new UserInput(System.in, System.out);
	    int val = user_input.askUserForInt(message);
	    
	    String output = os.toString();
	    
		assertEquals(5, val);
		assertTrue(output.contains(message));
	}
	
	@Test
	public void getCharUserInput() {
	    String input = "y";
	    String message = "continue(y/n): ";
	    
		OutputStream os = new ByteArrayOutputStream();
		System.setOut(new PrintStream(os));
	    
		InputStream in = new ByteArrayInputStream(input.getBytes());
	    
	    System.setIn(in);
	    UserInput user_input= new UserInput(System.in, System.out);
	    
	    char val = (char)user_input.askUserForChar(message);
	    
	    String output = os.toString();
		assertEquals('y', val);
		assertTrue(output.contains(message));
	}
}
