import static org.junit.Assert.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import org.junit.Before;
import org.junit.Test;

public class GameManagerTest {
	GameManager game_manager;
	
	@Before
	public void setupTest() {
		this.game_manager = new GameManager();
	}

	@Test
	public void getUserRowColTest() {
		UserInput user_input = mock(UserInput.class);
		game_manager.getUserRowCol(user_input);
		
		verify(user_input, times(1)).askUserForInt("row: ");
		verify(user_input, times(1)).askUserForInt("col: ");
	}
	
	// no exception expected
	@Test(expected = Test.None.class)
	public void showTitleTest() {
		game_manager.showTitle();
	}
}
