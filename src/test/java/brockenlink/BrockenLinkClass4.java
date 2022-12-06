package brockenlink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrockenLinkClass4 {
	
	@Test
	public void brockenLinkMethod() throws IOException
	{
		String baseUrl = "https://demoqa.com/";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/links");
		
		List<WebElement> allLinksElements = driver.findElements(By.tagName("a"));
		
		for (WebElement each:allLinksElements)
		{
			String actualUrl = null;
			String href = each.getAttribute("href");
			
			if (href!=null && href.contains("https"))
			{
				actualUrl = each.getAttribute("href");
			}
			else
			{
				actualUrl = baseUrl+each.getAttribute("id");
			}
			
			System.out.println(actualUrl);
			
		}
		
		
	}

}
