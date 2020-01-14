package br.com.rsinet.hub_tdd.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CriarNovaContaFormPage {

	private WebDriver driver;

	public CriarNovaContaFormPage(WebDriver driver) {
		this.driver = driver;
	}

	public CriarNovaContaFormPage digitarLogin(String login) {
		driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]")).click();
		driver.findElement(By.name("usernameRegisterPage")).sendKeys(login);
		return this;
	}

	public CriarNovaContaFormPage digitarEmail(String email) {
		driver.findElement(By.name("emailRegisterPage")).sendKeys(email);
		return this;
	}

	public CriarNovaContaFormPage digitarSenha(String senha) {
		driver.findElement(By.name("passwordRegisterPage")).sendKeys(senha);
		return this;
	}

	public CriarNovaContaFormPage confirmarSenha(String confirmaSenha) {
		driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys(confirmaSenha);
		return this;
	}

	public CriarNovaContaFormPage digitarNome(String nome) {
		driver.findElement(By.name("first_nameRegisterPage")).sendKeys(nome);
		return this;
	}

	public CriarNovaContaFormPage digitarSobrenome(String sobreNome) {
		driver.findElement(By.name("last_nameRegisterPage")).sendKeys(sobreNome);
		return this;
	}

	public CriarNovaContaFormPage digitarTelefone(String contato) {
		driver.findElement(By.name("phone_numberRegisterPage")).sendKeys(contato);
		return this;
	}

	public CriarNovaContaFormPage selecionaPaís(String nacionalidade) {
		WebElement país = driver.findElement(By.name("countryListboxRegisterPage"));

		new Select(país).selectByVisibleText(nacionalidade);

		return this;
	}

	public CriarNovaContaFormPage digitarCidade(String cidade) {
		driver.findElement(By.name("cityRegisterPage")).sendKeys(cidade);
		return this;
	}

	public CriarNovaContaFormPage digitarRua(String rua) {
		driver.findElement(By.name("addressRegisterPage")).sendKeys(rua);
		return this;
	}

	public CriarNovaContaFormPage digitarEstado(String estado) {
		driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys(estado);
		return this;
	}

	public CriarNovaContaFormPage digitarCodigoPostal(String cep) {
		driver.findElement(By.name("postal_codeRegisterPage")).sendKeys(cep);
		return this;
	}

	public CriarNovaContaFormPage aceitarTermoUso() {
		driver.findElement(By.name("i_agree")).click();
		return this;
	}

	public AreaLogada enviarFormulario() {
		driver.findElement(By.id("register_btnundefined")).click();
		return new AreaLogada(driver);

	}
}