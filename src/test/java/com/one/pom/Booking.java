//Booking Page

package com.one.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Booking {
	ChromeDriver myDriver;
	
	public Booking(ChromeDriver myDriver)
	{
		this.myDriver = myDriver;
		myDriver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		System.out.println("Book click");
	}
		private By BookNow= By.xpath("(//button[contains(@type,'button')][normalize-space()='Book Now'])[1]");
									  
		private By BookAdult = By.id("optadult");
	private By BookTraveller = By.id("trvSearch");
//			By.xpath("/html/body/form/div[11]/div[7]/div[1]/div[4]/div/div/div[1]/div/div[2]/div[2]/div[3]/div/i");
	
										
	private By BookChild = By.id("optChild");
	private By BookInfant = By.id("optInfant");
	
	
	public void clickOnTraveller() throws InterruptedException {
		Thread.sleep(15000);
		myDriver.findElement(BookTraveller).click();
	}
 public String BookAdult() {
	 WebElement BookAdultCountOption = myDriver.findElement(BookAdult);
	 Select select = new Select(BookAdultCountOption);
	 String BookAdultCount= select.getFirstSelectedOption().getText();
	 
//	 String BookAdultCount= new Select(BookAdultCount)
	 System.out.println("Adult count in booking page" +BookAdultCount);
	 return BookAdultCount;
 }
 public String BookChild() {
	 WebElement BookChildCountOption = myDriver.findElement(BookChild);
	 Select select = new Select(BookChildCountOption);
	 String BookChildCount= select.getFirstSelectedOption().getText();
//	 String BookChildCount = myDriver.findElement(BookChild).getText();
	 System.out.println("Child count in booking page" +BookChildCount);
	 return BookChildCount;
 }
 public String BookInfant() {
	 
	 WebElement BookInfantCountOption = myDriver.findElement(BookInfant);
	 Select select = new Select(BookInfantCountOption);
	 String BookInfantCount= select.getFirstSelectedOption().getText();
//	 String BookInfantCount = myDriver.findElement(BookInfant).getText();
	 System.out.println("Infant count in booking page" +BookInfantCount);
	 return BookInfantCount;
 }
 public void clickOnBook()
	{
		myDriver.findElement(BookNow).click();
	}
}
