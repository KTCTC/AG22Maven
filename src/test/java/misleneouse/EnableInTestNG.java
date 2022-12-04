package misleneouse;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EnableInTestNG {
	@Test (enabled = false)
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
}