package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC003_AccountLoginTestWithInvalidCredentials extends BaseClass{
	
	@Test
	public void Verify_LoginTestWithInvalidCredentials()
	{
		
		SoftAssert sa = new SoftAssert();
		logger.info("*** Login Test with Incorrect email and Password ***");
		
		HomePage home = new HomePage(driver);
		
		try
		{
		home.click_signUpLoginLink();
		
		LoginPage login = new LoginPage(driver);
		
		if(login.check_loginToYourAccMsg().equals("Login to your account"))
		{
			logger.info("Enter email Address");
			login.send_LoginEmailAddress(p.getProperty("email"));
			logger.info("Enter Password");
			login.send_password(p.getProperty("password"));
			logger.info("Click Login");
			login.clickLogin();
			logger.info("Verify Error message");
			sa.assertEquals(login.get_msg_IncorrectCredentials(), "Your email or password is incorrect!", "Error Message doesn't match");
			logger.info("Test Case Passed");
		}else
		{
			logger.error("Login failed");
			logger.debug("Debug logs...");
			sa.assertTrue(false);
		}
		}catch(Exception e)
		{
			logger.error("Exception occurred while verifying TC003", e);
			sa.fail("Exception occurred: " + e.getMessage());
		}finally
		{
			sa.assertAll();
		}
		
	}

}
