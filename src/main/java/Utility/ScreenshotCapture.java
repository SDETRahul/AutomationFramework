package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Base.TestBase;

public class ScreenshotCapture extends TestBase{

public static void takeScreenshot(String fileName) {

	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    try {
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"/screenshots/"+fileName));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}
	}

}

