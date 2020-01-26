package br.com.rsinet.hub_tdd.testes;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.hub_tdd.pageObjects.BuscaProdutoLupaPage;
import br.com.rsinet.hub_tdd.pageObjects.PesquisaInicialPage;
import br.com.rsinet.hub_tdd.suporte.Screenshot;
import br.com.rsinet.hub_tdd.suporte.Web;
import br.com.rsinet.hub_tdd.utility.Constante;
import br.com.rsinet.hub_tdd.utility.ExcelUtils;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class BuscaPelaLupaSucesso {
	private WebDriver driver;
	ExtentReports extensao;
	ExtentTest logger;

	@Test
	public void TesteLupaSucesso() throws Exception {
		BuscaProdutoLupaPage lupa = new BuscaProdutoLupaPage(driver);

		lupa.clicarLupa().campoDePesquisa("").selecionaProduto();

		ExtentHtmlReporter reporte = new ExtentHtmlReporter(
				"C:\\Users\\caique.oliveira\\Pictures\\Reports\\BuscaLupaSucesso.html");
		extensao = new ExtentReports();
		extensao.attachReporter(reporte);
		logger = extensao.createTest("Busca realizado com sucesso!");
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = Web.createChrome();
	}

	@AfterMethod
	public void afterMethod() throws Exception {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		ExcelUtils.setExcelFile(Constante.Path_TestData + Constante.File_TestData, "Pesquisa pela lupa");
		String produto = driver.findElement(By.linkText("HP PAVILION 15Z TOUCH LAPTOP")).getText();
		Assert.assertTrue(produto.equals("HP PAVILION 15Z TOUCH LAPTOP"), "Produto selecionado");
		extensao.flush();
		Screenshot.tirar(driver, "pesquisaLupaSucesso");
		Web.fecharDriver();
	}

}
