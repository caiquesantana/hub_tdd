package br.com.rsinet.hub_tdd.automationFramework;

import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_tdd.pageObjects.PesquisaInicialPage;
import br.com.rsinet.hub_tdd.suporte.Web;

public class PesquisaPaginaInicial {
	private static WebDriver driver = Web.createChrome();
	
	public static void main(String[] args) {
		
		new PesquisaInicialPage(driver)
		.categoriaLaptop()
		.escolheProduto()
		.addAoCarrinho()
		.checkOut()
		.user("CaiqueOliveira")
		.senha("Caique1")
		.logar()
		.pagamento()
		.confirmarPagamento();
		
		
	}

	private static void LogInPage() {
		// TODO Auto-generated method stub
		
	}

}
