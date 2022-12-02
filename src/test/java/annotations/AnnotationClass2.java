package annotations;

import org.testng.annotations.Test;

import testbase.TestBase;

public class AnnotationClass2 extends TestBase{
	@Test
	public void verifyUserCanBeAdded() {
		System.out.println("verify User Can Be Added");
	}

	@Test
	public void verifyUserCanBeEdited() {
		System.out.println("verify User Can BeEdited");
	}

}
