package br.com.rsinet.hub_tdd.automationFramework;

import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_tdd.pageObjects.BuscaProdutoLupaPage;
import br.com.rsinet.hub_tdd.suporte.Web;

public class PesquisaPelaLupa {
	private static WebDriver driver = Web.createChrome();
	
	public static void main(String[] args) {
		new BuscaProdutoLupaPage(driver)
		.clicarLupa()
		.campoDePesquisa("HP PAVILION 15Z TOUCH LAPTOP")
		.selecionaProduto();
		
	}

}
