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

public class BrockenLinkClass5 {

	@Test
	public void brockenLinkMethod() throws IOException {
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

				System.out.println(actualUrl);
				printStatusOfURL(actualUrl);
			}

		}

	}

	public static void printStatusOfURL(String link) {

		try {
			URL url = new URL(link);
			URLConnection uConn = url.openConnection();
			HttpURLConnection http = (HttpURLConnection) uConn;
			http.setConnectTimeout(15000);
			http.connect();
			int code = http.getResponseCode();
			String msg = http.getResponseMessage();
			System.out.println(code);
			System.out.println(msg);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
