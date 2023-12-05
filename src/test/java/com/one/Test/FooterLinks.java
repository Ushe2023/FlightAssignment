//Verifying the links of footer

package com.one.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class FooterLinks {
	ChromeDriver driver;	
	ChromeOptions options =new ChromeOptions();
	
	@Test
	public void book(){
			
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("https://www.easemytrip.com");
		
		WebElement OurOfferings =driver.findElement(By.xpath("/html/body/div[7]/div[2]/div[1]/div[1]/ul/li[2]"));
		
		OurOfferings.click();
		
		List<WebElement> output = driver.findElements(By.xpath("(//div[@class=\"menulinkx\"])[2]/ul/li"));
		
		for(WebElement i : output)
		{
			System.out.println(i.getText());
		}
		System.out.println(output.size());
		
	}
	
}
