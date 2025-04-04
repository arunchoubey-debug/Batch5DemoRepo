package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import root.RootPage;
import utils.ElementUtilities;

public class RightColumnOptions extends RootPage {

	
	public RightColumnOptions(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[@class='list-group-item'][text()='Logout']")
	private WebElement logoutoption;
	
	public boolean  displaystatusoflogoutoption() {
		return elementutilities.isElementDisplayed(logoutoption);
		
	}
	
	public AccountSuccessPage  getAccountSuccessPage() {
		return new AccountSuccessPage(driver);
	}
	
	public MyAccountPage  getMyAccountPage() {
		return new MyAccountPage(driver);
	}

}
