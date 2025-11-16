package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.CartPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC010_Verify_SubscriptionInCartPage extends BaseClass{

	
	@Test
	public void Verify_SubscriptionInCartPage()
	{
		SoftAssert sa = new SoftAssert();
		try
		{
		logger.info("Strted Executing TC010_Verify_SubscriptionInCartPage");
		logger.info("Navigate to Home Page");
		HomePage hp = new HomePage(driver);
		logger.info("Click on Cart");
		hp.click_Carts();
		logger.info(" Scroll down to subscription");
		CartPage cart = new CartPage(driver);
		cart.ScrollToCartSubscription();
		
		logger.info(" Enter email address in input and click arrow button");
		cart.send_CartEmail(p.getProperty("email"));
		cart.click_CartSubscribe();
		logger.info("Verify Subscription Success message");
		sa.assertEquals(cart.IsCartSuccessMsgExist(), true, "Success message not displayed");
		
		}
		catch(Exception e)
		{
			logger.error("Exception occurred while verifying Cart subscription", e);
			sa.fail("Exception occurred: " + e.getMessage());
		}
		finally
		{
			sa.assertAll();
		}
		logger.info("Executed TC010_Verify_SubscriptionInCartPage Successfully");//	
//		logger.info("");
//		logger.info("");
//		logger.info("");
	}
}
