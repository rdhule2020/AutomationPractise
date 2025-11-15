
package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;
import pageObjects.ProductsPage;
import testBase.BaseClass;

public class TC007_VerifyAllProductsAndProductDetailPage extends BaseClass {

	@Test
	public void verifyAllProductsAndProductDetailPage() {
		logger.info("===== Starting TC007_VerifyAllProductsAndProductDetailPage =====");
		SoftAssert sa = new SoftAssert();
		try {
			HomePage hp = new HomePage(driver);
			hp.click_Products();

			ProductsPage productsPage = new ProductsPage(driver);
			boolean allProductsVisible = productsPage.isAllProductsExists();

			sa.assertTrue(allProductsVisible, "All Products section is not visible on Products Page");

			if (allProductsVisible) {
				logger.info("Clicking 'View Product' for Product 1");
				productsPage.click_ViewProduct1();

				logger.info("Validating Product Details");
				logger.info("Check Product Name");
				sa.assertEquals(productsPage.get_Product1_Name(), "Blue Top", "Product name mismatch");
				logger.info("Check category");
				sa.assertEquals(productsPage.get_product1_Category(), "Category: Women > Tops", "Category mismatch");
				logger.info("Check price");
				sa.assertEquals(productsPage.get_product1_Price(), "Rs. 500", "Price mismatch");
				logger.info("Check Availability");
				sa.assertEquals(productsPage.get_product1_Availability(), "Availability: In Stock",
						"Availability mismatch");
				logger.info("Check condition");
				sa.assertEquals(productsPage.get_product1_Condition(), "Condition: New", "Condition mismatch");
				logger.info("Check Brand");
				sa.assertEquals(productsPage.get_product1_Brand(), "Brand: Polo", "Brand mismatch");
				logger.info("All product details verified successfully");
			} else {
				logger.error("All Products section was not found. Test failed.");

			}
		} catch (Exception e) {
			logger.error("Exception occurred while verifying product details", e);
			sa.fail("Exception occurred: " + e.getMessage());
		} finally {
			sa.assertAll();
		}

		logger.info("===== Completed TC007_VerifyAllProductsAndProductDetailPage =====");
	}
}
