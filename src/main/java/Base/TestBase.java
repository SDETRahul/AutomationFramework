package Base;


import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class TestBase {

	public static WebDriver driver;
	public static java.util.Properties CONFIG =null;
	public static java.util.Properties OR =null;
	
	public TestBase(){
		if(driver==null){
		// initialize the properties file
		CONFIG= new java.util.Properties();
		OR = new java.util.Properties();
		try{
			// config
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/config/config.properties");
			CONFIG.load(fs);
			
			// OR
			fs = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/config/OR.properties");
			OR.load(fs);
			}catch(Exception e){
				// error
				return;
		}
		
		if(CONFIG.getProperty("browser").equals("Mozilla"))
			  this.driver=new FirefoxDriver();
		else if(CONFIG.getProperty("browser").equals("IE"))
		  this.driver=new InternetExplorerDriver();
		else if(CONFIG.getProperty("browser").equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver\\chromedriver.exe");
			this.driver=new ChromeDriver();
		}
		// implicit wait for the whole app
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
		
}
	
	public String getWebSiteURL()
	{
		String urlconf=CONFIG.getProperty("testSiteLadingPageURL");
		return urlconf;
	}
	
	public String getXpathfromOR()
	{
		String xpathor=OR.getProperty("LOGIN_BUTTON");
		return xpathor;
	}
	
	public static void StartSelenium(String url)
	{
		driver=new FirefoxDriver();
		driver.get(url);		
	}
	
	// click
		public void click(String xpathKey){
			try{
		        driver.findElement(By.xpath(OR.getProperty(xpathKey))).click();
			}catch(Exception e){
				System.out.println("error");
				e.printStackTrace();
				// report error
			}
		}
	
	public static void LaunchWebSite(String WebsiteName) throws IOException
	{
		driver.get("http://www."+WebsiteName+".com");
		
	}
	
	
	
	public boolean isElementPresent(String xpathKey){
		try{
			driver.findElement(By.xpath(OR.getProperty(xpathKey)));
		}catch(Exception e){
			return false;
		}
		
		return true;
	}			
	// finds the link on page
	public boolean isLinkPresent(String linkText){
		try{
			driver.findElement(By.linkText(linkText));
		}catch(Exception e){
			return false;
		}
		
		return true;
	}
	
			
}
