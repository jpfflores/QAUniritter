package run;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;

public class Driver {
	private static Driver instancia;
	private WebDriver driver;
	private String baseUrl;

	private Driver() {
		String OS = System.getProperty("os.name").toLowerCase();

		if (OS.indexOf("win") >= 0) {
			System.setProperty("webdriver.chrome.driver", "libraries\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver"); driver = new ChromeDriver();
			driver = new ChromeDriver();
		}

		baseUrl = "http://automationpractice.com";
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static synchronized Driver getInstance() {
		if (instancia == null) {
			instancia = new Driver();
		}
		return instancia;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void navegarPaginaBase() {
		if (driver.getCurrentUrl().compareTo(baseUrl) != 0) {
			driver.navigate().to(baseUrl);
		}
	}
}
