package nz.govt.mdc.ConsentsOnline;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.ApplicationStepEight;
import pageObjects.ApplicationStepFive;
import pageObjects.ApplicationStepFour;
import pageObjects.ApplicationStepOne;
import pageObjects.ApplicationStepSix;
import pageObjects.ApplicationStepThree;
import pageObjects.ApplicationStepTwo;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class Base 
{
	
public static WebDriver driver;
public Properties prop;


	public WebDriver initializeDriver() throws IOException 
	{
		prop=new Properties(); 
		FileInputStream file=new FileInputStream("C:\\Users\\Nilu\\eclipse-workspace\\ConsentsOnline\\src\\main\\resources\\browser.properties");
		prop.load(file);
		
		String browserName=prop.getProperty("browser");
				
		if(browserName.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
			
		}
		
		else if(browserName.equals("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();						
		}
		
		else if (browserName.equals("IE"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
				
	}
	
	


	public void get_screenshot(String t_name) throws IOException
	{
		File ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ss, new File("C:\\Users\\Nilu\\eclipse-workspace\\ConsentsOnline\\test_failed_screenshots\\"+t_name+"screenshot.png"));
		
	}
	

}
