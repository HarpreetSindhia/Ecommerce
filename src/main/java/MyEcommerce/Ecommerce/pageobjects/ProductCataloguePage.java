package MyEcommerce.Ecommerce.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import MyEcommerce.Ecommerce.abstractcomponents.AbstractComponents;

public class ProductCataloguePage extends AbstractComponents {

	WebDriver driver;

	public ProductCataloguePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// List<WebElement> products =
	// driver.findElements(By.cssSelector(".card-body"));

	//WebElement toastMessage = driver.findElement(By.cssSelector(".ng-trigger-flyInOut"));

	//WebElement spinner = driver.findElement(By.cssSelector(".ng-trigger-fadeIn"));
	
	By visibleElement = By.cssSelector("#toast-container");

	@FindBy(css=".card-body")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	

	@FindBy(id="toast-container")
	WebElement toastMessage;

	public CheckoutPage matchProductandAddToCart(List<String> targetProducts)
	{
		WaitForTheWebElementToAppear(products);
		
	for(String targetProduct:targetProducts)
	{
		WebElement product = products.stream()
				.filter(prod -> prod.findElement(By.tagName("b")).getText().equalsIgnoreCase(targetProduct)).findFirst()
				.orElse(null);

		if (product != null) {
			WebElement myProduct = product.findElement(By.cssSelector("button:last-of-type"));
			myProduct.click();

			waitForTheElementToAppear(visibleElement);
			
			WaitForTheWebElementToDisappear(spinner);
		
		}
	}
	
	CheckoutPage checkOut = new CheckoutPage(driver);
	return checkOut;

}
	
}
