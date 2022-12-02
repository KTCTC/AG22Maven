package testbase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestBase {
	@BeforeMethod
	public void beforeMethodAnnotation() {
		System.out.println("before Method Annotation");
	}

	@AfterMethod
	public void afterMethodAnnotation() {
		System.out.println("after Method Annotation");
	}

	@BeforeClass
	public void beforeClassAnnotation() {
		System.out.println("before Class Annotation");
	}

	@AfterClass
	public void afterClassAnnotation() {
		System.out.println("after Class Annotation");
	}
	@BeforeTest
	public void beforeTestAnnotation()
	{
	   System.out.println("before Test Annotation");	
	}
	@AfterTest
	public void afterTestAnnotation()
	{
		System.out.println("after Test Annotation");
	}
	@BeforeSuite
	public void beforeSuiteAnnotation()
	{
		System.out.println("before Suite Annotation");
	}
	@AfterSuite
	public void afterSuiteAnnotation()
	{
		System.out.println("after Suite Annotation");
	}

}
