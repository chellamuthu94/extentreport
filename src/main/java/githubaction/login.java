package githubaction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class login {
	static WebDriver driver;
	ExtentReports extentreport;  
	ExtentHtmlReporter  htmlreport;
	ExtentTest testcase;
	@Test
	 public void test() {
		extentreport = new ExtentReports();
		htmlreport = new ExtentHtmlReporter("extentreport.html");
		extentreport.attachReporter(htmlreport);
		driver =  new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
		
	  
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");  
		driver.findElement(By.xpath("//*[@type='submit']")).click() ;
  System.out.println("sucess");
  testcase = extentreport.createTest("login");
  extentreport.flush();
	}
	
}
 