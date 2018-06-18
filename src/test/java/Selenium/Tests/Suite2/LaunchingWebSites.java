package Selenium.Tests.Suite2;

import java.io.IOException;

import org.junit.Test;

import Base.TestBase;
import Utility.ScreenshotCapture;

public class LaunchingWebSites extends TestBase{
	
	@Test
	public void testLaunchWebSite() throws IOException{
		
		TestBase.StartSelenium("http://www.google.com");
		ScreenshotCapture.takeScreenshot("google.png");
		TestBase.LaunchWebSite("yahoo");
		ScreenshotCapture.takeScreenshot("yahoo.png");
		TestBase.driver.close();
		
	}
	
}
