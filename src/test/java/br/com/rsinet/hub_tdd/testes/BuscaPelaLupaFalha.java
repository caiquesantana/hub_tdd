package br.com.rsinet.hub_tdd.testes;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.hub_tdd.pageObjects.BuscaProdutoLupaPage;
import br.com.rsinet.hub_tdd.suporte.Screenshot;
import br.com.rsinet.hub_tdd.suporte.Web;

public class BuscaPelaLupaFalha {
	private WebDriver driver;
	ExtentReports extensao;
	ExtentTest logger;

	@Test
	public void f() {
		BuscaProdutoLupaPage pesquisaLupa = new BuscaProdutoLupaPage(driver);
		pesquisaLupa.clicarLupa().campoDePesquisa("Notebook");
		ExtentHtmlReporter reporte = new ExtentHtmlReporter(
				"C:\\Users\\caique.oliveira\\Pictures\\Reports\\BuscaLupaFalha.html");
		extensao = new ExtentReports();
		extensao.attachReporter(reporte);
		logger = extensao.createTest("Produto não encontrado!");

	}

	@BeforeMethod
	public void beforeMethod() {
		driver = Web.createChrome();
	}

	@AfterMethod
	public void afterMethod() throws IOException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String produtoPesquisado = driver
				.findElement(By.xpath("/html/body/div[3]/section/article/div[3]/div/label/span")).getText();
		Assert.assertTrue(produtoPesquisado.equals("No results for \"Notebook\""), "Produto nao encontrado");
		extensao.flush();
		Screenshot.tirar(driver, "pesquisaLupaFalha");
		Web.fecharDriver();
	}

}
