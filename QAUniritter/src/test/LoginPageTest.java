package test;

import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;

import static org.junit.Assert.*;
import page.LoginPage;
import run.Driver;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginPageTest {
	private Driver baseDriver;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private LoginPage login;
	  
	@Before
	public void setUp() throws Exception {
		
	}

	public LoginPageTest() {
		baseDriver = Driver.getInstance();
		baseDriver.getDriver();
		login = new LoginPage(baseDriver);
	}

	@Test
	public void testeLoginSenhaErrada() throws Exception {
		login.loadLoginPage();
		login.digitaTexto(login.getUser(), "teste@teste.com");
		login.digitaTexto(login.getPassword(), "errado");
		login.getSubmit().click();
		
		Assert.assertNotNull(login.getAlert());
	}
	
	@Test
	public void testeLoginCorreto() throws Exception {
		login.loadLoginPage();
		login.digitaTexto(login.getUser(), "teste@teste.com");
		login.digitaTexto(login.getPassword(), "teste");
		login.getSubmit().click();
		
		Assert.assertNotNull(login.getSuccess());
	}	

	@After
	public void tearDown() throws Exception {
		//driver.close();
		//driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			login.getDriver().findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			login.getDriver().switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = login.getDriver().switchTo().alert();
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
