package MyEcommerce.Ecommerce.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MyEcommerce.Ecommerce.abstractcomponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//driver.findElement(By.id("userEmail")).sendKeys("harrysindhia@gmail.com");
	//driver.findElement(By.id("userPassword")).sendKeys("harry@Code5");
	//driver.findElement(By.id("login")).click();
	
	//PageFactory
	@FindBy(id="userEmail")
	WebElement email;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	public void goToApplication()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	
	public ProductCataloguePage loginApplication(String uemail , String upassword)
	{
		email.sendKeys(uemail);
		password.sendKeys(upassword);
		submit.click();
		ProductCataloguePage pCatalogue = new ProductCataloguePage(driver);
		return pCatalogue;
	}
	
	//WebElement errorMessage = driver.findElement(By.css(".ngx-toastr"));
	
	@FindBy(css=".ngx-toastr")
	WebElement errorMessage;
	
	public String getErrorMessage()
	{
		return errorMessage.getText();
	}
	//driver.get("https://rahulshettyacademy.com/client/");
	
	

	
	
}
