package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PageHeader 
{
	WebDriver driver;
	
	@FindBy (how=How.XPATH,using="//span[@class=\"username username-hide-on-mobile\"]")
	WebElement user;
	@FindBy(how=How.ID,using="logoutForm")
	WebElement logout_form;
	
	public PageHeader(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	public void logout()
	{
		user.click();
		logout_form.click();
	}
	

}
