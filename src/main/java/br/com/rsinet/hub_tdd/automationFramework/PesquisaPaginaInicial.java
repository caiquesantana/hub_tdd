package br.com.rsinet.hub_tdd.automationFramework;

import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_tdd.pageObjects.PesquisaInicialPage;
import br.com.rsinet.hub_tdd.suporte.Web;

public class PesquisaPaginaInicial {
	private static WebDriver driver = Web.createChrome();
	
	public static void main(String[] args) throws Exception {
		
		new PesquisaInicialPage(driver)
		.categoriaLaptop()
		.escolheProduto();
//	.addAoCarrinho();
//		.checkOut()
//		.user(ExcelUtils.getCellData(1, 0))
//		.senha(ExcelUtils.getCellData(1, 2))
//		.logar()
//		.pagamento()
//		.inserirLogin(ExcelUtils.getCellData(1, 0))
//		.inserirSenha(ExcelUtils.getCellData(1, 2))
//		.confirmarPagamento();

	}

}
