package br.com.rsinet.hub_tdd.testes;

import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.pageObjects.PesquisaInicialPage;
import br.com.rsinet.hub_tdd.suporte.Web;
import br.com.rsinet.hub_tdd.utility.Constante;
import br.com.rsinet.hub_tdd.utility.ExcelUtils;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class BuscaPelaPaginaInicial {
	public WebDriver driver;
	
  @Test
  public void pesquisaPaginaInicial() throws Exception {
	  ExcelUtils.setExcelFile(Constante.Path_TestData + Constante.File_TestData, "Pesquisa pagina inicial");
	  
	  PesquisaInicialPage pesquisa = new PesquisaInicialPage(driver);
	  
	  pesquisa.categoriaLaptop()
	  .escolheProduto();
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver = Web.createChrome();;
  }

  @AfterMethod
  public void afterMethod() throws Exception {
	  ExcelUtils.setExcelFile(Constante.Path_TestData + Constante.File_TestData, "Pesquisa pagina inicial");
	  PesquisaInicialPage produtoPesquisado = new PesquisaInicialPage(driver);
	  produtoPesquisado.categoriaLaptop().escolheProduto();
	  
	  PesquisaInicialPage element =  produtoPesquisado.categoriaLaptop().escolheProduto();
	  
	  Assert.assertEquals(element, produtoPesquisado);
	  
  }

}
