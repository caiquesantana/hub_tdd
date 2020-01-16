package br.com.rsinet.hub_tdd.automationFramework;

import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_tdd.pageObjects.PesquisaInicialPage;
import br.com.rsinet.hub_tdd.suporte.Web;
import br.com.rsinet.hub_tdd.utility.Constante;
import br.com.rsinet.hub_tdd.utility.ExcelUtils;

public class PesquisaPaginaInicial {
	private static WebDriver driver = Web.createChrome();
	
	public static void main(String[] args) throws Exception {
		ExcelUtils.setExcelFile(Constante.Path_TestData + Constante.File_TestData, "Planilha1");
		
		new PesquisaInicialPage(driver)
		.categoriaLaptop()
		.escolheProduto();
//		.addAoCarrinho()
//		.checkOut()
//		.user(ExcelUtils.getCellData(1, 0))
//		.senha(ExcelUtils.getCellData(1, 2))
//		.logar()
//		.pagamento()
//		.confirmarPagamento();
		
		
	}

}
