package old;

import base.BaseTest;
import org.testng.annotations.*;
import utils.ProjectUtils;

@Ignore
public class SergeiDTest extends BaseTest {

	@Test
	public void test() throws InterruptedException {
		getDriver().get("https://ref2.eteam.work/");

		ProjectUtils.login(getDriver());
		//ProjectUtils.reset(getDriver());

		// todo simple test
	}
}
