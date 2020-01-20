package br.com.rsinet.hub_tdd.automationFramework;

import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_tdd.pageObjects.BuscaProdutoLupaPage;
import br.com.rsinet.hub_tdd.suporte.Web;
import br.com.rsinet.hub_tdd.utility.ExcelUtils;

public class PesquisaPelaLupa {
	private static WebDriver driver = Web.createChrome();
	
	public static void main(String[] args) throws Exception {
		new BuscaProdutoLupaPage(driver)
		.clicarLupa()
		.campoDePesquisa(ExcelUtils.getCellData(0, 0))
		.selecionaProduto();
		
	}

}
