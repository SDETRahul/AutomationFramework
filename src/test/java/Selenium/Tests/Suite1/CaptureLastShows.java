package Selenium.Tests.Suite1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Base.TestBase;
import Utility.ReadExcel;
import Utility.excelutils;

public class CaptureLastShows extends TestBase{
	
	ReadExcel excel;
	Sheet sheet1;
	ArrayList<String> showslist;
	ArrayList<String> Fxlist;
	ArrayList<String> NGlist;
	ArrayList<String> Allshowslist;
	
	excelutils excelobj;
	String showsinexcel;
	String showsinexcelfx;
	String showsinexcelNG;
	String Allshowsinexcel;
	
/* 	Below Method Navigates to Shows and Capture Last Shows and Write the 
		Last 4 Shows in Excel if duplicate then add duplicate text else nothing is added
*/
	
	@Test 
	public void captureshows () throws Exception
	{
		StartSelenium("https://www.fox.com/shows/");
		
		driver.manage().window().maximize();
		Thread.sleep(30000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
		
		List<WebElement> elements = driver.findElements(By.xpath("//*[contains(@class,'Tile_title_2XOxg MovieTile_title_1u6rs')]"));
		
		Iterator<WebElement> ir = elements.iterator();
		showslist=new ArrayList<String>();
		while(ir.hasNext())
		{	
			showslist.add(ir.next().getText());
		}
		int showlistsize=showslist.size();
		int startcount=showlistsize-4;
		excelobj=new excelutils();
		excelobj.setExcelFileSheet("Shows");
		int RowNumshows=1;
//Todo: Add Logic to run loop with rowcount
		for(int i=startcount;i<showlistsize;i++)
		{
			excelobj.setCellData(showslist.get(i),RowNumshows,0);
			RowNumshows++;
		}
	
//Capture all Fx shows in FxArrayList after clicking on Fx
		
		driver.navigate().to("https://www.fox.com/shows/collection/fx/");
		Fxlist=new ArrayList<String>();
		List<WebElement> Fxlistelement = driver.findElements(By.xpath("//div[contains(@class,'MovieTile_titleText_1Q4bx')]"));
		Iterator<WebElement> irfx = Fxlistelement.iterator();
		while(irfx.hasNext())
		{	
			Fxlist.add(irfx.next().getText());
		}
		
//From Shows Excel check in Arraylist if duplication
		
		for(int j=1;j<5;j++)
		{
			showsinexcelfx=excelobj.getCellData(j,0);
				if(Fxlist.contains(showsinexcelfx))
				{
					excelobj.setCellData("duplicate",j,1);
				}
				else
				{
					System.out.println("Duplicate Data Not Found");
					
				}
		}
		
//Capture all National Georaphic shows in NationalGeograhic ArrayList after clicking on Fx
	
		driver.navigate().to("https://www.fox.com/shows/collection/national%20geographic/");
		
		Thread.sleep(5000);
		
// Scroll as some elements load after scrolling 
// ToDo: Need to improve on Scrolling still not scrolling till the end of the Page
		
		JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		jse1.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
		
		
		NGlist=new ArrayList<String>();
		List<WebElement> NGlistelement = driver.findElements(By.xpath("//*[contains(@class,'MovieTile_titleText_1Q4bx')]"));
		Iterator<WebElement> irNG = NGlistelement.iterator();
		while(irNG.hasNext())
		{	
			NGlist.add(irNG.next().getText());
		}
		
//From Shows Excel check in Arraylist if duplication
		
		System.out.println("-------DEBUG-------------------");
		for(int k=1;k<5;k++)
		{
			
			showsinexcelNG=excelobj.getCellData(k,0);
			
				if(NGlist.contains(showsinexcelNG))
				{
					excelobj.setCellData("duplicate",k,1);
				}
				else
				{
					System.out.println("Duplicate Data Not Found");
					
				}
		}
	
		
// All Shows Tab //*[contains(@class,'Tile_title_2XOxg MovieTile_title_1u6rs')]
		
		driver.navigate().to("https://www.fox.com/shows/collection/all%20shows/");
		
		Thread.sleep(7000);
		
//TODO: Find a better way to scroll the page 
		
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
		Thread.sleep(7000);
		jse2.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
		Thread.sleep(7000);
		jse2.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
		
		Thread.sleep(7000);
		jse2.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
		
		Thread.sleep(7000);
		jse2.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
		
		Thread.sleep(7000);
		jse2.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
		
		Allshowslist=new ArrayList<String>();
		List<WebElement> AllShowslistelement = driver.findElements(By.xpath("//*[contains(@class,'Tile_title_2XOxg MovieTile_title_1u6rs')]"));
		Iterator<WebElement> irAllShws = AllShowslistelement.iterator();
		
		while(irAllShws.hasNext())
		{	
			System.out.println(irAllShws.next().getText());
			Allshowslist.add(irAllShws.next().getText());
		}
		
//From Shows Excel check in Arraylist if duplication
//TODO: Add the RowCount in Loop instead of 5.
		for(int l=1;l<5;l++)
		{
			Allshowsinexcel=excelobj.getCellData(l,0);
				if(Allshowslist.contains(Allshowsinexcel))
				{
					excelobj.setCellData("duplicate",l,1);
				}
				else
				{
					System.out.println("Duplicate Data Not Found");
					
				}
		}
	}

}
