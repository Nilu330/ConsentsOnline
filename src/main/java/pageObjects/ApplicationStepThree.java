package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ApplicationStepThree {
	WebDriver driver;
	
	@FindBy(how=How.ID,using=("btnSubmit"))
	WebElement save_step3;
	
	public ApplicationStepThree(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void step3() {
		save_step3.click();
	}

}
