package com.one.Test2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AskEva {

	
	ChromeDriver driver;
	ExtentReports extentReports = new ExtentReports();
	
	@BeforeTest
	public void CreateReport() {
		
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("./FlightAsk/Pass.html");
		extentReports.attachReporter(extentSparkReporter);
		
		ExtentSparkReporter extentSparkReporter1 = new ExtentSparkReporter("./FlightAsk/Fail.html");
		extentReports.attachReporter(extentSparkReporter1);
		
		extentSparkReporter.filter().statusFilter().as(new Status[] {Status.PASS}).apply();
		extentSparkReporter1.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
	}

	@AfterTest
	public void push() {
		extentReports.flush();
	}
	
	@Test
	public void Social() throws InterruptedException, IOException {
		
		ExtentTest extentTest = extentReports.createTest("This is Social Media report");
		extentTest.assignAuthor("Ushe");
		extentTest.assignDevice("WindowsXP");
		extentTest.assignCategory("Functional Test");
		
//		ChromeOptions options = new ChromeOptions();	
//		options.addArguments("--disable-notifications");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.easemytrip.com");
		WebElement ASK= driver.findElement(By.xpath("(//img[@class='_rohChatAI'])[1]"));

		ASK.click();
		extentTest.log(Status.PASS,"Virtual Agent is ready to chat");
		Thread.sleep(3000);
		driver.findElement(By.id("BookHoliday")).click();
		Thread.sleep(4000);
		WebElement Response1 = driver.findElement(By.xpath("/html/body/div[11]/div[2]/div[2]/div[1]/div[3]/div/div[1]"));
				String Response= Response1.getText();
		System.out.println(Response);
		if (Response.contains("Welcome to EMT Holidays!")) {
			extentTest.log(Status.PASS,"User can successfully ask Queries to the the Virtual Agent");
			System.out.println("User can successfully ask Queries to the the Virtual Agent");
		}else
		{
			extentTest.log(Status.FAIL,"User is unable to ask Queries to the the Virtual Agent");
			System.out.println("User is unable to ask Queries to the the Virtual Agent");
			
		}
		
		File Image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Destination = new File("./ScreenShotsASk/ASK.png");
		FileUtils.copyFile(Image, Destination);
		
		extentTest.addScreenCaptureFromPath("C:/ushe/Eclipse_Ushe/Flight/ScreenShotsASk/ASK.png","Can chat with Virtual Agent");
		
	}
}
