package page;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import run.Driver;

public class SelecionaProdutoPage extends MasterPage {

	private WebElement menuWomen;
	private WebElement menuTshirts;
	private WebElement subMenuTshirts;	

	private WebElement search;
	private WebElement searchButton;
	private WebElement searchAlert;
	private WebElement searchFound;
	
	public WebElement getSearch(){
		search = driver.findElement(By.id("search_query_top"));
		return search;
		
	}
	
	public WebElement getSearchButton(){
		searchButton = driver.findElement(By.xpath("//*[@id='searchbox']/button"));
		return searchButton;
		
	}
	
	public WebElement getSearchAlert(){
		searchAlert = driver.findElement(By.className("heading-counter"));
		if(searchAlert == null){
			return null;
		}
		else {
			if (searchAlert.getText().contains("0 results have been found."))
				return searchAlert;
			else
				return null;
		}
	}

	public WebElement getSearchFound(){
		searchFound = driver.findElement(By.className("compare-form"));
		return searchFound;
	}
		
	public SelecionaProdutoPage(Driver baseD){
		baseDriver = baseD;
		driver = baseDriver.getDriver();
		wait = new WebDriverWait(driver, 15);
		builder = new Actions(driver);
		
		// estes elementos sempre estarao na pagina
		search = driver.findElement(By.id("search_query_top"));
		searchButton = driver.findElement(By.xpath("//*[@id='searchbox']/button"));
	}
	
	public void SelecionaSubMenuTShirtsWomen(){
		menuWomen = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/a"));
		builder.moveToElement(menuWomen).perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.subMenuTshirts = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[1]/a"));
		builder.moveToElement(subMenuTshirts).perform();
		subMenuTshirts.click();
	}

	public void SelecionaSubMenuBlousesWomen(){
		menuWomen = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/a"));
		builder.moveToElement(menuWomen).perform();
		this.menuTshirts = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[2]/a")));
		menuTshirts.click();
	}
	
	public void CarregaDresses(){
		WebElement elemento =  driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a"));
		elemento.click();
	}

	public void CarregaTshirt(){
		WebElement elemento =  driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[3]/a"));
		elemento.click();
	}
	
	public WebElement carregaPrimeiroItem(){
		WebElement elemento = driver.findElement(By.xpath("//*[@id='homefeatured']/li[1]/div/div[2]/div[2]/a[1]/span"));
		return elemento;
	}

}
