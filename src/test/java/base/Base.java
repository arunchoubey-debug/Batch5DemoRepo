package base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.AccountSuccessPage;
import pages.HeaderOptions;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.NewsLetterSubscriptionPage;
import pages.RegisterAccountPage;
import pages.RightColumnOptions;
import pages.SearchPage;
import utils.CommonUtils;

public class Base {
	WebDriver driver;
	public Properties prop;
	public HeaderOptions headeroptions;
	public RegisterAccountPage registeraccountpage;
	public AccountSuccessPage accountsuccesspage ;
	public RightColumnOptions rightcolumnoptions;
	public MyAccountPage myaccountpage;
	public NewsLetterSubscriptionPage newslettersubscriptionpage;

	public LoginPage loginpage;
	public SearchPage searchpage;
	
	
	
	public WebDriver openBrowserAndApplicationURL() {
		prop = CommonUtils.loadProperties();
		
		
		 String browser = prop.getProperty("browserName");
		 if(browser.equals("chrome")) {
			 driver = new ChromeDriver();
		 }else if(browser.equals("firefox")) {
			 driver = new FirefoxDriver();
		 }else if(browser.equals("edge")) {
			 driver = new EdgeDriver();
		 }
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(prop.getProperty("applicationURL"));
		return driver;
	}
	
	public void quitBrowser(WebDriver driver) {
		if(driver!=null) {
			driver.quit();
			}
		
	}

}
