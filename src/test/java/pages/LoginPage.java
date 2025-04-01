package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import root.RootPage;
import utils.ElementUtilities;

public class LoginPage extends RootPage {
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement LoginButton;
	
	public MyAccountPage selectLoginButton() {
		elementutilities.clickOnElement(LoginButton);
		return new MyAccountPage(driver);
	}
	
	
	@FindBy(id="input-password")
	private WebElement ValidPassword;
	
	public void enterPassword(String passwordText) {
		elementutilities.enterTextIntoElement(ValidPassword, passwordText);
	}
	
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	public void enterEmail(String emailText) {
		elementutilities.enterTextIntoElement(emailField, emailText);
	}
	
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement warningMessage;
	
	public String  getWarningMessage() {
		return elementutilities.getTextFromElement(warningMessage);
	}

}
