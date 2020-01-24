package br.com.rsinet.hub_tdd.testes;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.hub_tdd.pageObjects.PesquisaInicialPage;
import br.com.rsinet.hub_tdd.suporte.Screenshot;
import br.com.rsinet.hub_tdd.suporte.Web;

public class BuscaPelaPaginaInicialFalha {
	public WebDriver driver;
	ExtentReports extensao;
	ExtentTest logger;

	@Test
	public void QuantidadeMaximaPermitida() throws Exception {

		new PesquisaInicialPage(driver).categoriaLaptop().escolheProduto().quantidade().addAoCarrinho();

		ExtentHtmlReporter reporte = new ExtentHtmlReporter(
				"C:\\Users\\caique.oliveira\\Pictures\\Reports\\BuscaHomeSucesso.html");

		extensao = new ExtentReports();

		extensao.attachReporter(reporte);

		logger = extensao.createTest("Quantidade máxima permitida excedida!");

	}

	@BeforeMethod
	public void beforeMethod() throws Exception {
		driver = Web.createChrome();

	}

	@AfterMethod
	public void afterMethod() throws IOException {
		String element = driver.findElement(By.xpath("/html/body/div[3]/section/article[1]/div[2]/div[2]/div/label"))
				.getText();
		Assert.assertTrue(element.equals("Oops! We only have 10 in stock. We updated your order accordingly"),
				"Quantidade máxima excedida!");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0,200)","");
		Screenshot.tirar(driver, "BuscaPelaHomeFalha");

		driver = Web.fecharDriver();
	}

}
