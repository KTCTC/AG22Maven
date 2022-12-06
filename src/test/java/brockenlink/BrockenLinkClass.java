package brockenlink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.testng.annotations.Test;

public class BrockenLinkClass {
	
	@Test
	public void brockenLinkMethod() throws IOException
	{
		String link = "https://www.facebook.com/";
		
		URL url = new URL(link);		
		URLConnection uConn = url.openConnection();
		HttpURLConnection http = (HttpURLConnection)uConn;			
		http.setConnectTimeout(15000);
		http.connect();		
		int code = http.getResponseCode();
		String msg = http.getResponseMessage();
		System.out.println(code);
		System.out.println(msg);
		
	}

}
