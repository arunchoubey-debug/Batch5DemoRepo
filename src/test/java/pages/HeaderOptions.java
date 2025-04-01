package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import root.RootPage;
import utils.ElementUtilities;

public class HeaderOptions extends RootPage {

	
	public HeaderOptions(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="search")
	private WebElement searchBox;
	
	public void enterSearch(String searchText) {
		elementutilities.enterTextIntoElement(searchBox, searchText);
	}
	
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;
	
	public SearchPage clickSearhButton() {
		elementutilities.clickOnElement(searchButton);
		return new SearchPage(driver);
	}
	
	@FindBy(linkText="Login")
	private WebElement SelectLoginOption;
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	public void clickOnMyAccount() {
		elementutilities.clickOnElement(myAccountDropMenu);
	}
	
	public RegisterAccountPage clickOnRegister() {
		elementutilities.clickOnElement(registerOption);
		return new RegisterAccountPage(driver);
	}
	
	public LoginPage selectloginoption() {
		elementutilities.clickOnElement(SelectLoginOption);
		return new LoginPage(driver);
	}

}
