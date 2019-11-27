package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ApplicationStepEight {
	WebDriver driver;
	
	@FindBy(how=How.ID,using=("Name"))
	WebElement name;
	@FindBy(how=How.ID,using=("SignatureDate"))
	WebElement calender;
	@FindBy(how=How.CSS,using=(".day"))
	List<WebElement> day;
	@FindBy(how=How.ID,using=("SubmitToCouncil"))
	WebElement submit;



public ApplicationStepEight(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}
public void applicant_name(String n) {
	name.sendKeys(n);
}

public void date(String dd) {
	calender.click();
	
	int count=day.size();
	for(int i=0;i<count;i++) {
		String d=day.get(i).getText();
		if(d.equals(dd)) {
			day.get(i).click();
	
		}		
	}
	
	
}

public void step8() {
	submit.click();
}

}


