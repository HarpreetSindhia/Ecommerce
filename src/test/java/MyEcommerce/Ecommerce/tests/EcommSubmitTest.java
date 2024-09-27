package MyEcommerce.Ecommerce.tests;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MyEcommerce.Ecommerce.pageobjects.CheckoutPage;
import MyEcommerce.Ecommerce.pageobjects.ConfirmationPage;
import MyEcommerce.Ecommerce.pageobjects.OrdersPage;
import MyEcommerce.Ecommerce.pageobjects.ProductCataloguePage;
import MyEcommerce.Ecommerce.testcomponents.BaseTest;

public class EcommSubmitTest extends BaseTest{

	List<String> targetProducts = Arrays.asList("ZARA COAT 3", "ADIDAS ORIGINAL", "IPHONE 13 PRO");
	
	String countryPro = "Aus";
	
	String country ="Australia";
	

	@Test(dataProvider="getData")
	public void ecommSubmit(HashMap<String,Object> input) {
		
		
		ProductCataloguePage pCatalogue = landingPage.loginApplication((String)input.get("email") , (String)input.get("password"));
		CheckoutPage checkOut = pCatalogue.matchProductandAddToCart((List<String>) input.get("targetProducts"));
		pCatalogue.goToCartPage();
		Boolean match = checkOut.validateCartProductToList((List<String>) input.get("targetProducts"));
		Assert.assertTrue(match);
		ConfirmationPage confirmPage = checkOut.doCheckout();
		confirmPage.selectShipCountry(countryPro);
		OrdersPage pOrders = confirmPage.shippingCountry(country);
		confirmPage.navigateOrders();
		pOrders.matchOrdersListToActualList((List<String>) input.get("targetProducts"));
		Assert.assertTrue(true);
		pOrders.navigateHome();
		
}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,Object>> data = getJSONDataToHashMap((System.getProperty("user.dir")+"\\src\\test\\java\\MyEcommerce\\Ecommerce\\data\\DataReader.json"));
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
}
