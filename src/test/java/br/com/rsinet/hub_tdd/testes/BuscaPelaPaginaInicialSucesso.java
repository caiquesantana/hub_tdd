package br.com.rsinet.hub_tdd.testes;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.hub_tdd.pageObjects.PesquisaInicialPage;
import br.com.rsinet.hub_tdd.suporte.Screenshot;
import br.com.rsinet.hub_tdd.suporte.Web;
import br.com.rsinet.hub_tdd.utility.Constante;
import br.com.rsinet.hub_tdd.utility.ExcelUtils;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class BuscaPelaPaginaInicialSucesso {
	private WebDriver driver;
	ExtentReports extensao;
	ExtentTest logger;
	
  @Test
  public void pesquisaPaginaInicial() throws Exception {
	  ExcelUtils.setExcelFile(Constante.Path_TestData + Constante.File_TestData, "Pesquisa pagina inicial");
	  
	  PesquisaInicialPage pesquisa = new PesquisaInicialPage(driver);
	  
	  pesquisa.categoriaLaptop()
	  .escolheProduto()
	  .addAoCarrinho();
	  
	  ExtentHtmlReporter reporte = new ExtentHtmlReporter("C:\\Users\\caique.oliveira\\Pictures\\Reports\\BuscaHomeSucesso.html");

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
	  String carrinho = driver.findElement(By.xpath("/html/body/header/nav/ul/li[2]/a/span")).getText();
	  System.out.println(carrinho);
	  Assert.assertTrue(carrinho.equals("1"), "Produto adicionado ao carrinho");
	  extensao.flush();
	  Screenshot.tirar(driver, "pesquisaHomeSucesso");
	  Web.fecharDriver();
  }

}
