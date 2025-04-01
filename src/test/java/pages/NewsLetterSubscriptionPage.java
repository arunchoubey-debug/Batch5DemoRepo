package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import root.RootPage;
import utils.ElementUtilities;

public class NewsLetterSubscriptionPage extends RootPage {
	
	
	public NewsLetterSubscriptionPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@name='newsletter'][@value='0']")
	private WebElement noNewsLetterOption;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsLetterOption;
	
	public boolean isYesNewsLetterSelected() {
		return elementutilities.isElementSelected(yesNewsLetterOption);
		
	}
	
	public boolean isNoNewsLetterSelected() {
		return elementutilities.isElementSelected(noNewsLetterOption);
		
	}

}
