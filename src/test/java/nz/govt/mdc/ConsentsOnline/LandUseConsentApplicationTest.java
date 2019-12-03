package nz.govt.mdc.ConsentsOnline;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageObjects.ApplicationStepEight;
import pageObjects.ApplicationStepFive;
import pageObjects.ApplicationStepFour;
import pageObjects.ApplicationStepOne;
import pageObjects.ApplicationStepSix;
import pageObjects.ApplicationStepThree;
import pageObjects.ApplicationStepTwo;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.PageHeader;
import nz.govt.mdc.ConsentsOnline.Base;



public class LandUseConsentApplicationTest extends Base
{
	 public static Logger log =LogManager.getLogger(Base.class.getName());
	 			
	
	@BeforeTest
	//TC0001|Launch browser and navigate to the login page
	  public void Launch_Browser() throws IOException 
	  {	
		  	driver=initializeDriver();
			driver.get(prop.getProperty("url"));
			log.info("Navigated to Login page");
		}

	 
	@Test(priority=0,enabled=true)
	//TC0003|Login to the application
	  public void Login() 
	{		
		LoginPage lp=new LoginPage(driver);
		  lp.login("ranatungaran@gmail.com", "123Aa$");	
		  log.info("Login successful");
		  Assert.assertEquals(driver.getTitle(),"Dashboard - Consents Online");
		  	
	}
	
  @Test(priority=1,enabled=true)
  //TC0033|Start new application
  public void new_application() throws InterruptedException 
  {		    
	  HomePage hp=new HomePage(driver);	
	
	  Thread.sleep(2000);
	  hp.start_new_application();
	  log.info("Application displayed");
	  Assert.assertEquals(driver.getTitle(),"RC Application Form - Consents Online");
  }
  
  @Test(priority=2,enabled=true)
  //TC0034|Validate Step1 of the application with Land use Consent selection and mandatory fields
  public void application_step_one() 
  {	 
	  ApplicationStepOne as1=new ApplicationStepOne(driver);
	  
	  as1.select_council("Manawatu District Council");
	  Assert.assertEquals(as1.get_council_address(), "Manawatu District Council, Private Bag 10001, Feilding 4743. Physical address: 135 Manchester Street, Feilding.\n" + 
	  		"Email planning@mdc.govt.nz or phone us on +64 6 323 0000");
	  log.info("Council address, email and phone number displayed");
	  as1.applicant_reference("A0001");
	  as1.post_code("1345");
	  as1.resource_consent_type("Land use Consent");
	  log.info("Land use Consent selected");
	  as1.activity_status("Controlled Activity");
	  as1.proposal_description("Building a new garage");
	  as1.location_address("25 Manchester street, Feilding");
	  as1.step1();
	  log.info("Step 1 saved");
	  Assert.assertEquals(driver.getTitle(),"GetNES - Consents Online");
	  log.info("Step 2 displayed");	 
	  
  }
  
 @Test(priority=3, enabled=true)
 //TC0035|TC0036|Validate COL reference generation and Step 2 of the application
  public void application_step_two() throws InterruptedException  
  {
	 ApplicationStepTwo as2=new ApplicationStepTwo(driver);	 
	 Assert.assertTrue(as2.get_COL_ref().isDisplayed());
	  log.info("COL reference automatically allocated");
	  as2.step2();
	  log.info("Step 2 saved");
	 Thread.sleep(2000);
	  Assert.assertEquals(driver.getTitle(),"Step3: Certificate of Title And Consent Notices - Consents Online");
	  log.info("Step 3 displayed");	
	  
  }
  
  @Test(priority=4, enabled=true)
  //TC0037|Validate Step 3 of the application without filling mandatory fields if there is any.
  public void application_step_three() throws InterruptedException 
  {
	  ApplicationStepThree as3=new ApplicationStepThree(driver);
	  Thread.sleep(2000);
	  as3.step3();
	  log.info("Step 3 saved");
	  Assert.assertEquals(driver.getTitle(),"Step4: Affected Parties - Consents Online");
	  log.info("Step 4 displayed");	
	 
  }
  
 @Test(priority=5, enabled=true)
 //TC0038|Validate Step 4 of the application without filling mandatory fields if there is any.
  public void application_step_four() 
 {
	  ApplicationStepFour as4=new ApplicationStepFour(driver);
	  as4.step4();
	  log.info("Step 4 saved");
	  Assert.assertEquals(driver.getTitle(), "Associated Plans & Supporting Documents - Consents Online");
	  log.info("Step 5 displayed");	
  }
  
  @Test(priority=6, enabled=true)
  //TC0039|Validate Step 5 of the application without filling mandatory fields if there is any.
  public void application_step_five() 
  {
	  ApplicationStepFive as5=new ApplicationStepFive(driver);
	  as5.step5();
	  log.info("Step 5 saved");
	  Assert.assertEquals(driver.getTitle(), "Assessment of Environmental Effects (AEE) - Consents Online");
	  log.info("Step 6 displayed");	
  }
  
  @Test(priority=7, enabled=true)
  //TC0040|Validate Step 6 of the application without filling mandatory fields if there is any.
  public void application_step_six() 
  {
	  ApplicationStepSix as6=new ApplicationStepSix(driver);
	  as6.step6();
	  log.info("Step 6 saved");
	  Assert.assertEquals(driver.getTitle(), "AppDeclaration - Consents Online");
	  log.info("Step 8 displayed");	
	  
  }
  
  @Test(priority=8, enabled=true)
//TC0041|Validate Step 3 of the application with mandatory fields.
  public void application_step_eight() throws InterruptedException 
  {
	  ApplicationStepEight as8=new ApplicationStepEight(driver);
	  as8.applicant_name("Ran Ranatunga");
	  as8.get_date("10 January 2020");
	  Thread.sleep(2000);
	  as8.submit_application();
	  log.info("Application submitted");
	  
  }
  
  @Test(priority=9, enabled=true)
  //TC0042|Validate Logout from the application.
  public void logout()  
  {
	  PageHeader ph=new PageHeader(driver);
	  ph.logout();
	  log.info("Logged out");
  }
  
  @AfterTest
  public void teardown()
  {
	  driver.quit();
	  driver=null;
  }
  
  
  
}