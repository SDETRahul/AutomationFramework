package Selenium.Tests.Suite2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ LaunchingWebSites.class, PropertyFileTests.class })
public class AllTests {

}
