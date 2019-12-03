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
	@FindBy(how=How.XPATH,using=("(//th[contains(@colspan,'5')])[1]"))
	WebElement month_year;	
	@FindBy(how=How.XPATH,using=("//th[contains(@class,'next')])[1]"))
	WebElement month_next;	
	@FindBy(how=How.CSS,using=(".day"))
	List<WebElement> day_array;
	@FindBy(how=How.XPATH,using=("//button[@id=\"SubmitToCouncil\"]"))
	WebElement submit;
	
	


public ApplicationStepEight(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}
public void applicant_name(String n) {
	name.sendKeys(n);
}

public void get_date(String date)
{
	calender.click();
	
	String dateParts[] = date.split(" ");
	String day  = dateParts[0];
	/*String month  = dateParts[1];
	  String year = dateParts[2];
	
	while(!month_year.getText().contains(month+" "+year))
	{
		month_next.click();
	}*/

	
	
	int count=day_array.size();
	
	for(int i=0;i<count;i++) {
		String d=day_array.get(i).getText();
		if(d.equals(day)) {
			day_array.get(i).click();
	
		}		
	}
	
	
}

public void submit_application() {
	submit.click();
}

}


