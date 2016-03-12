package AllTestRunner;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.CharacterTests;

@RunWith(Suite.class)
@SuiteClasses({CharacterTests.class,tests.EnemyTests.class,tests.GameTests.class,
	tests.MiscTests.class,tests.ScoreKeepingTests.class,tests.AnimationTests.class})
public class AllTests {

}
