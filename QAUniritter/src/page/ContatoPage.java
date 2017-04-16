package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import run.Driver;

public class ContatoPage extends MasterPage {

	WebElement contact;
	private Select subject;
	private WebElement email;
	private WebElement chooseFile;
	private WebElement message;
	private WebElement submit;

	public ContatoPage(Driver baseD) {
		baseDriver = baseD;
		driver = baseDriver.getDriver();
		wait = new WebDriverWait(driver, 15);
		builder = new Actions(driver);
	}

	public void carregarContatoPage() {
		subject = carregaSelect(driver, "id_contact");
		email = driver.findElement(By.id("email"));
		message = driver.findElement(By.id("message"));
		submit = driver.findElement(By.id("submitMessage"));
	}

	public void navegarContato() {
		baseDriver.navegarPaginaBase();
		contact = driver.findElement(By.linkText("Contact us"));
		contact.click();
	}

	public Select getSubject() {
		return subject;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getChooseFile() {
		return chooseFile;
	}

	public WebElement getMessage() {
		return message;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getAlert() {
		try {
			WebElement alert = driver.findElement(By.xpath("//*[@id='center_column']/div"));
			return alert;
		} catch (Exception ex) {
			return null;
		}
	}

}
