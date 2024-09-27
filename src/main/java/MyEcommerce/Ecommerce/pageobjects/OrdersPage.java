package MyEcommerce.Ecommerce.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MyEcommerce.Ecommerce.abstractcomponents.AbstractComponents;

public class OrdersPage extends AbstractComponents {

	WebDriver driver;
	
	public OrdersPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> orderedProducts = driver.findElements(By.cssSelector(".table tbody td:nth-child(3)"));
	
	//Loop through the List
	
	/*for(String targetProduct : targetProducts)
	{
		Boolean match1 = orderedProducts.stream().anyMatch(order -> order.getText().equalsIgnoreCase(targetProduct));
		
		Assert.assertTrue(match1);
	}
	
	driver.findElement(By.cssSelector("button[routerlink='/dashboard/']")).click();*/
	
	@FindBy(css=".table tbody td:nth-child(3)")
	List<WebElement> orderedProducts;
	
	public boolean matchOrdersListToActualList(List<String> targetProducts)
	{
		WaitForTheWebElementToAppear(orderedProducts);
		for(String targetProduct : targetProducts)
		{
			Boolean matchFound = orderedProducts.stream().anyMatch(order -> order.getText().equalsIgnoreCase(targetProduct));
			
			if(!matchFound)
			{
				return false;
			}
			
		}
		
		return true;
		
		
		
	}
	
}
	

