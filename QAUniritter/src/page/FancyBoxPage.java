package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import run.Driver;

public class FancyBoxPage extends MasterPage {

	SelecionaProdutoPage produto;
	
	private WebElement proceed;
	private WebElement checkout;
	private WebElement keepshop;
	private WebElement addtocart;
	
	public WebElement getAddToCart(){
		try{
			WebElement elemento = driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[1]"));
			return elemento;
		} catch (Exception ex) {
			return null;
		}
		
	}
	
	public WebElement getProceed(){
		return proceed;
	}
	
	public WebElement getCheckout(){
		return checkout;
	}

	public WebElement getKeepshop(){
		keepshop = driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span/i"));
		return keepshop;
	}
	
	public FancyBoxPage(Driver baseD){
		baseDriver = baseD;
		driver = baseDriver.getDriver();
		wait = new WebDriverWait(driver, 15);
		builder = new Actions(driver);
		
	}
	
	// addCart
	public void loadPageDirectAddToCart(){ 
		WebElement produto = driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]/img"));
		Actions builder = new Actions(driver);
		builder.moveToElement(produto).perform();
		proceed = driver.findElement(By.xpath("//*[@id='center_column']/ul/li[2]"));
		
	}
	
	public void loadBoxPage(){
		checkout = driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a"));
		keepshop = driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span"));
	}

	public WebElement getAddtocart(){
		WebElement elemento = driver.findElement(By.xpath("//*[@id='add_to_cart']/button/span"));
		return elemento;
	}
	public WebElement getConfirmacao(){
		
		WebElement elemento = driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[1]/h2"));
		return elemento;
	}
}
