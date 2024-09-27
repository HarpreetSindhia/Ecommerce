package MyEcommerce.Ecommerce.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MyEcommerce.Ecommerce.abstractcomponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents {

	WebDriver driver;
	Actions actions;
	
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actions = new Actions(driver);
	}
	
	//List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	public boolean validateCartProductToList(List<String> targetProducts)
	{
	
	for(String targetProduct : targetProducts)
	{
		Boolean match = cartProducts.stream().anyMatch(cartP -> cartP.getText().equalsIgnoreCase(targetProduct));
		
		if(!match)
		{
			return false;
		}
	
	}
	
	return true;
	}
	
	//actions.moveToElement(driver.findElement(By.cssSelector(".totalRow button"))).click().build().perform();
	
	@FindBy(css=".totalRow button")
	WebElement checkOut;
	
	public ConfirmationPage doCheckout()
	{
		actions.moveToElement(checkOut).click().build().perform();
		ConfirmationPage confirmPage = new ConfirmationPage(driver);
		return confirmPage;
}
	
}
