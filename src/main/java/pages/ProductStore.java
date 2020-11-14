package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.TestBase;

public class ProductStore extends TestBase{
	
	@FindBy(xpath="//a[contains(text(),'Laptops')]")
	WebElement laptop;
	
	@FindBy(xpath="//a[contains(text(),'Cart')]")
	WebElement cart;
	
	
	
	public ProductStore() {
		//innitaite class
		PageFactory.initElements(driver, this);
	}
	
	public LaptopPage clickLaptops() {
	
		laptop.click();
		return new LaptopPage();
	}
	
	public CartPage clickCart() {
		cart.click();
		return new CartPage();
	}
	


}
