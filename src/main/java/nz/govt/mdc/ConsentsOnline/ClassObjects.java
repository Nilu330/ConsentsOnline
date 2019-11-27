package nz.govt.mdc.ConsentsOnline;

import org.openqa.selenium.WebDriver;

import pageObjects.ApplicationStepEight;
import pageObjects.ApplicationStepFive;
import pageObjects.ApplicationStepFour;
import pageObjects.ApplicationStepOne;
import pageObjects.ApplicationStepSix;
import pageObjects.ApplicationStepThree;
import pageObjects.ApplicationStepTwo;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class ClassObjects {
	WebDriver driver;
	
	LoginPage l=new LoginPage(driver);
	HomePage hp=new HomePage(driver);
	ApplicationStepOne as1=new ApplicationStepOne(driver);
	ApplicationStepTwo as2=new ApplicationStepTwo(driver);
	ApplicationStepThree as3=new ApplicationStepThree(driver);
	ApplicationStepFour as4=new ApplicationStepFour(driver);
	ApplicationStepFive as5=new ApplicationStepFive(driver);
	ApplicationStepSix as6=new ApplicationStepSix(driver);
	ApplicationStepEight as8=new ApplicationStepEight(driver);

}
