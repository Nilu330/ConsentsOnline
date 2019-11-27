package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ApplicationStepOne {
	WebDriver driver;
	
	@FindBy(how=How.ID,using=("councilsDetails"))
	WebElement council;
	@FindBy(how=How.ID,using=("ApplicationName"))
	WebElement reference;
	@FindBy(how=How.ID,using=("PostCode"))
	WebElement postcode;
	@FindBy(how=How.ID,using=("TypeofResourceConsents_ID"))
	WebElement consent_type;
	@FindBy(how=How.ID,using=("ActivityStatus_ID"))
	WebElement a_status;
	@FindBy(how=How.ID,using=("ProposalDescriptions_DescriptionoftheProposal"))
	WebElement p_description;
	@FindBy(how=How.ID,using=("ProposedLocations_AddressofProposedSite"))
	WebElement location;
	@FindBy(how=How.ID,using=("btnSubmit"))
	WebElement save_step1;
	@FindBy(how=How.XPATH,using=("//span[@class=\"councilsAddress\"]"))
	WebElement council_address ;
	
	
	
	
	public ApplicationStepOne(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void select_council(String C){
		Select dropCouncil=new Select(council);
		dropCouncil.selectByVisibleText(C);
	}
		
	public void applicant_reference(String ref) {
		reference.sendKeys(ref);
	}
	
	public void post_code(String pc) {
		postcode.sendKeys(pc);		
		
	}
	
	public void resource_consent_type(String ct) {
		Select dropConsent=new Select(consent_type);
		dropConsent.selectByVisibleText(ct);
	}
	
	public void activity_status(String as) {
		Select dropActivity=new Select(a_status);
		dropActivity.selectByVisibleText(as);
	}
	
	public void proposal_description(String pd) {
		p_description.sendKeys(pd);
	}
	
	public void location_address(String A) {
		location.sendKeys(A);
	}
	
	public void step1() {
		save_step1.click();
	}
	
		
	public String get_council_address()
	{
		String c_address=council_address.getText();
		return c_address;
	}
	

}
