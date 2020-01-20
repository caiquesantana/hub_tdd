package br.com.rsinet.hub_tdd.testes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.pageObjects.PesquisaInicialPage;
import br.com.rsinet.hub_tdd.suporte.Web;

public class BuscaPelaPaginaInicialFalha {
	public WebDriver driver;

	@Test
	public void BuscaProdutoInexistente() {

		driver.findElement(By.id("laptopsImg")).click();

		WebElement produto = driver.findElement(By.id("8"));
		produto.click();
		
		produto.getText();

		WebElement element = driver.findElement(By.xpath("/html/body/div[3]/section/article[1]/div[1]/h1"));
		String linkText = element.getText();
		
		Assert.assertEquals(produto, linkText);
		
		System.out.println(produto + linkText);
	}

	@BeforeMethod
	public void beforeMethod() throws Exception {
		driver = Web.createChrome();
		
	}

	@AfterMethod
	public void afterMethod() {

	driver = Web.fecharDriver();

	}

}
