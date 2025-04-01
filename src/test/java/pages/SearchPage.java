package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import root.RootPage;
import utils.ElementUtilities;

public class SearchPage extends RootPage {
	
	
	public SearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText="HP LP3065")
	private WebElement hpPage;
	
	public boolean isHPPageDisplayed() {
		return elementutilities.isElementDisplayed(hpPage);
		
	}
	
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	private WebElement noProductMessage;
	
	public String noProductMessageText() {
		return elementutilities.getTextFromElement(noProductMessage);
		
	}

}
