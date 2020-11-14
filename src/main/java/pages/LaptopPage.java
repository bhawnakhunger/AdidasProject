package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.TestBase;

public class LaptopPage extends TestBase{
	@FindBy(xpath="//a[contains(text(),'Sony vaio i5')]")
	WebElement sony;
	
	@FindBy(xpath="//a[contains(text(),'Add to cart')]")
	WebElement addCart;
	
	@FindBy(xpath="//li[@class='nav-item active']")
	WebElement home;
	
	@FindBy(xpath="//a[contains(text(),'Dell i7 8gb')]")
	WebElement dell;
	
	public LaptopPage() {
		//innitaite class
		PageFactory.initElements(driver, this);
	}
	
	public void clickSony() {
		sony.click();
	}
	
	public void addToCart() throws InterruptedException {
		addCart.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}
	
	public ProductStore clickHome() {
		home.click();
		return new ProductStore();
	}
	
	public void clickDell() {
		dell.click();
	}

}
