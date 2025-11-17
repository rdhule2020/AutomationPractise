package pageObjects;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {

	public ProductsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[text()='All Products']")
	WebElement Title_AllProducts;

	public boolean isAllProductsExists() {
		return Title_AllProducts.isDisplayed();
	}

	// Product1 : Blue Top - TC007
	@FindBy(xpath = "//div[@class='col-sm-4']//ul[@class='nav nav-pills nav-justified']//a[@href='/product_details/1']")
	WebElement btn_ViewProduct1;
	@FindBy(xpath = "//h2[text()='Blue Top']")
	WebElement product1_Name;
	@FindBy(xpath = "//p[text()='Category: Women > Tops']")
	WebElement product1_Category;
	@FindBy(xpath = "//span[text()='Rs. 500']")
	WebElement product1_Price;
	@FindBy(xpath = "//*[text()=' In Stock']")
	WebElement product1_Availability;
	@FindBy(xpath = "//*[text()=' New']")
	WebElement product1_Condition;
	@FindBy(xpath = "//*[text()=' Polo']")
	WebElement product1_Brand;

	public void click_ViewProduct1() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", btn_ViewProduct1);
		wait.until(ExpectedConditions.elementToBeClickable(btn_ViewProduct1));
		try {
			btn_ViewProduct1.click();
		} catch (ElementClickInterceptedException e) {
			// If still blocked, try JS click as fallback
			jse.executeScript("arguments[0].click();", btn_ViewProduct1);
		}
	}

	public String get_Product1_Name() {
		try {
			return product1_Name.getText();
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public String get_product1_Category() {
		try {
			return product1_Category.getText();
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public String get_product1_Price() {
		try {
			return product1_Price.getText();
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public String get_product1_Availability() {
		try {
			return product1_Availability.getText();
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public String get_product1_Condition() {
		try {
			return product1_Condition.getText();
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public String get_product1_Brand() {
		try {
			return product1_Brand.getText();
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	// Search product -TC008
	@FindBy(xpath = "//*[text()='All Products']")
	WebElement title_AllProducts;
	@FindBy(xpath = "//input[@id='search_product']")
	WebElement txt_searchProduct;
	@FindBy(xpath = "//button[@id='submit_search']")
	WebElement btn_search;
	@FindBy(xpath = "//*[text()='Searched Products']")
	WebElement Title_searchedProduct;
	@FindBy(xpath = "//div[@class='productinfo text-center']")
	WebElement reqProduct;

	public String get_Title_AllProducts() {
		try {
			return title_AllProducts.getText();
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public void send_productName(String value) {
		txt_searchProduct.sendKeys(value);
	}

	public void click_Search() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_search)).click();
	}

	public String getTitle_SearchProduct() {
		try {
			return Title_searchedProduct.getText();
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

	public boolean isReqProductExist() {
		return reqProduct.isDisplayed();
	}

	// AddProducts in Cart - TC011
	@FindBy(xpath = "//button[@type='button']")
	WebElement product1_AddToCart;
	@FindBy(xpath = "//*[text()='View Cart']")
	WebElement lnk_viewCart;
	@FindBy(xpath = "//button[@class='btn btn-success close-modal btn-block']")
	WebElement btn_ContinueShopping;
	@FindBy(xpath = "//div[@class='col-sm-4']//ul[@class='nav nav-pills nav-justified']//a[@href='/product_details/2']")
	WebElement btn_ViewProduct2;
	@FindBy(xpath = "//button[@type='button']")
	WebElement product2_AddToCart;

	// identify elements on View cart as per test case and write a script

	public void Click_product1_AddToCart() {
		product1_AddToCart.click();

	}

	public void click_ContinueShopping() {

		wait.until(ExpectedConditions.elementToBeClickable(btn_ContinueShopping)).click();
		driver.navigate().back();
	}

	public void click_lnk_viewCart() {
		lnk_viewCart.click();
	}

	public void click_ViewProduct2() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", btn_ViewProduct2);
		wait.until(ExpectedConditions.elementToBeClickable(btn_ViewProduct2));
		try {
			btn_ViewProduct2.click();
		} catch (ElementClickInterceptedException e) {
			// If still blocked, try JS click as fallback
			jse.executeScript("arguments[0].click();", btn_ViewProduct2);
		}
	}

	public void Click_product2_AddToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(product2_AddToCart)).click();

	}
	
	
	
	// TC012 :
		@FindBy(xpath="//input[@type='number']")WebElement num_quantity;
		
		
		public void send_quantity()
		{
			num_quantity.clear();
			
			num_quantity.sendKeys("4");
		}

}
