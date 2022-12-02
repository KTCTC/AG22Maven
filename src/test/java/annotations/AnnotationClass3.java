package annotations;

import org.testng.annotations.Test;

import testbase.TestBase;

public class AnnotationClass3 extends TestBase{
	@Test
	public void verifyUserCanBeDeleted() {
		System.out.println("verify User Can Be Deleted");
	}

	@Test
	public void verifyUserCountGetsReduced() {
		System.out.println("verify User Count Gets Reduced");
	}


}
