package MyEcommerce.Ecommerce.tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import MyEcommerce.Ecommerce.pageobjects.CheckoutPage;
import MyEcommerce.Ecommerce.pageobjects.ProductCataloguePage;
import MyEcommerce.Ecommerce.testcomponents.BaseTest;
import MyEcommerce.Ecommerce.testcomponents.Retry;

public class ErrorValidationTest extends BaseTest{

	

	@Test(groups= {"Error Handling"})
	public void loginErrorValidation() {
		
		
		landingPage .loginApplication("harrysindhia@gmail.com", "hary@Code5");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
				
}
	
	
	List<String> targetProducts = Arrays.asList("ZARA COAT 3", "ADIDAS ORIGINAL", "IPHONE 16 PRO");
	
	String countryPro = "Aus";
	
	String country ="Australia";
	

	@Test(retryAnalyzer = Retry.class)
	public void productErrorValidation() {
		
		
		ProductCataloguePage pCatalogue = landingPage.loginApplication("harrycoder@gmail.com", "harryCode@5");
		CheckoutPage checkOut = pCatalogue.matchProductandAddToCart(targetProducts);
		pCatalogue.goToCartPage();
		Boolean match = checkOut.validateCartProductToList(targetProducts);
		Assert.assertFalse(match);
		
		
	}
}

