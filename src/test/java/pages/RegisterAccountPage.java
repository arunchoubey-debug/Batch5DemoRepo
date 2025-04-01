package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import root.RootPage;
import utils.ElementUtilities;

public class RegisterAccountPage extends RootPage {
	
	
	public RegisterAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='newsletter'][@value='0']")
	private WebElement noNewsLetterOption;
	
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsLetterOption;

	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailfield;
	
	@FindBy(id="input-telephone")
	private WebElement telephonefield;
	
	@FindBy(id="input-password")
	private WebElement passwordfield;
	
	@FindBy(id="input-confirm")
	private WebElement confirmpasswordfield;
	
	@FindBy(name="agree")
	private WebElement privacypolicyclick;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continuebutton;
	
	
	public boolean isPrivacyPolicyFieldSelected() {
		return elementutilities.isElementSelected(privacypolicyclick);
		
	}
	
	
	public void clickNoNewsLetterOption() {
		elementutilities.clickOnElement(noNewsLetterOption);
		
	}
	
	public void enterFirstName(String firstnametext) {
		elementutilities.enterTextIntoElement(firstNameField, firstnametext);
		
	}
	
	public void enterLastName(String lastnametext) {
		elementutilities.enterTextIntoElement(lastNameField, lastnametext);
		
	}
	
	public void enterEmail(String email) {
		elementutilities.enterTextIntoElement(emailfield, email);
		
	}
	
	public void entertelephone(String telephone) {
		elementutilities.enterTextIntoElement(telephonefield, telephone);
		
	}
	
	public void enterpassword(String password) {
		elementutilities.enterTextIntoElement(confirmpasswordfield, password);
		
	}
	
	public void confirmpassword(String confirm) {
		elementutilities.enterTextIntoElement(confirmpasswordfield, confirm);
		
	}
	
	public void privacypolicy() {
		elementutilities.clickOnElement(privacypolicyclick);
		
	}
	
	public AccountSuccessPage  clickcontinuebutton() {
		elementutilities.clickOnElement(continuebutton);
		
		return new AccountSuccessPage(driver);
	}
	
	public void clickYesNewsLetterOption() {
		elementutilities.clickOnElement(yesNewsLetterOption);
		
	}
	
	

}
