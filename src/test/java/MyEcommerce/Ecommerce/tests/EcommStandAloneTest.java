package MyEcommerce.Ecommerce.tests;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EcommStandAloneTest {

	List<String> targetProducts = Arrays.asList("ZARA COAT 3", "ADIDAS ORIGINAL", "IPHONE 13 PRO");

	@Test
	public void ecommSubmit() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/");
		driver.findElement(By.id("userEmail")).sendKeys("harrysindhia@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("harry@Code5");
		driver.findElement(By.id("login")).click();
		List<WebElement> products = driver.findElements(By.cssSelector(".card-body"));
		// Loop through the target Products and match the list(targetProducts) with the
		// products

		Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

		for (String targetProduct : targetProducts) {
			WebElement product = products.stream()
					.filter(prod -> prod.findElement(By.tagName("b")).getText().equalsIgnoreCase(targetProduct))
					.findFirst().orElse(null);

			if (product != null) {
				product.findElement(By.cssSelector("button:last-of-type")).click();

				WebElement toastMessage = driver.findElement(By.cssSelector(".ng-trigger-flyInOut"));
				wait.until(ExpectedConditions.visibilityOf(toastMessage));
				WebElement spinner = driver.findElement(By.cssSelector(".ng-trigger-fadeIn"));
				wait.until(ExpectedConditions.invisibilityOf(spinner));

			}
		}
		
		actions.moveToElement(driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']"))).click().build().perform();
		//Validate if products present in the cart are same as that of the list 
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		
		for(String targetProduct : targetProducts)
		{
			Boolean match = cartProducts.stream().anyMatch(cartP -> cartP.getText().equalsIgnoreCase(targetProduct));
			
			Assert.assertTrue(match);
		}
		
		
		
		actions.moveToElement(driver.findElement(By.cssSelector(".totalRow button"))).click().build().perform();
		
		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("Aus");
		
		List<WebElement> countryList = driver.findElements(By.cssSelector(".ta-results button"));
		
		WebElement selectCountry = countryList.stream().filter(a -> a.getText().equalsIgnoreCase("Australia")).findFirst().orElse(null);
		
		selectCountry.click();
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		actions.moveToElement(driver.findElement(By.cssSelector("button[routerlink='/dashboard/myorders']"))).click().build().perform();
		
		List<WebElement> orderedProducts = driver.findElements(By.cssSelector(".table tbody td:nth-child(3)"));
		
		//Loop through the List
		
		for(String targetProduct : targetProducts)
		{
			Boolean match = orderedProducts.stream().anyMatch(order -> order.getText().equalsIgnoreCase(targetProduct));
			
			Assert.assertTrue(match);
		}
		
		driver.findElement(By.cssSelector("button[routerlink='/dashboard/']")).click();
		
		
	}
}
