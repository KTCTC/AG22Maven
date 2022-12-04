package assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

import annotations.AnnotationClass;

public class AssertsInTestNG {
	AnnotationClass obj;
	@Test
	public void toVerifyUserCanLoginWithValidUserNameAndPassword() {
		System.out.println("to Verify User Can Login With Valid User Name And Password");
		boolean flag = false;
		boolean fl1 = true;
		Assert.assertTrue(flag, "User name is not displayed");
		Assert.assertFalse(fl1, "Sign up option is still displayed");
		System.out.println("After assert");
	}

	@Test
	public void toVerifyUserCanNotLoginWithInvalidCredentials() {
		System.out.println("to Verify User Can Not Login With Invalid Credentials");
		String uName = "ABCD";
		Assert.assertEquals(uName, "abcd", "Username is not matching");
		String cntPrice = "304.5";
		Assert.assertEquals(cntPrice, "304.5", "current share price is not as per expectation");
		Assert.assertNotEquals(uName, "ABCD");
		System.out.println("After equlity assertion");
	}
	@Test
	public void verifyUserCanBeDeleted() {
		System.out.println("verify User Can Be Deleted");
		Assert.assertNull(obj, "Object is falsly initialized");
		Assert.assertNotNull(obj, "Object still null");
	}

	@Test
	public void verifyUserCountGetsReduced() {
		System.out.println("verify User Count Gets Reduced");
		Assert.assertEquals("Ab", "Ab");
		Assert.assertTrue(false);
	}
	
	

}
