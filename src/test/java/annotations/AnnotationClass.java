package annotations;


import org.testng.annotations.Test;

import testbase.TestBase;

public class AnnotationClass extends TestBase{

	@Test
	public void toVerifyUserCanLoginWithValidUserNameAndPassword() {
		System.out.println("to Verify User Can Login With Valid User Name And Password");
	}

	@Test
	public void toVerifyUserCanNotLoginWithInvalidCredentials() {
		System.out.println("to Verify User Can Not Login With Invalid Credentials");
	}

	
}
