package br.com.rsinet.hub_tdd.testes;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub_tdd.pageObjects.CriarNovaContaFormPage;
import br.com.rsinet.hub_tdd.suporte.Web;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class CadastroUsuarioSucesso {
	private WebDriver driver;
	ExtentReports extensao;
	ExtentTest logger;
	
  @Test
  public void CadastroComSucesso() {
	  new CriarNovaContaFormPage(driver)
	  .digitarLogin("Matias")
	  .digitarEmail("marias@email.com")
	  .digitarSenha("Matias1")
	  .confirmarSenha("Matias1")
	  .digitarNome("Matias")
	  .digitarSobrenome("Defederico")
	  .digitarTelefone("1111111")
	  .selecionaPaís("Brazil")
	  .digitarCidade("Itaquera")
	  .digitarRua("Rua 12")
	  .digitarEstado("São Paulo")
	  .digitarCodigoPostal("09483092")
	  .aceitarTermoUso()
	  .enviarFormulario();
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver = Web.createChrome();
  }

  @AfterMethod
  public void afterMethod() {
	  
	  
	  //driver = Web.fecharDriver();
  }

}
