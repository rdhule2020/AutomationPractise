package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage {

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[text()='Get In Touch']")
	WebElement msg_getIntouch;
	@FindBy(xpath = "//input[@name='name']")
	WebElement name;
	@FindBy(xpath = "//input[@name='email']")
	WebElement email;
	@FindBy(xpath = "//input[@name='subject']")
	WebElement subject;
	@FindBy(xpath = "//textarea[@name='message']")
	WebElement message;
	@FindBy(xpath = "//input[@type='file']")
	WebElement btn_uploadFile;
	@FindBy(xpath = "//input[@name='submit']")
	WebElement btn_submit;
	public String filepath = "C:\\Users\\RAHUL\\HybridAutomationFramework\\Hybrid_AutomationPractise\\testData\\index.txt";
	@FindBy(xpath = "//*[@class='status alert alert-success']")
	WebElement msg_success;
	@FindBy(xpath = "//i[@class='fa fa-angle-double-left']")
	WebElement btn_Home;

	public boolean Is_msgGetInTouchExists() {
		return msg_getIntouch.isDisplayed();
	}

	public void send_Name(String value) {
		name.sendKeys(value);
	}

	public void send_Email(String value) {
		email.sendKeys(value);
	}

	public void send_Subject(String value) {
		subject.sendKeys(value);
	}

	public void send_Message(String value) {
		message.sendKeys(value);
	}

	public void click_upload() {
		btn_uploadFile.sendKeys(filepath);
	}

	public void Submit() {
		btn_submit.click();
	}

	public void Handle_Popup() {
		driver.switchTo().alert().accept();
	}

	public boolean isSuccessMessageExist() {
		return msg_success.isDisplayed();
	}

	public void click_Home() {
		btn_Home.click();
	}
}
