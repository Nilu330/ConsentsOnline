package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ApplicationStepSix {
	WebDriver driver;
	
	
	@FindBy(how=How.XPATH,using=("//input[@id=\"IsEnvironmentalEffectsHasBeenIncluded\"]"))
	WebElement environmental_effects_assessment;
	@FindBy(how=How.ID,using=("btnSubmit"))
	WebElement save_step6;
	
	public ApplicationStepSix(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void environmental_effects() {
		environmental_effects_assessment.click();
	}
	
	public void step6() {
		save_step6.click();
	}
}
