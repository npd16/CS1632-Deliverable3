import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CraiglistAboutTest.class, CraiglistBuyerTest.class, CraiglistSignInUserTest.class,
		CraigslistUserTest.class })
public class AllTests {

}
