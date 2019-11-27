package nz.govt.mdc.ConsentsOnline;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;


public class LoginTest extends Base{
		
	
	@BeforeMethod
	  public void Launch_Browser() throws IOException 
	  {	
		  	driver=initializeDriver();
		  	driver.get(prop.getProperty("url"));
		}
	  
	
	   @Test(dataProvider="getData")
	   public void ConsentsOnline_Login(String email, String password)
	   {
		  LoginPage lp=new LoginPage(driver);
		  //get email and password to login
		  lp.login(email, password); 
		  
		 		  
		  if(email.equals("ranatungaran@gmail.com") && password.equals("123Aa$"))
		  {
			  Assert.assertEquals(driver.getTitle(), "Dashboard - Consents Online");
		  }
		  
		  else if(email.equals("") && password.equals(""))
		  {
			  Assert.assertEquals(lp.validate_email_error(), "The Email field is required.");
			  Assert.assertEquals(lp.validate_password_error(), "The Password field is required."); 
		  }
		  
		  else if(email.equals("nilupuleer911@gmail.com"))
		  {
			  Assert.assertEquals(lp.validate_inactivated_ac_error(),"Your account needs to be activated to login to your account. Please activate it by clicking on the link in the registration email we sent you during registration.");
		  }
		  
		  else
		  {
			  Assert.assertEquals(lp.validate_email_password_error(), "Invalid email or password, Please try again.");   
		  }
		  
		  driver.quit();
	   }
	   
	  @DataProvider
	  public Object[][] getData()
	  {
		   Object[][] data=new Object[6][2];
		   //valid email and valid password
		   data[0][0]="ranatungaran@gmail.com";
		   data[0][1]="123Aa$";
		   //invalid email and valid password
		   data[1][0]="ranatunga@gmail.com";
		   data[1][1]="123456Aa?";
		   // valid email and invalid password
		   data[2][0]="ranatungaran@gmail.com";
		   data[2][1]= "123456789";
		   //invalid email and password
		   data[3][0]="ranatunga@gmail.com";
		   data[3][1]= "123456789";
		   //blank email and password
		   data[4][0]="";
		   data[4][1]= "";
		   //not activated account
		   data[5][0]="nilupuleer911@gmail.com";
		   data[5][1]= "123Aa$";
		   
		   		   
		   return data;	   
		   
				   
	  }
	  
				
  }
