package Selenium.Tests.Suite2;

import org.junit.Test;

import Base.TestBase;

public class PropertyFileTests extends TestBase {
	
	TestBase t=new TestBase();
	
	//To Test property File Usage in Files
	
	@Test
	public void testConfPropertyFileUsage()
	{
		System.out.println(t.getWebSiteURL());
	}
	
	@Test
	public void testORPropertyFileUsage()
	{
		System.out.println(t.getXpathfromOR());
	}
	
}
