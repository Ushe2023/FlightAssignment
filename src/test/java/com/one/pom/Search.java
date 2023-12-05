//Search Page

package com.one.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Search {
	
ChromeDriver myDriver;
	
	public Search(ChromeDriver myDriver)
	{
		this.myDriver = myDriver;
		myDriver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	private By one = By.id("oway");	
	private By round = By.id("rtrip");


	public void OneTrip() {
		myDriver.findElement(one).click();
		System.out.println("Selected one way option");
	}
	public void RoundTrip() {
		myDriver.findElement(round).click();
		System.out.println("Selected round way option");
	}
	private By From = By.id("FromSector_show");	
	private By From1 = By.id("a_FromSector_show");	
//	private By place2= By.xpath("//span[text()= 'Bangalore(BLR)']");
	
	public void FromPlace(String Start,String StartPlace) throws InterruptedException {
		final By Fplace2= By.xpath(Start);
		
		myDriver.findElement(From).click();
//        myDriver.findElement(From).sendKeys("Bang");
        myDriver.findElement(From1).sendKeys(StartPlace);
        System.out.println("Selected hyd");
Thread.sleep(4000);
        myDriver.findElement(Fplace2).click();
	}	
	
	private By Destination = By.id("Editbox13_show");
	private By Destination2 = By.id("a_Editbox13_show");
	
	
	public void DestPlace(String Dest,String DestPlace) throws InterruptedException {
		final By Dplace= By.xpath(Dest);
        myDriver.findElement(Destination).sendKeys(DestPlace);
        myDriver.findElement(Destination2).sendKeys(DestPlace);
        System.out.println("Selected New Delhi");
        Thread.sleep(4000);
        myDriver.findElement(Dplace).click();
	
	}
	private By ArrowR = By.id("img2Nex");
	public void arrow() {
		myDriver.findElement(ArrowR).click();
//		myDriver.findElement(ArrowR).click();
	}
	
	public void DepartureDate(String DepDate1) throws InterruptedException {
		final By DepDate = By.id(DepDate1);
		 Thread.sleep(4000);
		myDriver.findElement(DepDate).click();
		System.out.println("Departure date: "+DepDate);
	}
	
	
	public void ReturnDate(String ReDate1) throws InterruptedException {
		final By ReDate = By.id(ReDate1);
//		myDriver.findElement(ReturnDate).click();
		 Thread.sleep(4000);
		myDriver.findElement(ReDate).click();
		System.out.println("Return date: "+ReDate);
	}
	
	private By Traveller = By.id("ptravlrNo");
	private By Adult = By.xpath("(//button[@id='add'])[1]");
	private By Child = By.xpath("(//button[@id='add'])[2]");
	private By Infant = By.xpath("(//button[@id='add'])[3]");
	private By Done = By.id("traveLer");
	private By Search = By.xpath("//button[@ class='srchBtnSe']");
	
	public void Travellers() {
		myDriver.findElement(Traveller).click();
//		myDriver.findElement(Adult).click();//by default adult=1
		myDriver.findElement(Child).click();
		myDriver.findElement(Child).click();
		myDriver.findElement(Infant).click();
		myDriver.findElement(Done).click();
		System.out.println("travellers");
		myDriver.findElement(Search).click();
		
	
	}
}
