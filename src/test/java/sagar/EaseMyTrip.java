package sagar;

import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.StaleElementReferenceException;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class EaseMyTrip {
	@Test(dataProvider= "pleaseProvideTheData", dataProviderClass= DataProviderConcept.class)
	public void EaseMyTripPage(String FromDestination,String ToDestination,String Ddate) throws InterruptedException 
	{
		
		ChromeDriver driver=new ChromeDriver();
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("disable-notifications");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://www.easemytrip.com");
		driver.findElement(By.id("FromSector_show")).click();
		driver.findElement(By.id("a_FromSector_show")).sendKeys(FromDestination);
		try
		{	
			Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/form/div[5]/div[3]/div/div[3]/div/div[1]/div[2]/div[2]/ul/li[7]/div/div[1]/p[1]/span")).click();
		}
		catch(StaleElementReferenceException e)
		{
			driver.findElement(By.xpath("/html/body/form/div[5]/div[3]/div/div[3]/div/div[1]/div[2]/div[2]/ul/li[7]/div/div[1]/p[1]/span")).click();
			
		}
		Thread.sleep(3000);
	    driver.findElement(By.id("a_Editbox13_show")).sendKeys(ToDestination);
		try
		{
			Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/form/div[5]/div[3]/div/div[3]/div/div[3]/div[2]/div[2]/ul/li[2]/div/div[1]/p[2]")).click();
        
		}
		catch(StaleElementReferenceException e)
		{
		driver.findElement(By.xpath("/html/body/form/div[5]/div[3]/div/div[3]/div/div[3]/div[2]/div[2]/ul/li[2]/div/div[1]/p[1]/span"));
		}
	   driver.findElement(By.xpath(Ddate)).click();
	   }
}

