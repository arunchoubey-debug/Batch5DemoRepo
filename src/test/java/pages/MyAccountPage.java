package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import root.RootPage;
import utils.ElementUtilities;

public class MyAccountPage extends RootPage {
     
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public RightColumnOptions getRightColumnOptions() {
		return new RightColumnOptions(driver);
	}
	
	@FindBy(linkText="Subscribe / unsubscribe to newsletter")
	private WebElement subscribeorUnsubscribeToNewsLetterOption;
	
	@FindBy(linkText="Edit your account information")
	private WebElement editAccountInfo;
	
	public boolean didWeNavigateToMyAccountPage() {
		return elementutilities.isElementDisplayed(editAccountInfo);
		
	}
	
	public NewsLetterSubscriptionPage  clickOnSubscribeorUnsubscribeNewsLetterOption() {
		elementutilities.clickOnElement(subscribeorUnsubscribeToNewsLetterOption);
		return new NewsLetterSubscriptionPage(driver);
	}

}
