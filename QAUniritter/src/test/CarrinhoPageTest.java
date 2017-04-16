package test;


import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

import page.CarrinhoPage;
import run.Driver;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CarrinhoPageTest {
	private Driver baseDriver;
	private WebDriver driver;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	CarrinhoPage carrinho;
	
	public CarrinhoPageTest() {
		baseDriver = Driver.getInstance();
		driver = baseDriver.getDriver();
	}

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testeAEsvaziaCarrinhoSemItens() {
		// carrinho.navegaPaginaInicial();
		carrinho = new CarrinhoPage(baseDriver);
		carrinho.montaCarrinho();
		Assert.assertNotNull(carrinho.getEmpty());

	}

	@Test
	public void testeBRemoveUmItemCarrinho() {
		// Compra dois itens
		carrinho = new CarrinhoPage(baseDriver);
		//Compra primeiro Item
		carrinho.adicionaItemCarrinho("printed");
		
		//Compra segundo item
		carrinho.adicionaItemCarrinho("short");

		// conta quantos elementos estao no carrinho
		int qty = 0;
		qty = carrinho.GetQuantityValue();
	
		// Remove um item
		carrinho.excluiItem();
	
		// Verifica 
		Assert.assertEquals( 1, (qty-1) );
	}

	@Test
	public void testeCEsvaziaCarrinho() {
		//  um item ainda no carrinho
		carrinho = new CarrinhoPage(baseDriver);
		// Remove todos os itens
		int qty = 0;
		qty = carrinho.GetQuantityValue();
		carrinho.excluiItem();
		Assert.assertNotNull(carrinho.getEmpty());
	}

	@After
	public void tearDown() throws Exception {
		// driver.close();
		// driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}

}
