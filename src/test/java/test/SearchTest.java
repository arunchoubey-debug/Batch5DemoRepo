package test;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.HeaderOptions;
import pages.SearchPage;
import utils.CommonUtils;

public class SearchTest extends Base {
	public WebDriver driver;
	
	
	@BeforeMethod
	public void setup() {
		
		driver = openBrowserAndApplicationURL();
		headeroptions = new HeaderOptions(driver);
	}

	@AfterMethod
	public void teardown() {
		quitBrowser(driver);
	}
	
	@Test(priority=1)
	public void verifySearchingWithExistingProduct() {
		
		headeroptions.enterSearch(prop.getProperty("existingProduct"));
		 searchpage = headeroptions.clickSearhButton();
		Assert.assertTrue(searchpage.isHPPageDisplayed());
	}
	
	@Test(priority=2)
	public void verifySearchingWithNonExistingProductName() {
		headeroptions.enterSearch(prop.getProperty("nonExistingProduct"));
		searchpage = headeroptions.clickSearhButton();
		String message = "There is no product that matches the search criteria.";
		Assert.assertEquals(searchpage.noProductMessageText(),message );
		
		
	}
	
	@Test(priority=3)
	public void verifySearchingWithoutProvidingProductName() {
		
		searchpage = headeroptions.clickSearhButton();
		
		String message = "There is no product that matches the search criteria.";
		Assert.assertEquals(searchpage.noProductMessageText(),message );
		
	}

}
