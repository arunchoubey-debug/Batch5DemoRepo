package test;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pages.HeaderOptions;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RightColumnOptions;
import utils.CommonUtils;
import utils.MyXLSReader;

public class LoginTest extends Base {
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver = openBrowserAndApplicationURL();
		
		
		 headeroptions = new HeaderOptions(driver);
		headeroptions.clickOnMyAccount();
		 loginpage = headeroptions.selectloginoption();
		
	}
	
	@AfterMethod
	public void teardown() {
		quitBrowser(driver);
	}
	
	@Test(priority=1, dataProvider="validCredentialsSupplier")
	public void verifyLoggingIntoApplicationUsingValidCredentials(HashMap<String, String> map) {
		
		loginpage.enterEmail(map.get("EMAIL"));
		loginpage.enterPassword(map.get("PASSWORD"));
		 myaccountpage = loginpage.selectLoginButton();
		 rightcolumnoptions = myaccountpage.getRightColumnOptions();
		Assert.assertTrue(rightcolumnoptions.displaystatusoflogoutoption());
		myaccountpage = rightcolumnoptions.getMyAccountPage();
		Assert.assertTrue(myaccountpage.didWeNavigateToMyAccountPage());
	}
	
	@DataProvider(name="validCredentialsSupplier")
	public Object[][] testDataForLogin() {
		MyXLSReader myxlsreader = new MyXLSReader("\\src\\test\\resources\\TutoriasNinjaData.xlsx");
		Object[][] data = CommonUtils.getTestData(myxlsreader, "loginWithValidCredentials", "login");
		return data;
	}
	
	@Test(priority=2)
	public void verifyLoggingIntoApplicationUsingInvalidCredentials() {
		
		loginpage.enterEmail(prop.getProperty("existingEmail"));
		loginpage.enterPassword(prop.getProperty("validPassword"));
		 myaccountpage = loginpage.selectLoginButton();
		
		
		
		
		String expectedWarning = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(loginpage.getWarningMessage(),expectedWarning );
		
		
	}
	

}
