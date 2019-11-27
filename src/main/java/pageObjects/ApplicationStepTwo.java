package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ApplicationStepTwo 
{
	WebDriver driver;
	
	@FindBy(how=How.ID,using=("btnSubmit"))
	WebElement save_step2;	
	@FindBy(how=How.XPATH,using=("//table[@class=\"table table-bordered\"]/tbody/tr[1]/td[4]"))
	WebElement COL_ref;
	
	public ApplicationStepTwo(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void step2() {
		save_step2.click();
	}
	
	public WebElement get_COL_ref()
	{
		return COL_ref;		
	}
	

}
