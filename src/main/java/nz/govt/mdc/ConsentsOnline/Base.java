package nz.govt.mdc.ConsentsOnline;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

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

public class Base {
	
public WebDriver driver;
public Properties prop=new Properties(); 


	public WebDriver initializeDriver() throws IOException {
		
		FileInputStream file=new FileInputStream("C:\\Users\\Nilu\\eclipse-workspace\\ConsentsOnline\\src\\main\\resources\\browser.properties");
		prop.load(file);
		
		String browserName=prop.getProperty("browser");
				
		if(browserName.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-extensions");
			// options.addArguments("--incognito");
			// options.addArguments("disable-images");
			options.addArguments("--blink-settings=imagesEnabled=false");
			// options.addExtensions("Block-image_v1.0.crx");
			options.setCapability("pageLoadStrategy", "none");
			driver=new ChromeDriver(options);
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
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
		
		
	}

}
