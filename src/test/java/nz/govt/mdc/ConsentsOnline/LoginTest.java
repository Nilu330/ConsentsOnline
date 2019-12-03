package nz.govt.mdc.ConsentsOnline;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import nz.govt.mdc.ConsentsOnline.Base;




public class LoginTest extends Base
{
	 public static Logger log =LogManager.getLogger(Base.class.getName());	
	
	@BeforeMethod
	//TC0001|Launch browser and navigate to the login page
	  public void Launch_Browser() throws IOException 
	  {	
		  	driver=initializeDriver();
		  	driver.get(prop.getProperty("url"));
		  	log.info("Navigated to Login page");
		}
	  
	
	   @Test(dataProvider="getData")
	   public void ConsentsOnline_Login(String email, String password)
	   {
		  LoginPage lp=new LoginPage(driver);
		  //get from the array email and password to login
		  lp.login(email, password); 
		  
		 		  
		  if(email.equals("ranatungaran@gmail.com") && password.equals("123Aa$"))
		  {
			  Assert.assertEquals(driver.getTitle(), "Dashboard - Consents Online");
			  log.info("Login successful");
		  }
		  
		  else if(email.equals("") && password.equals(""))
		  {
			  Assert.assertEquals(lp.validate_email_error(), "The Email field is required.");
			  Assert.assertEquals(lp.validate_password_error(), "The Password field is required."); 
			  log.info("Unable to log with blank email and password");
		  }
		  
		  else if(email.equals("nilupuleer911@gmail.com"))
		  {
			  Assert.assertEquals(lp.validate_inactivated_ac_error(),"Your account needs to be activated to login to your account. Please activate it by clicking on the link in the registration email we sent you during registration.");
			  log.info("Unable to log with not activated email");
		  }
		  
		  else
		  {
			  Assert.assertEquals(lp.validate_email_password_error(), "Invalid email or password, Please try again.");   
			  log.info("Unable to log with invalid login credentials");
		  }
		  
		
	   }
	   
	  @DataProvider
	  public Object[][] getData()
	  {
		   Object[][] data=new Object[6][2];
		   //TC0003|valid email and valid password
		   data[0][0]="ranatungaran@gmail.com";
		   data[0][1]="123Aa$";
		   //TC0004|invalid email and valid password
		   data[1][0]="ranatunga@gmail.com";
		   data[1][1]="123456Aa?";
		   //TC0005|valid email and invalid password
		   data[2][0]="ranatungaran@gmail.com";
		   data[2][1]= "123456789";
		   //TC0006|invalid email and password
		   data[3][0]="ranatunga@gmail.com";
		   data[3][1]= "123456789";
		   //TC0007|blank email and password
		   data[4][0]="";
		   data[4][1]= "";
		   //TC0008|not activated account
		   data[5][0]="nilupuleer911@gmail.com";
		   data[5][1]= "123Aa$";
		   
		   		   
		   return data;	   
		   
				   
	  }
	  
	  
	  @AfterMethod
	  public void teardown()
	  {
		 driver.quit();
		 driver=null;
	  }

	  
				
  }
