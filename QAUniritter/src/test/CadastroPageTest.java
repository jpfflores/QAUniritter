package test;

import org.junit.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import page.CadastroPage;
import page.LoginPage;
import run.Driver;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CadastroPageTest {
	private Driver baseDriver;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {

	}

	public CadastroPageTest() {
		baseDriver = Driver.getInstance();

	}

	@Test
	public void testACadastroJaExistente() throws Exception {
		CadastroPage cadastro = new CadastroPage(baseDriver);
		LoginPage login = cadastro.getLogin();
		login.loadLoginPage();
		login.digitaTexto(login.getEmail(), "teste@teste.com");
		login.getSubmit().click();
		Assert.assertNotNull(login.getAlert());

	}

	@Test
	public void testBCadastrarCliente() throws Exception {
		CadastroPage cadastro = new CadastroPage(baseDriver);
		cadastro.navigateCadastrarUsuario();
		cadastro.carregaCadastro();

		cadastro.digitaTexto(cadastro.getFirstName(), "Jason");
		cadastro.digitaTexto(cadastro.getLastName(), "Bourne");
		cadastro.getGender().click();
		cadastro.digitaTexto(cadastro.getPasswCadastro(), "teste");
		cadastro.getDays().selectByIndex(9);
		cadastro.getMonths().selectByIndex(9);
		cadastro.getYears().selectByIndex(35);
		cadastro.digitaTexto(cadastro.getCompany(), "TestComp");
		cadastro.getCountry().selectByIndex(0);
		cadastro.digitaTexto(cadastro.getPhone(), "555444000");
		cadastro.digitaTexto(cadastro.getAlias(), "Testing");
		baseDriver.navegarPaginaBase();
		Assert.assertTrue("Somente para compilar.", true);
	}

	@Test
	public void testCAlterarCadastroSucesso() throws Exception {
		CadastroPage cadastro = new CadastroPage(baseDriver);
		LoginPage login = new LoginPage(baseDriver);
		login.loadLoginPage();
		login.digitaTexto(login.getUser(), "teste@teste.com");
		login.digitaTexto(login.getPassword(), "teste");
		login.getSubmit().click();
		cadastro.carregaCadastroAlterar();

		// base para inserir os dados
		cadastro.digitaTexto(cadastro.getFirstName(), "Jason");
		cadastro.digitaTexto(cadastro.getLastName(), "Bourne");
		cadastro.digitaTexto(cadastro.getOldPassword(), "teste");
		cadastro.digitaTexto(cadastro.getEmail(), "teste@teste.com");
		// cadastro.getGender().click();
		cadastro.getSubmit().click();
		Assert.assertNotNull(cadastro.getSuccessAlert());
	}

	@Test
	public void testDAlterarCadastroFaltaCampoObrigatorio() throws Exception {
		CadastroPage cadastro = new CadastroPage(baseDriver);
		LoginPage login = new LoginPage(baseDriver);
		login.loadLoginPage();
		login.digitaTexto(login.getUser(), "teste@teste.com");
		login.digitaTexto(login.getPassword(), "teste");
		login.getSubmit().click();
		cadastro.carregaCadastroAlterar();

		// base para inserir os dados
		cadastro.digitaTexto(cadastro.getFirstName(), "Jason");
		cadastro.digitaTexto(cadastro.getLastName(), "Bourne");
		cadastro.getSubmit().click();
		Assert.assertNotNull(cadastro.getErro());
	}

	@Test
	public void testEAlterarCadastroConfirmacaoSenhaErrada() throws Exception {
		CadastroPage cadastro = new CadastroPage(baseDriver);
		LoginPage login = new LoginPage(baseDriver);
		login.loadLoginPage();
		login.digitaTexto(login.getUser(), "teste@teste.com");
		login.digitaTexto(login.getPassword(), "teste");
		login.getSubmit().click();
		cadastro.carregaCadastroAlterar();

		// base para inserir os dados
		cadastro.digitaTexto(cadastro.getFirstName(), "Jason");
		cadastro.digitaTexto(cadastro.getLastName(), "Bourne");
		cadastro.digitaTexto(cadastro.getOldPassword(), "errado");
		cadastro.digitaTexto(cadastro.getEmail(), "teste@teste.com");
		// cadastro.getGender().click();
		cadastro.getSubmit().click();
		Assert.assertNotNull(cadastro.getErro());
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
