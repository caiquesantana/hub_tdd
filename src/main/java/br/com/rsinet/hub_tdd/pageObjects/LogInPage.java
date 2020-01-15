package br.com.rsinet.hub_tdd.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
	private static WebElement element = null;
	
	public static WebElement userName(WebDriver driver) {
		element = driver.findElement(By.name("username"));
		return element;
	}
	
	public static WebElement password (WebDriver driver) {
		element = driver.findElement(By.name("password"));
		return element;
	}
	public static WebElement signIn (WebDriver driver) {
		element = driver.findElement(By.id("sign_in_btnundefined"));
		return element;
	}
}
