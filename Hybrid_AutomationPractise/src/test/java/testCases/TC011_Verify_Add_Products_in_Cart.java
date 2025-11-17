package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;
import pageObjects.ProductsPage;
import pageObjects.ViewCartPage;
import testBase.BaseClass;

public class TC011_Verify_Add_Products_in_Cart extends BaseClass {

	public ViewCartPage viewcart;

	@Test
	public void Verify_Add_Products_in_Cart() {

		SoftAssert sa = new SoftAssert();
		try {

			HomePage h = new HomePage(driver);
			logger.info("Click on product");
			h.click_Products();
			ProductsPage product = new ProductsPage(driver);
			logger.info("Click on View product 1");
			product.click_ViewProduct1();
			logger.info("Add product 1 to cart");
			product.Click_product1_AddToCart();
			logger.info("Click on Continue Shpping");
			product.click_ContinueShopping();
			logger.info("Click on View product 2");
			product.click_ViewProduct2();
			logger.info("Add product 2 to cart");
			product.Click_product2_AddToCart();
			logger.info("Click on View product");
			product.click_lnk_viewCart();
			viewcart = new ViewCartPage(driver);
			logger.info("Verify Product1 Details in Cart");
			sa.assertEquals(viewcart.get_cart1_Description(), "Blue Top", "Description Mismatched");
			sa.assertEquals(viewcart.get_cart1_Price(), "Rs. 500");
			sa.assertEquals(viewcart.get_cart1_Quantity(), "1");
			sa.assertEquals(viewcart.get_cart1_Total(), "Rs. 500");
			logger.info("Verify Product2 Details in Cart");
			sa.assertEquals(viewcart.get_cart2_Description(), "Men Tshirt", "Description Mismatched");
			sa.assertEquals(viewcart.get_cart2_Price(), "Rs. 400");
			sa.assertEquals(viewcart.get_cart2_Quantity(), "1");
			sa.assertEquals(viewcart.get_cart2_Total(), "Rs. 400");
			logger.info("Remove Product 1 from cart");
			viewcart.Click_cart1_Delete();
			logger.info("Remove Product 2 from cart");
			viewcart.Click_cart2_Delete();

		} catch (Exception e) {
			logger.error("Error occured while adding product 1 in Cart" + e);
			sa.fail("Exception occured :" + e.getMessage());
		} finally {
			sa.assertAll();
		}
	}

}
