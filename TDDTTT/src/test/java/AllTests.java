
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    BoardTest.class,
    RulesTest.class,
    PlayerTest.class,
    GameManagerTest.class
})

public class AllTests {
}
