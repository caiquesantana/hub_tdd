package br.com.rsinet.hub_tdd.testes;

import static org.testng.AssertJUnit.assertEquals;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.suporte.Web;
import br.com.rsinet.hub_tdd.utility.Constante;
import br.com.rsinet.hub_tdd.utility.ExcelUtils;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class TestLoginComSucesso {
	public WebDriver driver;

	@Test
	public void TestaLoginComSucesso() throws Exception {
		driver.findElement(By.id("menuUser")).click();
		driver.findElement(By.name("username")).sendKeys(ExcelUtils.getCellData(1, 0));
		driver.findElement(By.name("password")).sendKeys(ExcelUtils.getCellData(1, 2));
		driver.findElement(By.id("sign_in_btnundefined")).click();
		
	}

	@BeforeMethod
	public void beforeMethod() throws Exception {
		driver = Web.createChrome();
		ExcelUtils.setExcelFile(Constante.Path_TestData + Constante.File_TestData, "Cadastro");
	}

	@AfterMethod
	public void afterMethod() throws Exception {
		Thread.sleep(10000);
		 boolean usuarioLogado = driver.findElement(By.xpath("/html/body/header/nav/ul/li[3]/a/span")).isDisplayed();
		
		Assert.assertEquals(ExcelUtils.getCellData(1, 0) , usuarioLogado);
		System.out.println(usuarioLogado);
	driver.quit();
	}
}
