package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(how=How.ID,using="Email")
	WebElement email;
	@FindBy(how=How.ID,using="Password")
	WebElement password;
	@FindBy(how=How.XPATH,using="//button[text()=\"Sign In\"]")
	WebElement sign_in; 
	@FindBy(how=How.XPATH,using="//span[@id=\"Email-error\"]")
	WebElement email_error;
	@FindBy(how=How.XPATH,using="//span[@id=\"Password-error\"]")
	WebElement password_error;
	@FindBy(how=How.XPATH,using="//div[@class=\"validation-summary-errors text-danger\"]")
	WebElement inactivated_ac_error;
	@FindBy(how=How.XPATH,using="//div[@class=\"validation-summary-errors text-danger\"]")
	WebElement email_password_error;
	
	

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void login(String em,String pw) {
		email.sendKeys(em);
		password.sendKeys(pw);
		sign_in.click();	
		
	}
	
	public String validate_email_error()
	{
		String e_error=email_error.getText();
		return e_error;		
	}
	
	public String validate_password_error()
	{
		String p_error=password_error.getText();
		return p_error;				
	}
	
	public String validate_inactivated_ac_error()
	{
		String ac_error=inactivated_ac_error.getText();
		return ac_error;
	}
	
	public String validate_email_password_error()
	{
		String ep_error=email_password_error.getText();
		return ep_error;				
	}


}
