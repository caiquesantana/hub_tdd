package br.com.rsinet.hub_tdd.automationFramework;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_tdd.pageObjects.HomePage;
import br.com.rsinet.hub_tdd.suporte.Screenshot;
import br.com.rsinet.hub_tdd.suporte.Web;

public class PageObjectModel {
	private WebDriver driver;
	
	@Rule
	public TestName evidencia = new TestName();
	
	@Before
	public void setUp() {
		driver = Web.createChrome();
	}
	
	@Test
	public void cadastraNovoUsuario() {
		new HomePage(driver)
		.clickUser()
		.digitarLogin("pedro")
		.digitarEmail("caique.ol@rsinet.com")
		.digitarSenha("Caique1")
		.confirmarSenha("Caique1")
		.digitarNome("Caiique")
		.digitarSobrenome("Santana")
		.digitarTelefone("99999-2344")
		.selecionaPaís("Brazil")
		.digitarCidade("Osasco")
		.digitarRua("Autonomista")
		.digitarEstado("São Paulo")
		.digitarCodigoPostal("064563-059")
		.aceitarTermoUso()
		.enviarFormulario();
	
		Screenshot.tirar(driver, "C://Users//caique.oliveira//Pictures//test-report"
					+ evidencia.getMethodName() + ".png");
}
	
}
