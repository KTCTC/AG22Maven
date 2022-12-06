package brockenlink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BrockenLinkClass6 {

	@Test
	public void brockenLinkMethod() throws IOException {
		SoftAssert sAssert = new SoftAssert();
		String baseUrl = "https://demoqa.com/";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/links");

		List<WebElement> allLinksElements = driver.findElements(By.tagName("a"));

		for (WebElement each : allLinksElements) {
			String actualUrl = null;
			String href = each.getAttribute("href");
			if (href != null) {
				if (href.contains("https")) {
					actualUrl = each.getAttribute("href");
				} else {
					actualUrl = baseUrl + each.getAttribute("id");
				}				
				HttpURLConnection ht = getStatusOfURL(actualUrl);
			sAssert.assertTrue(ht.getResponseCode()<400, "Links = "+actualUrl+" is brocken with status code = "+ht.getResponseCode()+ " Response message = "+ht.getResponseMessage());
			}

		}
sAssert.assertAll();
	}

	public static HttpURLConnection getStatusOfURL(String link) {
		HttpURLConnection http = null;
		try {
			URL url = new URL(link);
			URLConnection uConn = url.openConnection();
			 http = (HttpURLConnection) uConn;
			http.setConnectTimeout(15000);
			http.connect();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return http;
	}

}
