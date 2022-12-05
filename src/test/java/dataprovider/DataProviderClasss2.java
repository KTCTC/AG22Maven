package dataprovider;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import helper.ExcelHelper;

public class DataProviderClasss2 {
	WebDriver driver  = null;
	@BeforeClass
	public void lounchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
		 driver = new ChromeDriver();		
		driver.get("https://demoqa.com/webtables");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test (dataProvider = "users")
	public void verifyNewUserCanBeAddedInSystem(String fname,String lname, String email, String age, String salary, String dep)
	{
		
		driver.findElement(By.id("addNewRecordButton")).click();
		driver.findElement(By.id("firstName")).sendKeys(fname);
		driver.findElement(By.id("lastName")).sendKeys(lname);
		driver.findElement(By.id("userEmail")).sendKeys(email);
		driver.findElement(By.id("age")).sendKeys(age);
		driver.findElement(By.id("salary")).sendKeys(salary);
		driver.findElement(By.id("department")).sendKeys(dep);
		driver.findElement(By.id("submit")).click();
		
	}
	
	@DataProvider (name = "users")
	public String[][] getCredentials()
	{
		ExcelHelper exhelp = new ExcelHelper("KT.xlsx", "July");
		ArrayList<String> unames = exhelp.getValuesFromRequiredColumn(0);
		ArrayList<String> lnames = exhelp.getValuesFromRequiredColumn(1);
		
		String ar[][] = {{"Amit","patil","am@p.com","22","23456","IT"},{"Sanket","P","sanket@gmail.com","25","54567","HR"}};
		return ar;
	}

}
