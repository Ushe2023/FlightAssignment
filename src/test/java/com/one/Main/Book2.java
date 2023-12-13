package com.one.Main;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.one.pom.Booking;
import com.one.pom.DataOne;
import com.one.pom.Search;
import com.one.pom.Summary;



public class Book2 {
ChromeDriver driver ;
//ChromeOptions options =new ChromeOptions();
ExtentReports extentReport = new ExtentReports();
@BeforeTest
public void createReports() {
	ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("./target/Flight/Pass.html");
	extentReport.attachReporter(extentSparkReporter);
	
	ExtentSparkReporter extentSparkReporter2 =new ExtentSparkReporter("./target/Flight/Fail.html");
	extentReport.attachReporter(extentSparkReporter2);
	
	extentSparkReporter.filter().statusFilter().as(new Status[] {Status.PASS}).apply();
	extentSparkReporter2.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
}
@AfterTest
public void push() {
	extentReport.flush();
}

@Test(dataProvider = "Data", dataProviderClass = DataOne.class)
public void book(String Start, String StartPlace,String Dest, String DestPlace, String DepDate) throws InterruptedException, IOException {
	
	
	ExtentTest extentTest = extentReport.createTest("This is Flight Booking Report");
	extentTest.assignAuthor("Ushe");
	extentTest.assignDevice("Windows XP");
	extentTest.assignCategory("Functional Testing");
	
	ChromeOptions options =new ChromeOptions();
	
	options.addArguments("--disable-notifications");
	driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get("https://www.easemytrip.com/");
	extentTest.log(Status.PASS, "Logged into browser");
	Search search = new Search(driver);
	
	search.OneTrip();
	
//	search.RoundTrip();
	search.FromPlace(Start,StartPlace);	
	extentTest.log(Status.PASS,"Selected Start place");
	search.DestPlace(Dest,DestPlace);
	extentTest.log(Status.PASS,"Selected Destination place");
	search.DepartureDate(DepDate);
	extentTest.log(Status.PASS,"Departure Date selected");
//	search.ReturnDate();
	search.Travellers();
	
	Booking Booked = new Booking(driver);
	
	extentTest.log(Status.INFO,"Booking Successfully");
	Booked.clickOnTraveller();
	String BookAdultCount = Booked.BookAdult();
	String BookChildCount = Booked.BookChild();
	String BookInfantCount = Booked.BookInfant();
	Booked.clickOnBook();
	
	Summary summary = new Summary(driver);
	String ActualPlace = summary.FromToPlace();
	String AdultCount = summary.CheckAdult();
//	String two= AdultCount;
	String ChildCount = summary.CheckChild();
	String InfantCount= summary.CheckInfant();
	String ExpectedPlace = "Delhi - Hyderabad";
	
	
	if (BookAdultCount.contains(AdultCount)	&& BookChildCount.contains(ChildCount) && (ActualPlace.contains(ExpectedPlace))
		&& BookInfantCount.contains(InfantCount)) 
		{System.out.println("The Booking is successful");
		extentTest.log(Status.PASS,"The Booking is successful");
	}else
	{System.out.println("Count of people displayed is incorrect");
		extentTest.log(Status.FAIL,"Count of people displayed is incorrect");
	}
	File Image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File Destination = new File("./Screenshot/Ticket.png");
	FileUtils.copyFile(Image, Destination);
	
	extentTest.addScreenCaptureFromPath("C:/ushe/Eclipse_Ushe/Flight/Screenshot/Ticket.png", "Ticket Details");


}
}
