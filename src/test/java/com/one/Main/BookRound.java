// TestngRound.xml




package com.one.Main;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.one.pom.Booking;
import com.one.pom.DataBookRound;
import com.one.pom.Search;
import com.one.pom.Summary;

public class BookRound {
	ChromeDriver driver;
	ExtentReports extentReports = new ExtentReports();
	@BeforeTest
	public void createreports() {
		
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("../target/FlightRound/Pass.html");
		extentReports.attachReporter(extentSparkReporter);
		
		ExtentSparkReporter extentSparkReporter1 = new ExtentSparkReporter("./target/FlightRound/Fail.html");
		extentReports.attachReporter(extentSparkReporter1);
		
		extentSparkReporter.filter().statusFilter().as(new Status[] {Status.PASS}).apply();
		extentSparkReporter1.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
		}
	@AfterTest
	public void push() {
		extentReports.flush();
	}
	
	
@Test(dataProvider= "data", dataProviderClass = DataBookRound.class)	
	public void bookRound(String Start, String StartPlace,String Dest, String DestPlace, String DepDate, String ReDate) throws InterruptedException, IOException {
		
		ExtentTest extentTest = extentReports.createTest("This is report for Round Trip");
		extentTest.assignAuthor("Ushe");
		extentTest.assignDevice("Windows Xp");
		extentTest.assignCategory("Funtional Test");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.easemytrip.com/");
		
		Search search = new Search(driver);
		search.RoundTrip();
		search.FromPlace(Start, StartPlace);
		search.DestPlace(Dest, DestPlace);
		extentTest.log(Status.INFO, "Start and Destination places are selected");
		search.arrow();
		search.DepartureDate(DepDate);
		search.ReturnDate(ReDate);
		search.Travellers();
		extentTest.log(Status.INFO, "Start and Return dates are selected");
		
		Booking Booked = new Booking(driver);
		Booked.clickOnTraveller();
		String BookAdultCount = Booked.BookAdult();
		String BookChildCount = Booked.BookChild();
		String BookInfantCount = Booked.BookInfant();
		Booked.clickOnBook();
		
		Summary summary = new Summary(driver);
		String AdultCount = summary.CheckAdult();
//		String two= AdultCount;
		String ChildCount = summary.CheckChild();
		String InfantCount= summary.CheckInfant();
		
		if (BookAdultCount.contains(AdultCount)	&& BookChildCount.contains(ChildCount) 
			&& BookInfantCount.contains(InfantCount)) 
			{System.out.println("The Booking is successful");
			extentTest.log(Status.PASS,"The Booking is successful");
			
		}else
		{System.out.println("Count of people displayed is incorrect");
			extentTest.log(Status.FAIL,"Count of people displayed is incorrect");
		}
		
		File Image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Destination = new File("./ScreenShotsRound/Round.png");
		FileUtils.copyFile(Image, Destination);
		
		extentTest.addScreenCaptureFromPath("C:/ushe/Eclipse_Ushe/Flight/ScreenShotsRound/Round.png","Tickets");
				
		
	}

}
