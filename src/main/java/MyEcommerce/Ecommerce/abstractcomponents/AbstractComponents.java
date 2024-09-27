package MyEcommerce.Ecommerce.abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {

	WebDriver driver;
	Actions actions;
	
	public AbstractComponents(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actions = new Actions(driver);
	}
	
	
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	
	//wait.until(ExpectedConditions.visibilityOf(toastMessage));
	
	//wait.until(ExpectedConditions.invisibilityOf(spinner));
	
	//actions.moveToElement(driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']"))).click().build().perform();
	
	//actions.moveToElement(driver.findElement(By.cssSelector("button[routerlink='/dashboard/myorders']"))).click().build().perform();
	
	//driver.findElement(By.cssSelector("button[routerlink='/dashboard/']")).click();
	
	public void WaitForTheWebElementToAppear(WebElement findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void WaitForTheWebElementToDisappear(WebElement findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.invisibilityOf(findBy));
	}
	
	@FindBy(css="button[routerlink='/dashboard/cart']")
	WebElement cartPage;
	
	public void goToCartPage()
	{
		actions.moveToElement(cartPage).click().build().perform();
	}
	
	@FindBy(css="button[routerlink='/dashboard/myorders']")
	WebElement ordersPage;
	
	public void navigateOrders()
	{
		actions.moveToElement(ordersPage).click().build().perform();
		
	}
	
	@FindBy(css="button[routerlink='/dashboard/']")
	WebElement homePage;
	
	public void navigateHome()
	{
		homePage.click();
	}
	
}
