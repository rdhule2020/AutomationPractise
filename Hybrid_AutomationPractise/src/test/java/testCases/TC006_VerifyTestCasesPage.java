package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.TestCasesPage;
import testBase.BaseClass;

public class TC006_VerifyTestCasesPage extends BaseClass{
	
	
	@Test
	
	public void  verify_TestCasesPage()
	{
		HomePage hp = new HomePage(driver);
		hp.click_TestCases();
		
		TestCasesPage tc = new TestCasesPage(driver);
		try {
		Assert.assertEquals(tc.isTestCasesExist(), true, "Test Case TC006 Failed");
		}catch(Exception e)
		{
			logger.error("Test case Failed");
			logger.debug("Debug logs...");
			Assert.fail();
		}
	}

}
