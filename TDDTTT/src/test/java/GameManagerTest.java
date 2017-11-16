import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

public class GameManagerTest {
	GameManager game_manager;
	
	@Before
	public void setupTest() {
		this.game_manager = new GameManager();
	}
	/*
	@Test
	public void getIntUserInputAsValidIntTest() {
	    UserInput user_input = mock(UserInput.class);
	    
	    when(user_input.askUserForInt("Give a number between 1 and 3")).thenReturn(1);
	    
	    assertEquals(game_manager.getUserRowCol(user_input), 1);
	}
	
	@Test
	public void getIntUserInputAsInvalidIntTest() {
	    UserInput user_input = mock(UserInput.class);
	    
	    when(user_input.askUserForInt("Give a number between 1 and 3")).thenReturn(4);
	    when(user_input.askUserForInt("Wrong number, try again.")).thenReturn(3);
	    
	    game_manager.getUserRowCol(user_input);
	    
	    verify(user_input).askUserForInt("Wrong number, try again.");
	    
	}
	*/
}
