package br.com.rsinet.hub_tdd.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BuscaProdutoLupaPage {
	private WebDriver driver;

	public BuscaProdutoLupaPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public BuscaProdutoLupaPage clicarLupa () {
		driver.findElement(By.id("menuSearch")).click();
		return this;
	}
	public BuscaProdutoLupaPage campoDePesquisa (String pesquisa) {
		driver.findElement(By.id("autoComplete")).sendKeys(pesquisa + Keys.ENTER);
		return this;
	}
	
	public BuscaProdutoLupaPage selecionaProduto () {
		driver.findElement(By.id("3")).click();
		return this;
	}
}
