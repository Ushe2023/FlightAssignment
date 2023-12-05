package com.one.Test2;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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

public class SocialMedia {
	
	ChromeDriver driver;
	ExtentReports extentReports = new ExtentReports();
	
	@BeforeTest
	public void CreateReport() {
		
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("./FlightSocialMedia/Pass.html");
		extentReports.attachReporter(extentSparkReporter);
		
		ExtentSparkReporter extentSparkReporter1 = new ExtentSparkReporter("./FlightSocialMedia/Fail.html");
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
		
		ChromeOptions options = new ChromeOptions();	
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.easemytrip.com");
		
		driver.findElement(By.xpath("(//li[@class='connttb'])[1]")).click();
		
		driver.findElement(By.xpath("(//a[normalize-space()='Facebook'])[1]")).click();
		String windowParent = driver.getWindowHandle();
		Set<String> window= driver.getWindowHandles();
		for(String newWindow : window) {
			driver.switchTo().window(newWindow);
		}

		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@aria-label='Close'])[1]")).click();
		String title = driver.getTitle();
		System.out.println(title);
		if (title.contains("Facebook")) {
			System.out.println("Link correctly navigates to facebook");
			extentTest.log(Status.PASS,"Link correctly navigates to facebook");
		}
		else
		{
			System.out.println("Link does not navigate to facebook");
			extentTest.log(Status.FAIL,"Link does not navigate to facebook");
		}
		File Image3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Destination3 = new File("./ScreenshotSocialMedia/Facebook.png");
		FileUtils.copyFile(Image3, Destination3);
		extentTest.addScreenCaptureFromPath("C:/ushe/Eclipse_Ushe/Flight/ScreenshotSocialMedia/Facebook.png", "Facebook Page");
		
		
		
		driver.switchTo().window(windowParent);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='https://twitter.com/easemytrip']")).click();
		String windowParent1 = driver.getWindowHandle();
		Set <String> windowTwitter = driver.getWindowHandles();
		for(String newWindow: windowTwitter) {
			driver.switchTo().window(newWindow);
			}
		
		Thread.sleep(3000);
		String TitleTwitter = driver.getTitle();
		System.out.println(TitleTwitter);
		if (TitleTwitter.contains("X")) {
			System.out.println("Link correctly navigates to Twitter");
			extentTest.log(Status.PASS,"Link correctly navigates to Twitter");
		}else
		{
			System.out.println("Link does not navigate to Twitter");
			extentTest.log(Status.FAIL,"Link does not navigates to Twitter");
		}
		
		File Image2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Destination2 = new File("./ScreenshotSocialMedia/Twitter.png");
		FileUtils.copyFile(Image2, Destination2);
		extentTest.addScreenCaptureFromPath("C:/ushe/Eclipse_Ushe/Flight/ScreenshotSocialMedia/Twitter.png", "Twitter Page");
		
		driver.switchTo().window(windowParent1);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='https://www.linkedin.com/company/easemytrip-com']")).click();
		String windowParent2 = driver.getWindowHandle();
		Set <String> windowLinkedIn = driver.getWindowHandles();
		for(String newWindow: windowLinkedIn) {
			driver.switchTo().window(newWindow);
			}
		
		Thread.sleep(3000);
		String TitleLinked = driver.getTitle();
		System.out.println(TitleLinked);
		if (TitleLinked.contains("LinkedIn")) {
			System.out.println("Link correctly navigates to LinkedIn");
			extentTest.log(Status.PASS,"Link correctly navigates to LinkedIn");
		}else
		{
			System.out.println("Link does not navigate to LinkedIn");
			extentTest.log(Status.FAIL,"Link does not navigates to LinkedIn");
		}
		File Image1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Destination1 = new File("./ScreenshotSocialMedia/Linked.png");
		FileUtils.copyFile(Image1, Destination1);
		extentTest.addScreenCaptureFromPath("C:/ushe/Eclipse_Ushe/Flight/ScreenshotSocialMedia/Linked.png", "LinkedIn Page");
		
		
		driver.switchTo().window(windowParent2);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='https://www.instagram.com/easemytrip/']")).click();
		Set <String> windowInsta = driver.getWindowHandles();
		for(String newWindow: windowInsta) {
			driver.switchTo().window(newWindow);
			}
		
		Thread.sleep(3000);
		String TitleInsta = driver.getTitle();
		System.out.println(TitleInsta);
		if (TitleInsta.contains("Insta")) {
			System.out.println("Link correctly navigates to Instagram");
			extentTest.log(Status.PASS,"Link correctly navigates to Instagram");
		}else
		{
			System.out.println("Link does not navigate to Instagram");
			extentTest.log(Status.FAIL,"Link does not navigates to Instagram");
		}
		
		File Image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Destination = new File("./ScreenshotSocialMedia/Insta.png");
		FileUtils.copyFile(Image, Destination);
		extentTest.addScreenCaptureFromPath("C:/ushe/Eclipse_Ushe/Flight/ScreenshotSocialMedia/Insta.png", "Instagram Page");
		
		driver.quit();
}
}

