package misleneouse;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DependentTestCases {
	@Test 
	public void toVerifyUserCanLoginWithValidUserNameAndPassword() {
		SoftAssert sAssert = new SoftAssert();
		System.out.println("to Verify User Can Login With Valid User Name And Password");
		boolean flag = true;
		boolean fl1 = false;
		sAssert.assertTrue(flag, "User name is not displayed");		
		sAssert.assertFalse(fl1, "Sign up option is still displayed");		
		System.out.println("After assert");
		sAssert.assertAll();
	}

	@Test 
	public void toVerifyUsedCanSendEmail() {
		SoftAssert sAssert = new SoftAssert();
		System.out.println("to Verify User Can Not Login With Invalid Credentials");
		String uName = "ABCD";
		sAssert.assertEquals(uName, "ertertet", "Username is not matching");
		String cntPrice = "304.5";
		sAssert.assertEquals(cntPrice, "304.5", "current share price is not as per expectation");
		sAssert.assertNotEquals(uName, "rtr");
		System.out.println("After equlity assertion");
		sAssert.assertAll();
	}


	@Test (dependsOnMethods = { "toVerifyUserCanLoginWithValidUserNameAndPassword","toVerifyUsedCanSendEmail"})
	public void verifyUserCountGetsReduced() {
		SoftAssert sAssert = new SoftAssert();
		System.out.println("verify User Count Gets Reduced");
		sAssert.assertEquals("Ab", "Ab");
		sAssert.assertTrue(false);
		sAssert.assertAll();
	}

}
