package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import root.RootPage;
import utils.ElementUtilities;

public class AccountSuccessPage extends RootPage {
	
	
	public AccountSuccessPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[text()='Success']")
	private WebElement accountSuccessPageBreadCrumb;
	
	@FindBy(xpath="//div[@class='pull-right']//a[text()='Continue']")
	private WebElement continueButton;
	
	public boolean  didWeNavigateToAccountSuccessPage() {
		return elementutilities.isElementDisplayed(accountSuccessPageBreadCrumb);
	}
	
	public MyAccountPage   clickOnConyinueButton() {
		elementutilities.clickOnElement(continueButton);;;
		return new MyAccountPage(driver);
	}
	
	public RightColumnOptions getRightColumnOptions() {
		return new RightColumnOptions(driver);
	}

}
