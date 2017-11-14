
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    BoardTest.class,
    RulesTest.class,
    PlayerTest.class,
    UserInputTest.class
})

public class AllTests {
}
