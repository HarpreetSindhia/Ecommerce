package MyEcommerce.Ecommerce.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MyEcommerce.Ecommerce.abstractcomponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents {

	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("Aus");
	
	//List<WebElement> countryList = driver.findElements(By.cssSelector(".ta-results button"));
	
	//WebElement selectCountry = countryList.stream().filter(a -> a.getText().equalsIgnoreCase("Australia")).findFirst().orElse(null);
	
	//selectCountry.click();
	
	//driver.findElement(By.cssSelector(".action__submit")).click();
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement shippingCountry;
	
	public void selectShipCountry(String countryPro)
	{
		shippingCountry.sendKeys(countryPro);
	}
	
	@FindBy(css=".ta-results button")
	List<WebElement> countryList;
	
	@FindBy(css=".action__submit")
	WebElement placeOrder;
	
	public OrdersPage shippingCountry(String country)
	{
		WebElement selectCountry = countryList.stream().filter(a -> a.getText().equalsIgnoreCase(country)).findFirst().orElse(null);
		
		selectCountry.click();
		placeOrder.click();
		OrdersPage pOrders = new OrdersPage(driver);
		return pOrders;
	}
	
	
}
