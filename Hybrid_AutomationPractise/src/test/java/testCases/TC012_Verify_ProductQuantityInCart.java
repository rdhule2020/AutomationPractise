package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;
import pageObjects.ProductsPage;
import pageObjects.ViewCartPage;
import testBase.BaseClass;

public class TC012_Verify_ProductQuantityInCart extends BaseClass {

	@Test
	public void Verify_ProductQuantityInCart() throws InterruptedException {
		SoftAssert sa = new SoftAssert();
		try {

			HomePage hp = new HomePage(driver);
			hp.click_Products();

			ProductsPage product = new ProductsPage(driver);
			logger.info("Click on View product 1");
			product.click_ViewProduct1();
			logger.info("Add product qunatity for current product");
			product.send_quantity();
			logger.info("Click on Add To Cart");
			product.Click_product1_AddToCart();
			logger.info("Click 'View Cart' button");
			product.click_lnk_viewCart();

			logger.info("Verify that product is displayed in cart page ");
			ViewCartPage vc = new ViewCartPage(driver);
			sa.assertEquals(vc.get_cart1_Description(), "Blue Top", "Description Mismatched");
			logger.info("Verify product1 quantity is 4 in cart ");
			sa.assertEquals(vc.get_cart1_Quantity(), "4");
		} catch (Exception e) {
			logger.error("Error occured while checking product 1 quantity in Cart" + e);
			sa.fail("Exception occured :" + e.getMessage());
		} finally {
			sa.assertAll();
		}
	}
}
