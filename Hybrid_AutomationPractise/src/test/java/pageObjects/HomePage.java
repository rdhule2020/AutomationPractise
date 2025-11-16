package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
	public WebDriverWait wait;

	public HomePage(WebDriver driver) {
		super(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class='nav navbar-nav']/child::li//a[@href='/login']")
	WebElement link_signUpLogin;
	@FindBy(xpath = "//*[text()=' Logout']")
	WebElement logout;
	@FindBy(xpath = "//*[text()=' Products']")
	WebElement products;
	@FindBy(xpath = "//*[text()=' Cart']")
	WebElement carts;
	@FindBy(xpath = "//*[text()=' Contact us']")
	WebElement ContactUs;
	@FindBy(xpath = "//*[text()=' Test Cases']")
	WebElement TestCases;
	@FindBy(xpath = "//*[text()='Subscription']")
	WebElement Title_subscription;
	@FindBy(xpath = "//*[@id='susbscribe_email']")
	WebElement txt_SubscribeEmail;
	@FindBy(xpath = "//*[@id='subscribe']")
	WebElement btn_subscribe;
	@FindBy(xpath = "//div[text()='You have been successfully subscribed!']")
	WebElement msg_success;

	public void click_signUpLoginLink() {
		wait.until(ExpectedConditions.elementToBeClickable(link_signUpLogin)).click();
	}

	public void click_Logout() {
		wait.until(ExpectedConditions.elementToBeClickable(logout)).click();
	}

	public void click_Products() {
		wait.until(ExpectedConditions.elementToBeClickable(products)).click();
	}

	public void click_Carts() {
		wait.until(ExpectedConditions.elementToBeClickable(carts)).click();
	}

	public void click_ContactUs() {
		wait.until(ExpectedConditions.elementToBeClickable(ContactUs)).click();
	}

	public void click_TestCases() {
		wait.until(ExpectedConditions.elementToBeClickable(TestCases)).click();
	}

	public boolean SubscriptionIsExist() {
		return Title_subscription.isDisplayed();
	}

	public void send_SubscriptionEmail(String value) {
		txt_SubscribeEmail.sendKeys(value);
	}
	
	public void Click_Subscribe()
	{
		btn_subscribe.click();
	}

	public void ScrollToSubscription()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",Title_subscription);
	}
	
	public boolean IsSuccessMsgExist()
	{
		return msg_success.isDisplayed();
	}
}
