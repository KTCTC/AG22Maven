package misleneouse;

import org.testng.annotations.Test;

public class PriorityClass {
	
	@Test (priority = -2, dependsOnMethods = "bMethod", enabled = false)
	public void cMethod()
	{
		System.out.println("cMethod");
	}
	@Test (priority = -12, dependsOnMethods = "bMethod")
	public void d()
	{
		System.out.println("d");
	}
	@Test (priority = 3)
	public void aMethod()
	{
		System.out.println("aMethod");
	}
	@Test (priority = 3)
	public void bMethod()
	{
		System.out.println("bMethod");
	}
	@Test
	public void a()
	{
		System.out.println("a");
	}
	@Test
	public void b()
	{
		System.out.println("b");
	}
}
