package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC004_RgisterUserWithExistingEmail extends BaseClass {

	@Test
	public void verify_RegistrationWithExistingEmail() {

		try
		{
		HomePage hp = new HomePage(driver);
		hp.click_signUpLoginLink();

		LoginPage l = new LoginPage(driver);
		if (l.Check_NewUserSignUpmsg().equals("New User Signup!")) {
			logger.info("Send name");
			l.send_Name(p.getProperty("name"));
			logger.info("Send Existing Email");
			l.send_SignupEmailAddress(p.getProperty("email"));
			logger.info("Click signUp");
			l.clickSignUp();
			logger.info("Verify Error Message");
			Assert.assertEquals(l.is_EmailAlreadyExists(), true);
			logger.info("Error Message displayed as 'Email Address already exist!' ");
		} else {
			logger.error("registration Test failed");
			logger.debug("Debug logs...");
			Assert.assertTrue(false);
		}
	
	}catch(Exception e)
	{
		Assert.fail();
	}
}
}