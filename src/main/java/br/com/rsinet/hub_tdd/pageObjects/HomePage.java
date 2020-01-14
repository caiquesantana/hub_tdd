package br.com.rsinet.hub_tdd.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	public CriarNovaContaFormPage clickUser() {
		driver.findElement(By.id("menuUser")).click();
		
		WebDriverWait wait = new WebDriverWait (driver , 10);
		WebElement usuario = wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]")));
		
		usuario.click();
		return new CriarNovaContaFormPage(driver);
	}
}
