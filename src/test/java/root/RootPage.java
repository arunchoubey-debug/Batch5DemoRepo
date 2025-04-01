package root;

import org.openqa.selenium.WebDriver;

import utils.ElementUtilities;

public class RootPage { 
	public WebDriver driver;
	public ElementUtilities elementutilities;
	
	public RootPage(WebDriver driver) {
		this.driver = driver;
		elementutilities = new ElementUtilities(driver);
		
	}

}
