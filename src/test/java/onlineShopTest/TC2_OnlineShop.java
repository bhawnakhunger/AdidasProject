package onlineShopTest;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import main.TestBase;
import pages.CartPage;
import pages.LaptopPage;
import pages.ProductStore;


public class TC2_OnlineShop extends TestBase {
	
	ProductStore product;
	LaptopPage laptop;
	CartPage cart;

	
	public TC2_OnlineShop() {
		super();
	}
	
	@BeforeTest
	public void setUp() { 
		//Innitiate all classes
		
		innitialize();
		product=new ProductStore();
		laptop=new LaptopPage();
		cart=new CartPage();
		
		
	}
	
	@Test(priority=1)
	public void shopProduct() throws InterruptedException {
		//first testcase to add products to cart and buy
		product.clickLaptops();
		laptop.clickSony();
		laptop.addToCart();
		laptop.clickHome();
		product.clickLaptops();
		laptop.clickDell();
		laptop.addToCart();
		product.clickCart();
		Thread.sleep(3000);
		cart.deleteDell();
		cart.placeOrder();
		cart.purchaseProduct();
		
	}
	
	@Test(priority=2)
	public void verifyPurchaseDetails() {
		//2nd testcase to verify purchase details
		String purchaseDetails=cart.getPurchaseDetails();
		String[] details=purchaseDetails.split("\n");
		System.out.println(details[0]+"\n"+details[1]);
		Assert.assertTrue(purchaseDetails.contains("790 USD"));
		cart.confirmPurchase();
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
