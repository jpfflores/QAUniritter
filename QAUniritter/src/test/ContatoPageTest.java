package test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import page.ContatoPage;
import run.Driver;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContatoPageTest {
	private Driver baseDriver;
	private ContatoPage contato;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
	}

	public ContatoPageTest() {
		baseDriver = Driver.getInstance();
		contato = new ContatoPage(baseDriver);

	}

	@Test
	public void testeEnvio() {
		baseDriver.navegarPaginaBase();
		contato.navegarContato();
		contato.carregarContatoPage();
		contato.getSubject().selectByIndex(1);
		contato.digitaTexto(contato.getEmail(), "teste@teste.com");
		contato.digitaTexto(contato.getMessage(), "Hereby a sign my complaint");
		Assert.assertTrue("Somente para compilar.", true);
	}

	@Test
	public void testeEnvioCampoObrigatiorVazio() {
		baseDriver.navegarPaginaBase();
		contato.navegarContato();
		contato.carregarContatoPage();
		contato.navegarContato();
		contato.carregarContatoPage();
		contato.getSubject().selectByIndex(1);
		contato.getSubmit().click();
		Assert.assertNotNull(contato.getAlert());

	}

	// @Before
	public void navigateBaseTestPage() {
		contato.navegarContato();
		contato.carregarContatoPage();
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
			baseDriver.getDriver().findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			baseDriver.getDriver().switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = baseDriver.getDriver().switchTo().alert();
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
