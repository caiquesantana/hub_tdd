package br.com.rsinet.hub_tdd.suporte;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

	public class Screenshot {
	    public static void tirar(WebDriver driver, String arquivo) throws IOException {
	        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        File destino = new File ("C:\\Users\\caique.oliveira\\Pictures\\prints\\" + arquivo + DataHora ()+".png" );
	        FileUtils.copyFile(screenshot, destino);
	        driver.manage().timeouts().implicitlyWait(02, TimeUnit.SECONDS);
	        }
	    public static String DataHora () {
	    	return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	    }
}
