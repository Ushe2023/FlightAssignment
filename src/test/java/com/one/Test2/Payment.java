//Verify that the user is able to navigate to payment page where the payment details and Billing address is added.
//User to select a flight from the Search Details Page, Enter Passenger Details and proceed to payment page.
//xml file=testngpay


package com.one.Test2;

import java.io.File;
import java.io.IOException;
//import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Payment {
	
	ChromeDriver driver;
	ExtentReports extentReports = new ExtentReports();
	
	@BeforeTest
	public void createReport() {
		
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("./target/FlightPayment/pass.html");
		extentReports.attachReporter(extentSparkReporter);
		
		ExtentSparkReporter extentSparkReporter1 = new ExtentSparkReporter("./target/FlightPayment/fail.html");
		extentReports.attachReporter(extentSparkReporter1);
		
		extentSparkReporter.filter().statusFilter().as(new Status[] {Status.PASS}).apply();
		extentSparkReporter1.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
		
	}
	
	@AfterTest
	public void push() {
		extentReports.flush();
	}
	
	@Parameters({"Website","FromPlace","FromPl","ToPlace","ToPl","Date","Title1","FirstN","LastN","PhoneN","EMail"})
	
@Test
public void Paymentbook( String Website, String FromPlace, String FromPl, String ToPlace,String ToPl, String Date,
		String Title1,String FirstN,String LastN,String PhoneN,String EMail) throws InterruptedException, IOException {
	
	ExtentTest extentTest = extentReports.createTest("We are testing Payment");
	extentTest.assignAuthor("Ushe");
	extentTest.assignDevice("Windows XP");
	extentTest.assignCategory("Functional Test");
	
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	
	driver = new ChromeDriver(options);
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get(Website);
	String wtitle= driver.getTitle();
	System.out.println(wtitle);
		
	driver.findElement(By.id("oway")).click();
	driver.findElement(By.id("FromSector_show")).click();
	driver.findElement(By.id("a_FromSector_show")).sendKeys(FromPlace);
	driver.findElement(By.xpath(FromPl)).click();
	
	driver.findElement(By.id("a_Editbox13_show")).sendKeys(ToPlace);
	driver.findElement(By.xpath(ToPl)).click();
	
	driver.findElement(By.id(Date)).click();
//	driver.findElement(By.id("18/01/2024")).click();
	driver.findElement(By.id("ptravlrNo")).click();
	driver.findElement(By.xpath("//button[@ class='srchBtnSe']")).click();
	
	extentTest.log(Status.PASS, " Place and date Details are entered");
	
	driver.findElement(By.xpath("/html/body/form/div[11]/div[7]/div/div[2]/div[4]/div/div/div[4]/div[2]/div[1]/div[1]/div[6]/button[1]")).click();

	extentTest.log(Status.PASS,"Flight are displayed");
	Thread.sleep(5000);
	WebElement radio = driver.findElement(By.xpath("//label[normalize-space()='No, I do not want to insure my trip']//span[@class='checkmark-radio']"));
	radio.click();


	System.out.println("No, I do not want to insure my trip is clicked");
	
	driver.findElement(By.id("txtEmailId")).sendKeys(EMail);
	driver.findElement(By.id("spnVerifyEmail")).click();
	
	WebElement Title = driver.findElement(By.id("titleAdult0"));
	Select s = new Select(Title);
	
	s.selectByValue(Title1);
	driver.findElement(By.id("txtFNAdult0")).sendKeys(FirstN);
	driver.findElement(By.id("txtLNAdult0")).sendKeys(LastN);
	driver.findElement(By.id("txtCPhone")).sendKeys(PhoneN);
	
	Thread.sleep(3000);
	driver.findElement(By.id("spnTransaction")).click();
	extentTest.log(Status.PASS,"Personal details are entered");
	driver.findElement(By.xpath("//div[@id='seatPo_0']//a[@class='edit_btn'][normalize-space()='Skip']")).click();
	driver.findElement(By.id("skipPop")).click();
	
	
	Thread.sleep(3000);
	WebElement payment= driver.findElement(By.xpath("//span[normalize-space()='PAYMENT MODE']"));
	if (payment.isDisplayed()) {
		System.out.println("User is able to enter to the payment page where the details can be added");
		extentTest.log(Status.PASS,"User is able to enter to the payment page where the details can be added");
	}
	else {
		extentTest.log(Status.FAIL, "User is unable to enter the payment page");
		System.out.println("User is unable to enter the payment page");
	}
		 
	
	     File Image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 File Destination= new File ("./Screenshot/Payment.png");
		 FileUtils.copyFile(Image, Destination);
		 
		 extentTest.addScreenCaptureFromPath("C:/ushe/Eclipse_Ushe/Flight/Screenshot/Payment.png", "Payment page");
 
	
}

}
