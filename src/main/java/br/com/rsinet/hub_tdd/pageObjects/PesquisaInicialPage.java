package br.com.rsinet.hub_tdd.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_tdd.utility.Constante;
import br.com.rsinet.hub_tdd.utility.ExcelUtils;

public class PesquisaInicialPage {
	private WebDriver driver;

	public PesquisaInicialPage(WebDriver driver) {
		this.driver = driver;
	}

	public PesquisaInicialPage categoriaLaptop () {
		driver.findElement(By.id("laptopsImg")).click();
		return this;
}
	
	public PesquisaInicialPage escolheProduto () throws Exception {
		ExcelUtils.setExcelFile(Constante.Path_TestData + Constante.File_TestData, "Pesquisa pagina inicial");
		String produto = (ExcelUtils.getCellData(1, 0));
		driver.findElement(By.linkText(produto)).click();
//		driver.findElement(By.id("8")).click();
//		//*[. ='']
//		
//		driver.findElement(By.xpath("//*[. ='"+produto+"']")).click();
//		
		
		return this;
	}
	
	public PesquisaInicialPage addAoCarrinho () {
		driver.findElement(By.name("save_to_cart")).click();
		return this;
	}
	public PesquisaInicialPage checkOut () {
		driver.findElement(By.id("checkOutPopUp")).click();
		return this;
	}
	public PesquisaInicialPage user(String user) {
		driver.findElement(By.name("usernameInOrderPayment")).sendKeys(user);
		return this;
	}
	public PesquisaInicialPage senha (String senha) {
		driver.findElement(By.name("passwordInOrderPayment")).sendKeys(senha);
		return this;
	}
	public PesquisaInicialPage logar() {
		driver.findElement(By.id("login_btnundefined")).click();
		return this;
	}
	
	public PesquisaInicialPage pagamento () {
		driver.findElement(By.id("next_btn")).click();
		return this;
	}
	public PesquisaInicialPage inserirLogin (String inserirLogin) throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id("safepay_username")).sendKeys(inserirLogin);
		return this;
	}
	public PesquisaInicialPage inserirSenha (String inserirSenha) {
		driver.findElement(By.id("safepay_password")).sendKeys(inserirSenha);
		return this;
	}
	public PesquisaInicialPage confirmarPagamento () {
		driver.findElement(By.id("pay_now_btn_SAFEPAY")).click();
		return this;
 }
	public PesquisaInicialPage quantidade() {
		driver.findElement(By.name("quantity")).sendKeys("11");
		return this;
	}
	
}
