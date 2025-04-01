package test;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.AccountSuccessPage;
import pages.HeaderOptions;
import pages.MyAccountPage;
import pages.NewsLetterSubscriptionPage;
import pages.RegisterAccountPage;
import pages.RightColumnOptions;
import utils.CommonUtils;

public class RegisterTest extends Base {
	
	public WebDriver driver;
	
	
	@BeforeMethod
	public void setup()  {
		
		driver = openBrowserAndApplicationURL();
		
	    headeroptions = new HeaderOptions(driver);
		headeroptions.clickOnMyAccount();
	    registeraccountpage = headeroptions.clickOnRegister();
		
	}
	
	@AfterMethod
	public void teardown() {
		quitBrowser(driver);
	}
	
	@Test(priority=1)
	public void verifyRegisteringUsingMandatoryFields() {
		
		registeraccountpage.enterFirstName(prop.getProperty("firstName"));
		registeraccountpage.enterLastName(prop.getProperty("lastName"));
		registeraccountpage.enterEmail(CommonUtils.generateNewEmail());
		registeraccountpage.entertelephone(prop.getProperty("telephone"));
		registeraccountpage.enterpassword(prop.getProperty("validPassword"));
		registeraccountpage.confirmpassword(prop.getProperty("validPassword"));
		registeraccountpage.privacypolicy();
		accountsuccesspage = registeraccountpage.clickcontinuebutton();
	    rightcolumnoptions = accountsuccesspage.getRightColumnOptions();
	    accountsuccesspage = rightcolumnoptions.getAccountSuccessPage();
	     myaccountpage  = accountsuccesspage.clickOnConyinueButton();
		
		Assert.assertTrue(rightcolumnoptions.displaystatusoflogoutoption());
		Assert.assertTrue(myaccountpage.didWeNavigateToMyAccountPage());
		Assert.assertTrue(myaccountpage.didWeNavigateToMyAccountPage());
		
		
	
		
	
		
	}
	@Test(priority=2)
	public void verifyRegisteringAccountUsingAllFields(){
		
		registeraccountpage.enterFirstName(prop.getProperty("firstName"));
		registeraccountpage.enterLastName(prop.getProperty("lastName"));
		registeraccountpage.enterEmail(CommonUtils.generateNewEmail());
		registeraccountpage.entertelephone(prop.getProperty("telephone"));
		registeraccountpage.enterpassword(prop.getProperty("validPassword"));
		registeraccountpage.confirmpassword(prop.getProperty("validPassword"));
		registeraccountpage.clickYesNewsLetterOption();
		registeraccountpage.privacypolicy();
		accountsuccesspage = registeraccountpage.clickcontinuebutton();
		rightcolumnoptions = accountsuccesspage.getRightColumnOptions();
		Assert.assertTrue(rightcolumnoptions.displaystatusoflogoutoption());
		accountsuccesspage = rightcolumnoptions.getAccountSuccessPage();
		Assert.assertTrue(accountsuccesspage.didWeNavigateToAccountSuccessPage());
		myaccountpage = accountsuccesspage.clickOnConyinueButton();
		Assert.assertTrue(myaccountpage.didWeNavigateToMyAccountPage());
		
		
		
		
		
		
	}
	
	
	
	@Test(priority=3)
	public void verifyRegisteringAccountbySelectingYesNewsLetter() {
		
		registeraccountpage.enterFirstName(prop.getProperty("firstName"));
		registeraccountpage.enterLastName(prop.getProperty("lastName"));
		registeraccountpage.enterEmail(CommonUtils.generateNewEmail());
		registeraccountpage.entertelephone(prop.getProperty("telephone"));
		registeraccountpage.enterpassword(prop.getProperty("validPassword"));
		registeraccountpage.confirmpassword(prop.getProperty("validPassword"));
		registeraccountpage.clickYesNewsLetterOption();
		registeraccountpage.privacypolicy();
		accountsuccesspage = registeraccountpage.clickcontinuebutton();
		myaccountpage = accountsuccesspage.clickOnConyinueButton();
	    newslettersubscriptionpage = myaccountpage.clickOnSubscribeorUnsubscribeNewsLetterOption();
		Assert.assertTrue(newslettersubscriptionpage.isYesNewsLetterSelected());
		
		
		
	}
	
	
	@Test(priority=4)
	public void verifyRegisteringAccountbySelectingNoNewsLetter() {
		
		registeraccountpage.enterFirstName(prop.getProperty("firstName"));
		registeraccountpage.enterLastName(prop.getProperty("lastName"));
		registeraccountpage.enterEmail(CommonUtils.generateNewEmail());
		registeraccountpage.entertelephone(prop.getProperty("telephone"));
		registeraccountpage.enterpassword(prop.getProperty("validPassword"));
		registeraccountpage.confirmpassword(prop.getProperty("validPassword"));
		registeraccountpage.clickNoNewsLetterOption();
		registeraccountpage.privacypolicy();
		accountsuccesspage = registeraccountpage.clickcontinuebutton();
		myaccountpage = accountsuccesspage.clickOnConyinueButton();
		newslettersubscriptionpage = myaccountpage.clickOnSubscribeorUnsubscribeNewsLetterOption();
		
		Assert.assertTrue(newslettersubscriptionpage.isNoNewsLetterSelected());
		
		
		
	}
	
	
	@Test(priority=5)
	public void verifyPrivacyPolicySelectionStatusInRegisterAccountPage(){
		
		Assert.assertFalse(registeraccountpage.isPrivacyPolicyFieldSelected());
		
		
		
	}

}
