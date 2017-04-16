package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import run.Driver;

public class CadastroPage extends MasterPage {
	private Driver baseDriver;
	private WebDriver driver;
	private LoginPage login;
	
	//Cadastro
	private WebElement title;
	private WebElement gender;
	private WebElement firstName;
	private WebElement lastName;
	private WebElement passwAltera;
	private WebElement passwCadastro;
	private Select days;
	private Select months;
	private Select years;
	private Select country;
	private WebElement company;
	private WebElement adress1;
	private WebElement city;
	private WebElement phone;
	private WebElement alias;
	private WebElement submit;
	
	//Correcao
	private WebElement email;
	private WebElement oldPassword;
	private WebElement confirmation;
	
	public LoginPage getLogin(){
		return login;
	}
	
	public CadastroPage(Driver baseD){
		baseDriver = baseD;
		driver = baseDriver.getDriver();
		wait = new WebDriverWait(driver, 30);
		builder = new Actions(driver);
		login = new LoginPage(baseDriver);
	}
	
	public void navigateCadastroPage(){
		try {
			login.loadLoginPage();
		} catch(Exception ex){
			Assert.assertFalse(true);
		}
	}
	
	public void navigateCadastrarUsuario() throws Exception{
		login.loadLoginPage();
		login.digitaTexto(login.getEmail(), "tester@tester.com.uk");
		login.getCreate().click();
	}
	
	
	public void carregaCadastro(){
	    gender = driver.findElement(By.id("id_gender1"));
	    firstName = driver.findElement(By.id("customer_firstname"));
	    lastName = driver.findElement(By.id("customer_lastname"));
	    passwCadastro =  driver.findElement(By.id("passwd"));
	    days = carregaSelect(driver, "days");
	    months = carregaSelect(driver, "months");
	    years = carregaSelect(driver, "years");
	    country = carregaSelect(driver, "id_country");
	    company = driver.findElement(By.id("company"));
	    adress1 = driver.findElement(By.id("address1"));
	    city = driver.findElement(By.id("city"));
	    driver.findElement(By.id("postcode"));
	    phone = driver.findElement(By.id("phone"));
	    alias = driver.findElement(By.id("alias"));
	    submit = driver.findElement(By.id("submitAccount"));
	}
	
	public void carregaCadastroAlterar(){
	    driver.findElement(By.cssSelector("a[title=\"Information\"] > span")).click();
	    gender = driver.findElement(By.id("id_gender1"));
	    firstName = driver.findElement(By.id("firstname"));
	    lastName = driver.findElement(By.id("lastname"));
	    email = driver.findElement(By.id("email"));
	    days = carregaSelect(driver, "days");
	    months = carregaSelect(driver, "months");
	    years = carregaSelect(driver, "years");
	    oldPassword = driver.findElement(By.id("old_passwd"));
	    passwAltera = driver.findElement(By.id("passwd"));
	    confirmation = driver.findElement(By.id("confirmation"));
	    
	    submit = driver.findElement(By.name("submitIdentity"));		
	}

	public WebElement getTitle(){
		return title;
	}
	
	public WebElement getGender(){
		return gender;
	}
	
	public WebElement getFirstName(){
		return firstName;
	}

	public WebElement getLastName(){
		return lastName;
	}

	public Select getDays(){
		return days;
	}
	
	public Select getMonths(){
		return months;
	}
	
	public Select getYears(){
		return years;
	}
	
	public WebElement getCompany(){
		return company;
	}

	public Select getCountry(){
		return country;
	}
	
	public WebElement getAdress1(){
		return adress1;
	}

	public WebElement getCity(){
		return city;
	}

	public WebElement getPhone(){
		phone = driver.findElement(By.id("phone"));
		return phone;
	}

	public WebElement getSubmit(){
		return submit;
	}

	public WebElement getEmail(){
		return email;
	}

	public WebElement getPasswCadastro(){
		return passwCadastro;
	}

	public WebElement getPasswAltera(){
		return passwAltera;
	}

	public WebElement getOldPassword(){
		return oldPassword;
	}

	public WebElement getAlias(){
		return alias;
	}
	
	public WebElement getConfirmation(){
		return confirmation;
	}
	public WebElement getSuccessAlert(){
		WebElement element;
		element = driver.findElement(By.cssSelector("*[class^='alert']"));
		return element;
	}

	public WebElement getErro(){
		WebElement elemento;
		elemento = driver.findElement(By.xpath("//*[@id='center_column']/div/div"));
		return elemento;
	}
	
	public WebElement getErroObrigatorio(){
		WebElement elemento;
		elemento = driver.findElement(By.xpath("//*[@id='center_column']/div/p[2]"));
		return elemento;
	}
	
}
