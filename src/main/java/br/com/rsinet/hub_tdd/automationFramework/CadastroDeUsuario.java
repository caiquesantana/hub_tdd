package br.com.rsinet.hub_tdd.automationFramework;

import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_tdd.pageObjects.HomePage;
import br.com.rsinet.hub_tdd.suporte.Screenshot;
import br.com.rsinet.hub_tdd.suporte.Web;
import br.com.rsinet.hub_tdd.utility.Constante;
import br.com.rsinet.hub_tdd.utility.ExcelUtils;

public class CadastroDeUsuario {
	private static WebDriver driver = Web.createChrome();
	
	@Rule
	public static TestName evidencia = new TestName();

	public static void main(String[] args) throws Exception {
		
		ExcelUtils.setExcelFile(Constante.Path_TestData + Constante.File_TestData, "Planilha1");
//		driver = Web.createChrome();
//		driver = new ChromeDriver();
//		driver.get("http://advantageonlineshopping.com/");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		new HomePage(driver)
		.clickUser()
		.digitarLogin(ExcelUtils.getCellData(1, 0))
		.digitarEmail(ExcelUtils.getCellData(1, 1))
		.digitarSenha(ExcelUtils.getCellData(1, 2))
		.confirmarSenha(ExcelUtils.getCellData(1, 3))
		.digitarNome(ExcelUtils.getCellData(1, 4))
		.digitarSobrenome(ExcelUtils.getCellData(1, 5))
		.digitarTelefone(ExcelUtils.getCellData(1, 6))
		.selecionaPaís(ExcelUtils.getCellData(1, 7))
		.digitarCidade(ExcelUtils.getCellData(1, 8))
		.digitarRua(ExcelUtils.getCellData(1, 9))
		.digitarEstado(ExcelUtils.getCellData(1, 10))
		.digitarCodigoPostal(ExcelUtils.getCellData(1, 11))
		.aceitarTermoUso()
		.enviarFormulario();
			
		Screenshot.tirar(driver, "C://Users//caique.oliveira//Pictures//test-report"
					+ evidencia.getMethodName() + ".png");
}
	
}
