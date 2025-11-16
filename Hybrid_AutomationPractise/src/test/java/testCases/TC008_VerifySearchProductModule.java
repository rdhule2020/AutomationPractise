package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;
import pageObjects.ProductsPage;
import testBase.BaseClass;

public class TC008_VerifySearchProductModule extends BaseClass {

	@Test
	public void verify_SearchProductModule() {
		SoftAssert sa = new SoftAssert();
		logger.info("Start TC008_VerifySearchProductModule Verification");
		try
		{
		HomePage hp = new HomePage(driver);
		logger.info("Click on Products button");
		hp.click_Products();
		
		ProductsPage pro = new ProductsPage(driver);
		logger.info("Verify user is navigated to ALL PRODUCTS page successfully ");
		
		String Title = pro.get_Title_AllProducts();
		logger.info("Enter product name in search input and click search button");
		if(Title.equalsIgnoreCase("All Products"))
		{
			logger.info("Enter Products name");
			pro.send_productName(p.getProperty("ProductName"));
			logger.info("Click search button");
			pro.click_Search();
			logger.info("Verify Searched Products Title");
			sa.assertEquals(pro.getTitle_SearchProduct(), "SEARCHED PRODUCTS");
			sa.assertEquals(pro.isReqProductExist(), true);
		}else
		{
			logger.error("Test Case failed");
		}
		}catch(Exception e)
		{
			logger.error("Exception occurred while verifying product details", e);
			sa.fail("Exception occurred: " + e.getMessage());
		}finally
		{
			sa.assertAll();
		}
		logger.info("TC008_VerifySearchProductModule  Verified ");
	}

}
