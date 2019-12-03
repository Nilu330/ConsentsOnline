package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class HomePage{
	WebDriver driver;
	
	@FindBy(how=How.XPATH,using="//a[contains(.,'Start New Application')]")
	WebElement application;
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void start_new_application()  
	{			
		application.click();
		
	}
		
	
}
