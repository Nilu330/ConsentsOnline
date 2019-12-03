package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ApplicationStepSeven 
{
WebDriver driver;
	
	@FindBy(how=How.ID,using=("btnSaveAffectedParties"))
	WebElement save_step7;
	
	public ApplicationStepSeven(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void step7() {
		save_step7.click();
	}

}
