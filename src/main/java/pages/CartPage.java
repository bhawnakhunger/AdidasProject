package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.TestBase;

public class CartPage extends TestBase{
	@FindBy(xpath="//tr/td[2][contains(text(),'Dell i7 8gb')]//parent::tr/td[4]/a")
	WebElement dellDelete;
	
	@FindBy(xpath="//button[contains(text(),'Place Order')]")
	WebElement order;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement name;
	
	@FindBy(xpath="//input[@id='country']")
	WebElement country;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement city;
	
	@FindBy(xpath="//input[@id='card']")
	WebElement card;
	
	@FindBy(xpath="//input[@id='month']")
	WebElement month;
	
	@FindBy(xpath="//input[@id='year']")
	WebElement year;
	
	@FindBy(xpath="//button[contains(text(),'Purchase')]")
	WebElement purchase;
	
	@FindBy(xpath="//p[contains(@class,'lead')]")
	WebElement purchaseDetails;
	
	@FindBy(xpath="//button[contains(text(),'OK')]")
	WebElement ok;
	

	
	public CartPage() {
		//innitaite class
		PageFactory.initElements(driver, this);
	}
	
	public void deleteDell() throws InterruptedException {
		dellDelete.click();
		Thread.sleep(3000);
	}
	
	public void placeOrder() throws InterruptedException {
		order.click();
		Thread.sleep(3000);
	}
	
	
	public void purchaseProduct() {
		//entering details in web form and buy
		name.sendKeys(prop.getProperty("name"));
		country.sendKeys(prop.getProperty("country"));
		city.sendKeys(prop.getProperty("city"));
		card.sendKeys(prop.getProperty("card"));
		month.sendKeys(prop.getProperty("month"));
		year.sendKeys(prop.getProperty("year"));
		purchase.click();
	}
	
	public String getPurchaseDetails() {
		String purchase=purchaseDetails.getText();
		return purchase;
	}
	public void confirmPurchase() {
		ok.click();
	}

}
