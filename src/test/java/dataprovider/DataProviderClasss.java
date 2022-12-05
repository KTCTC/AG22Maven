package dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClasss {
	
	@Test (dataProvider = "uname", enabled = false)
	public void verifyUserCanBeAdded(String a)
	{
		System.out.println(a);
	}
	@DataProvider (name = "uname")
	public String[] getUserName()
	{
		String arr[] = {"amit", "sanket", "abcd"};
		return arr;
	}
	
	@Test (dataProvider = "credentials")
	public void verifyCredentialsOfUser(String name,String pass)
	{
		System.out.println(name);
		System.out.println(pass);
	}
	
	@DataProvider (name = "credentials")
	public String[][] getCredentials()
	{
		String ar[][] = {{"Amit","Amit@123"},{"Sanket","Sak@2222"}};
		return ar;
	}

}
