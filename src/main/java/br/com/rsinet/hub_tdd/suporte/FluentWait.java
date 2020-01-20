//package br.com.rsinet.hub_tdd.suporte;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Wait;
//
//import br.com.rsinet.hub_tdd.utility.ExcelUtils;
//
//public class FluentWait {
//	private static WebDriver driver = Web.createChrome();
//	
//	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
//			.pollingEvery(Duration.ofSeconds(5))
//			.ignoring(NoSuchElementException.class);
//	
//	WebElement foo = wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("/html/body")), null));	
//			
//
//}
