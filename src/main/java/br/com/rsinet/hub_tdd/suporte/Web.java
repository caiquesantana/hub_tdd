package br.com.rsinet.hub_tdd.suporte;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web {
	private static WebDriver driver;
	
	public Web() {
		
	}
	
	public static WebDriver createChrome() {
		if (driver == null) {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://advantageonlineshopping.com/");
		}
		return driver;

	}

	public static WebDriver fecharDriver() {
		if (driver != null)
			driver.quit();
		return driver = null;
	}
}