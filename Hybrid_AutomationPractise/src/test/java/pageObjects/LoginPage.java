package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	//SignUp
	@FindBy(xpath="//h2[text()='New User Signup!']")WebElement mgs_NewUserSignUp;
	@FindBy(xpath="//input[@data-qa='signup-name']")WebElement txt_name;
	@FindBy(xpath="//input[@data-qa='signup-email']")WebElement txt_signUpEmailAddress;
	@FindBy(xpath="//button[@data-qa='signup-button']")WebElement btn_SignUp;
	@FindBy(xpath="//p[text()='Email Address already exist!']")WebElement msg_EmailAlreadyExists;
	public String Check_NewUserSignUpmsg()
	{
		try {
			return ( mgs_NewUserSignUp.getText());
		}catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
	public void send_Name(String name)
	{
		txt_name.sendKeys(name);
	}
	
	public void send_SignupEmailAddress(String email)
	{
		wait.until(ExpectedConditions.elementToBeClickable(txt_signUpEmailAddress)).sendKeys(email);
	
	}
	
	public void clickSignUp()
	{
		wait.until(ExpectedConditions.elementToBeClickable(btn_SignUp)).click();
	}
	
	public boolean is_EmailAlreadyExists()
	{
		return msg_EmailAlreadyExists.isDisplayed();
	}
	//-----------------------------------------------------------------------------------//
	
	//Login
	@FindBy(xpath="//h2[text()='Login to your account']")WebElement mgs_LoginToYourAcc;
	@FindBy(xpath="//input[@data-qa='login-email']")WebElement txt_loginEmailAddress;
	@FindBy(xpath="//input[@data-qa='login-password']")WebElement txt_Password;
	@FindBy(xpath="//button[@data-qa='login-button']")WebElement btn_Login;
	
	@FindBy(xpath="//p[text()='Your email or password is incorrect!']")WebElement msg_incorrectcredentials;
	
	public String check_loginToYourAccMsg()
	{
		try {
			return ( mgs_LoginToYourAcc.getText());
		}catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
	public void send_LoginEmailAddress(String email)
	{
		wait.until(ExpectedConditions.elementToBeClickable(txt_loginEmailAddress)).sendKeys(email);
	}
	
	public void send_password(String pass)
	{
		wait.until(ExpectedConditions.elementToBeClickable(txt_Password)).sendKeys(pass);
	}
	
	public void clickLogin()
	{
		btn_Login.click();
	}
	
	public String get_msg_IncorrectCredentials()
	{
		try {
			return ( msg_incorrectcredentials.getText());
		}catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
	//-----------------------------------------------------------------------------------//
	
	
}
