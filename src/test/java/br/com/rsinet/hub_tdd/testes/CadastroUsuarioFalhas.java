package br.com.rsinet.hub_tdd.testes;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.hub_tdd.pageObjects.HomePage;
import br.com.rsinet.hub_tdd.suporte.Screenshot;
import br.com.rsinet.hub_tdd.suporte.Web;
import br.com.rsinet.hub_tdd.utility.Constante;
import br.com.rsinet.hub_tdd.utility.ExcelUtils;

public class CadastroUsuarioFalhas {
	private WebDriver driver;
	
	ExtentReports extensao;
	ExtentTest logger;

	@BeforeMethod
	public void beforeMethod() {
		driver = Web.createChrome();

	}

	@Test
	public void TesteFalhoCadastro() throws Exception {
		ExcelUtils.setExcelFile(Constante.Path_TestData + Constante.File_TestData, "Cadastro");
		new HomePage(driver).clickUser().digitarLogin(ExcelUtils.getCellData(1, 0))
				.digitarEmail(ExcelUtils.getCellData(1, 1)).digitarSenha(ExcelUtils.getCellData(1, 2))
				.confirmarSenha(ExcelUtils.getCellData(1, 3)).digitarNome(ExcelUtils.getCellData(1, 4))
				.digitarSobrenome(ExcelUtils.getCellData(1, 5)).digitarTelefone(ExcelUtils.getCellData(1, 6))
				.selecionaPaís(ExcelUtils.getCellData(1, 7)).digitarCidade(ExcelUtils.getCellData(1, 8))
				.digitarRua(ExcelUtils.getCellData(1, 9)).digitarEstado(ExcelUtils.getCellData(1, 10))
				.digitarCodigoPostal(ExcelUtils.getCellData(1, 11)).aceitarTermoUso().enviarFormulario();

		ExtentHtmlReporter reporte = new ExtentHtmlReporter("C:\\Users\\caique.oliveira\\Pictures\\Reports\\TesteFalhoCadastro.html");

		extensao = new ExtentReports();

		extensao.attachReporter(reporte);

		logger = extensao.createTest("Cadastro Falhou");

	}

	@AfterMethod
	public void afterMethod() throws IOException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String mensagem = driver
				.findElement(By.xpath("/html/body/div[3]/section/article/sec-form/div[1]/div[2]/div/div[1]/div[1]/sec-view[1]/div/label")).getText();
		System.out.println(mensagem);
		Assert.assertTrue(mensagem.equals("Use maximum 15 character"),"Usuário incorreto");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("javascript:window.scrollBy( 0,200)");
		Screenshot.tirar(driver, "Falha ao cadastrar usuário");
		extensao.flush();
		Web.fecharDriver();
	}

}
