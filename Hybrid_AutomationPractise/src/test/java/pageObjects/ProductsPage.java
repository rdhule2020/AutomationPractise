package pageObjects;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

	// Product1 : Blue Top
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
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
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
	
	
	
//	@FindBy(xpath="")WebElement ;
//	@FindBy(xpath="")WebElement ;
//	@FindBy(xpath="")WebElement ;
//	@FindBy(xpath="")WebElement ;
//	@FindBy(xpath="")WebElement ;
//
//	@FindBy(xpath="")WebElement ;

	
	
	
	
	
}
