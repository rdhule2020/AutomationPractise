package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

	public CartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[text()='Subscription']")
	WebElement ele_CartSubscription;
	@FindBy(xpath = "//*[@id='susbscribe_email']")
	WebElement ele_CartEmail;
	@FindBy(xpath = "//*[@id='subscribe']")
	WebElement btn_CartSubscribe;
	@FindBy(xpath = "//div[text()='You have been successfully subscribed!']")
	WebElement msg_CartSuccess;
//	
//	@FindBy(xpath="")WebElement ele;
//	@FindBy(xpath="")WebElement ele;
//	@FindBy(xpath="")WebElement ele;
//	@FindBy(xpath="")WebElement ele;
//	@FindBy(xpath="")WebElement ele;

	public void ScrollToCartSubscription() {
		wait.until(ExpectedConditions.visibilityOf(ele_CartSubscription));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele_CartSubscription);
	}

	public void send_CartEmail(String value) {
		wait.until(ExpectedConditions.elementToBeClickable(ele_CartEmail));
		ele_CartEmail.sendKeys(value);
	}

	public void click_CartSubscribe() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_CartSubscribe));
		btn_CartSubscribe.click();
	}

	public boolean IsCartSuccessMsgExist() {
		return msg_CartSuccess.isDisplayed();
	}
}
