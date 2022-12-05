package screencap;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScreenCaptureClass {
	@Test
	public void verifyFileCanBeUploaded() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.guru99.com/test/upload/");
		driver.findElement(By.id("uploadfile_0")).sendKeys(System.getProperty("user.dir") +"\\KT.xlsx");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("submitbutton")).click();
		
		WebDriverWait wt = new WebDriverWait(driver, 5);
	  wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='res']/center[contains(text(),'1 file')]")));	
		
	String msg = driver.findElement(By.xpath("//*[@id='res']/center")).getText();
	System.out.println(msg);
	
	Assert.assertEquals(msg, "1 file\nhas been successfully uploaded.");
	
	
	TakesScreenshot ts = ((TakesScreenshot)driver);
	File f = ts.getScreenshotAs(OutputType.FILE);
	
	File out = new File(System.getProperty("user.dir")+"\\abcd.png");
	FileUtils.copyFile(f, out);

	}
	

}
