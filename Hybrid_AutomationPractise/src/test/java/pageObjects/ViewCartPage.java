package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ViewCartPage extends BasePage{

	public ViewCartPage(WebDriver driver) {
		super(driver);
		
	}
	//Cart_Item1
	@FindBy(xpath="//a[text()='Blue Top']")WebElement cart1_Description;
	@FindBy(xpath="//tr[@id='product-1']//td[3]")WebElement cart1_Price;
	@FindBy(xpath="//tr[@id='product-1']//td[4]")WebElement cart1_Quantity;
	@FindBy(xpath="//tr[@id='product-1']//td[5]")WebElement cart1_Total;
	@FindBy(xpath="//tr[@id='product-1']//td//a[@class='cart_quantity_delete']")WebElement cart1_Delete;
	
	public String get_cart1_Description()
	{
		try
		{
		return cart1_Description.getText();
		}catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
	public String get_cart1_Price()
	{
		try
		{
		return cart1_Price.getText();
		}catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	public String get_cart1_Quantity()
	{
		try
		{
		return cart1_Quantity.getText();
		}catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	public String get_cart1_Total()
	{
		try
		{
		return cart1_Total.getText();
		}catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
	public void Click_cart1_Delete()
	{
		wait.until(ExpectedConditions.elementToBeClickable(cart1_Delete)).click();
		
	}
	
	//Cart_Item2
	@FindBy(xpath="//a[text()='Men Tshirt']")WebElement cart2_Description;
	@FindBy(xpath="//tr[@id='product-2']//td[3]")WebElement cart2_Price;
	@FindBy(xpath="//tr[@id='product-2']//td[4]")WebElement cart2_Quantity;
	@FindBy(xpath="//tr[@id='product-2']//td[5]")WebElement cart2_Total;
	@FindBy(xpath="//tr[@id='product-2']//td//a[@class='cart_quantity_delete']")WebElement cart2_Delete;
	
	public String get_cart2_Description()
	{
		try
		{
		return cart2_Description.getText();
		}catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	public String get_cart2_Price()
	{
		try
		{
		return cart2_Price.getText();
		}catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	public String get_cart2_Quantity()
	{
		try
		{
		return cart2_Quantity.getText();
		}catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	public String get_cart2_Total()
	{
		try
		{
		return cart2_Total.getText();
		}catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
	public void Click_cart2_Delete()
	{
		wait.until(ExpectedConditions.elementToBeClickable(cart2_Delete)).click();
		
	}
}
