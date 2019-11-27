package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ApplicationStepFour {
	WebDriver driver;
	
	@FindBy(how=How.ID,using=("btnSaveAffectedParties"))
	WebElement save_step4;
	
	public ApplicationStepFour(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void step4() {
		save_step4.click();
	}

}
