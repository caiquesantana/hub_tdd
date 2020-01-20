package br.com.rsinet.hub_tdd.testes;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.suporte.Web;
import br.com.rsinet.hub_tdd.utility.Constante;
import br.com.rsinet.hub_tdd.utility.ExcelUtils;

public class TestLoginComSucesso {
	public WebDriver driver;

	@Test
	public void TestaLoginComSucesso() throws Exception {
		// Teste de login pela massa de dados
		ExcelUtils.setExcelFile(Constante.Path_TestData + Constante.File_TestData, "Cadastro");
		driver.findElement(By.id("menuUser")).click();
		driver.findElement(By.name("username")).sendKeys(ExcelUtils.getCellData(1, 0));
		driver.findElement(By.name("password")).sendKeys(ExcelUtils.getCellData(1, 2));
		driver.findElement(By.id("sign_in_btnundefined")).click();

	}

	@BeforeMethod
	public void beforeMethod() throws Exception {
		// Inicializa o browser
		driver = Web.createChrome();
	}

	@AfterMethod
	public void afterMethod() throws Exception {

		boolean usuarioLogado = driver.findElement(By.xpath("/html/body/header/nav/ul/li[3]/a/span")).isDisplayed();
		// isso significa que driver fará uma verificação a cada 3 segundos por um período de 30 segundos.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.textToBePresentInElement
				(driver.findElement(By.xpath("/html/body/header/nav/ul/li[3]/a/span")), ExcelUtils.getCellData(1,0)));	
				
		// Verifica se o usuário está logado

		Assert.assertTrue(ExcelUtils.getCellData(1, 0), usuarioLogado);
		System.out.println(usuarioLogado);
		driver.quit();
	}
}
