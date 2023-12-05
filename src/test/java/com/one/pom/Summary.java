//Summary Page

package com.one.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

public class Summary {

ChromeDriver myDriver;
	
	public Summary(ChromeDriver myDriver)
	{
		this.myDriver = myDriver;
	}
	
	private By Adult= By.id("divNoAdult");
		
	private By Child= By.id("divNoChild");
	
	private By Infant= By.id("divNoInfant");
	
//	String AdultCount = myDriver.findElement(Adult).getText();
	
	public String CheckAdult()
	{
		String AdultCount = myDriver.findElement(Adult).getText();
		System.out.println("Number of Adults: "+AdultCount);
		return AdultCount;
		
	}
	public String CheckChild()
	{
		String ChildCount = myDriver.findElement(Child).getText();
		System.out.println("Number of Children: "+ChildCount);
		return ChildCount;
	}

	public String CheckInfant()
	{
		String InfantCount = myDriver.findElement(Infant).getText();
		System.out.println("Number of Infant: "+InfantCount);
		return InfantCount;
	}

}
