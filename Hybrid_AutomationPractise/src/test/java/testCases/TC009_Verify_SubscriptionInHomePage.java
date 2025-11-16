package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC009_Verify_SubscriptionInHomePage extends BaseClass {

	
	@Test
	public void Verify_SubscriptionInHomePage()
	{
		SoftAssert sa = new SoftAssert();
		
		try
		{
		logger.info("Start executing Test Case TC009_Verify_SubscriptionInHomePage ");
		logger.info("Scroll Down to Footer");
		HomePage hp = new HomePage(driver);
		hp.ScrollToSubscription();
		logger.info("Verify Subscription Title");
		boolean value = hp.SubscriptionIsExist();
		sa.assertEquals(value, true, "Subscription Title not available");
		logger.info("Send Subscription email");
		hp.send_SubscriptionEmail(p.getProperty("email"));
		logger.info("Click Subscribe");
		hp.Click_Subscribe();
		logger.info("Verify success message 'You have been successfully subscribed!' is visible");
		sa.assertEquals(hp.IsSuccessMsgExist(), true);
		
		}catch(Exception e)
		{
			logger.error("Exception occurred while verifying subscription", e);
			sa.fail("Exception occurred: " + e.getMessage());
		}finally
		{
			sa.assertAll();
		}

		logger.info("Test Case TC009_Verify_SubscriptionInHomePage Executed Successfully");
	}
}
