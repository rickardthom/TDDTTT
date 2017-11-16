import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import org.junit.Before;
import org.junit.Test;

public class GameManagerTest {
	GameManagerStub game_manager;
	
	@Before
	public void setupTest() {
		this.game_manager = new GameManagerStub();
	}

	@Test
	public void getUserRowColTest() {
		UserInput user_input = mock(UserInput.class);
		game_manager.getUserRowCol(user_input);
		
		verify(user_input, times(1)).askUserForInt("row: ");
		verify(user_input, times(1)).askUserForInt("col: ");
	}
	
	@Test
	public void changePlayerTest() {
		Player player_before = game_manager.getCurrentPlayer();
		game_manager.changePlayer();
		Player player_after= game_manager.getCurrentPlayer();
		assertThat(player_before, not(player_after));
	}
	
	// no exception expected
	@Test(expected = Test.None.class)
	public void showTitleTest() {
		game_manager.showTitle();
	}
	
	public class GameManagerStub extends GameManager {
		
		public Player getCurrentPlayer() {
			return current_player;
		}
	}
}
