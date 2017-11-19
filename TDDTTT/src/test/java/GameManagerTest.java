import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class GameManagerTest {
	GameManagerStub game_manager;
	
	@Before
	public void setupTest() {
		this.game_manager = new GameManagerStub();
	}
	
	@Test
	public void playOneRoundMultipleWrongInputsEndRoundTest() {
		Board m_board = mock(Board.class);
		Rules m_rules = mock(Rules.class);
		UserInput m_user_input = mock(UserInput.class);
		
		GameManagerStub st_game_manager = new GameManagerStub(m_board, m_rules);
		
		when(st_game_manager.getUserRowCol(m_user_input)).thenReturn(false);
		when(st_game_manager.getUserRowCol(m_user_input)).thenReturn(false);
		when(st_game_manager.getUserRowCol(m_user_input)).thenReturn(true);
		
		when(st_game_manager.roundHasEnded()).thenReturn(true);
		when(m_user_input.askUserForChar("Play again (yes=y/n=any key): ")).thenReturn('n');
		
		
		st_game_manager.play(m_user_input);

		verify(m_user_input, times(4)).askUserForInt("row: ");
		verify(m_user_input, times(4)).askUserForInt("col: ");
	}
	
	@Test
	public void playOneRoundMultipleWrongInputsTestf() {
		Board m_board = mock(Board.class);
		Rules m_rules = mock(Rules.class);
		UserInput m_user_input = mock(UserInput.class);
		
		GameManagerStub st_game_manager = new GameManagerStub(m_board, m_rules);

		when(st_game_manager.getUserRowCol(m_user_input)).thenReturn(true);
		
		when(st_game_manager.roundHasEnded()).thenReturn(false);
		
		st_game_manager.play(m_user_input);

		verify(m_user_input, times(2)).askUserForInt("row: ");
		verify(m_user_input, times(2)).askUserForInt("col: ");
	}
	
	@Test
	public void roundHasEndedBecauseOfDrawTest() {
		Board m_board = mock(Board.class);
		Rules m_rules = mock(Rules.class);
		
		GameManagerStub st_game_manager = new GameManagerStub(m_board, m_rules);
		
		when(m_rules.playerWon(m_board)).thenReturn(false);
		when(m_board.isFull()).thenReturn(true);
		
		assertTrue(st_game_manager.roundHasEnded());
	}
	
	@Test
	public void roundHasEndedBecauseOfPlayerWonTest() {
		Board m_board = mock(Board.class);
		Rules m_rules = mock(Rules.class);
		
		GameManagerStub st_game_manager = new GameManagerStub(m_board, m_rules);
		
		when(m_rules.playerWon(m_board)).thenReturn(true);
		
		assertTrue(st_game_manager.roundHasEnded());
	}
	
	@Test
	public void roundHasEndedFalseTest() {
		Board m_board = mock(Board.class);
		Rules m_rules = mock(Rules.class);
		
		GameManagerStub st_game_manager = new GameManagerStub(m_board, m_rules);
		
		when(m_rules.playerWon(m_board)).thenReturn(false);
		when(m_board.isFull()).thenReturn(false);
		
		assertFalse(st_game_manager.roundHasEnded());
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
		
		game_manager.changePlayer();
		Player player_after2= game_manager.getCurrentPlayer();
		assertThat(player_before, is( player_after2));
	}
	
	// no exception expected
	@Test(expected = Test.None.class)
	public void showTitleTest() {
		game_manager.showTitle();
	}
	
	@Test
	public void playAgainTrueTest() {
		UserInput user_input = mock(UserInput.class);
		when(user_input.askUserForChar("Play again (yes=y/n=any key): ")).thenReturn('y');
		assertTrue(game_manager.playAgain(user_input));
	}
	
	@Test
	public void playAgainFalseTest() {
		UserInput user_input = mock(UserInput.class);
		when(user_input.askUserForChar("Play again (yes=y/n=any key): ")).thenReturn('n');
		assertFalse(game_manager.playAgain(user_input));
	}
	
	public class GameManagerStub extends GameManager {
		public GameManagerStub() {
			super(new Board(), new Rules(), new Player("Player 1", 'X'), new Player("Player 2", 'O'));
		}
		
		public GameManagerStub(Board board, Rules rules) {
			super(board, rules, new Player("Player 1", 'X'), new Player("Player 2", 'O'));
		}
		
		public Player getCurrentPlayer() {
			return current_player;
		}
	}
}
