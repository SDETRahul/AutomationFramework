package Selenium.Tests.Suite2;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.TestBase;

public class CreateAccont extends TestBase {

@Test	
public void createAccountFunction()
	{
/* Logic to create Account, UserName and Passwords are random and used currently
currently not integarted with OR, Try Adding new username/pass to see. This is Hybrid of Absolute and Relative xpaths 
just to show both perspective.
*/		
	
		driver.navigate().to("https://www.fox.com/account/");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[4]/button[1]")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[4]/div[1]/input")).sendKeys("Rahul");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[4]/div[2]/input")).sendKeys("Singh");
		driver.findElement(By.xpath("//input[@name='signupEmail']")).sendKeys("rahul.singh12@outlook.com");
		driver.findElement(By.xpath("//input[@name='signupPassword']")).sendKeys("Password@001");
		driver.findElement(By.xpath("//div[@class='Dropdown_headerInnerContainer_1B5W- AccountSignupDropdown_headerInnerContainer_BaXaz']")).click();
		//driver.wait(5000);
		driver.manage().timeouts().implicitlyWait(5000L,TimeUnit.MILLISECONDS); 
driver.findElement(By.xpath("//*/a[1]/div[contains(@class,'Dropdown_itemContent_1_Dzw AccountSignupDropdown_itemContent_2rwI1')]")).click();
		driver.findElement(By.xpath("//*[contains(@placeholder,'Birthdate')]")).sendKeys("10/10/1985");
		driver.manage().timeouts().implicitlyWait(5000L,TimeUnit.MILLISECONDS); 
		driver.manage().window().maximize();
		//Actions act=new Actions(driver);
		//WebElement el = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[12]/button"));
		WebElement el=driver.findElement(By.className("Account_signupButtonDesktop_1PCXs"));
		el.click();
		driver.findElement(By.className("Account_signupSuccessButton_1mM7y")).click();
		
		
	}
	
}
