package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage{
	WebDriver driver;
	
	@FindBy(how=How.XPATH,using="//a[@href=\"/ApplicationMains/PreApplication\"]")
	WebElement application;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void start_new_application()  
	{	
		/*
		try
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException e)
		{		
			e.printStackTrace();
		}
		*/
		
		this.driver.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);
		
		application.click();		
		
	}
	
	public String get_title()
	{
		String title=driver.getTitle();
		return title;
	}
	

	
	
}
