package nz.govt.mdc.ConsentsOnline;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
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


public class NewApplicationTest extends Base
{
	 public ApplicationStepTwo as2=new ApplicationStepTwo(driver);	  
	
	@BeforeClass
	  public void Launch_Browser() throws IOException 
	  {	
		  	driver=initializeDriver();
			driver.get(prop.getProperty("url"));
		}

	
	 
	@Test(priority=0,enabled=true)
	  public void Login() 
	{		
		  LoginPage lp=new LoginPage(driver); 
		  lp.login("ranatungaran@gmail.com", "123Aa$");		
	}
	
  @Test(priority=1,enabled=true)
  public void new_application() 
  {	  
	  HomePage hp=new HomePage(driver);
	  hp.start_new_application();
	  Assert.assertEquals(driver.getTitle(),"RC Application Form - Consents Online");
  }
  
  @Test(priority=2,enabled=true)
  public void application_step_one() 
  {	 
	  ApplicationStepOne as1=new ApplicationStepOne(driver);
	  as1.select_council("Manawatu District Council");
	  Assert.assertEquals(as1.get_council_address(), "Manawatu District Council, Private Bag 10001, Feilding 4743. Physical address: 135 Manchester Street, Feilding.\n" + 
	  		"Email planning@mdc.govt.nz or phone us on +64 6 323 0000");
	  as1.applicant_reference("A0001");
	  as1.post_code("1345");
	  as1.resource_consent_type("Land use Consent");
	  as1.activity_status("Controlled Activity");
	  as1.proposal_description("Building a new garage");
	  as1.location_address("25 Manchester street, Feilding");
	  as1.step1();
	  Assert.assertEquals(driver.getTitle(),"GetNES - Consents Online");
	  Assert.assertTrue(as2.get_COL_ref().isDisplayed());
	   
  }
  
  @Test(priority=3, enabled=true)
  public void application_step_two() 
  {
	  as2.step2();
	  try
	  {
		Thread.sleep(1000);
	  } 
	  catch (InterruptedException e) 
	  {
		e.printStackTrace();
	  }
	  Assert.assertEquals(driver.getTitle(),"Step3: Certificate of Title And Consent Notices - Consents Online");
	  
  }
  
  @Test(priority=4, enabled=true)
  public void application_step_three() 
  {
	  ApplicationStepThree as3=new ApplicationStepThree(driver);
	  as3.step3();
	  Assert.assertEquals(driver.getTitle(),"Step4: Affected Parties - Consents Online");
	 
  }
  
 @Test(priority=5, enabled=true)
  public void application_step_four() 
 {
	  ApplicationStepFour as4=new ApplicationStepFour(driver);
	  as4.step4();
	  Assert.assertEquals(driver.getTitle(), "Associated Plans & Supporting Documents - Consents Online");
  }
  
  @Test(priority=6, enabled=true)
  public void application_step_five() 
  {
	  ApplicationStepFive as5=new ApplicationStepFive(driver);
	  as5.step5();
	  Assert.assertEquals(driver.getTitle(), "Assessment of Environmental Effects (AEE) - Consents Online");
  }
  
  @Test(priority=7, enabled=true)
  public void application_step_six() 
  {
	  ApplicationStepSix as6=new ApplicationStepSix(driver);
	  as6.environmental_effects();
	  as6.step6();
	  Assert.assertEquals(driver.getTitle(), "AppDeclaration - Consents Online");
	  
  }
  
  @Test(priority=8, enabled=true)
  public void application_step_eight() 
  {
	  ApplicationStepEight as8=new ApplicationStepEight(driver);
	  as8.applicant_name("Ran Ranatunga");
	  as8.date("30");
	  as8.step8();
  }



  
  
  
  
}