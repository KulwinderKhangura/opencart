package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	
	//Elements of the Login Page
	@FindBy(xpath = "//input[@id='input-email']") WebElement txtEmailAddress;
	@FindBy(xpath ="//input[@id='input-password']") WebElement txtPassword;
	@FindBy(xpath="//button[normalize-space()='Login']") WebElement btnLogin;
	
	
	//Action methods
	
	public void setEmailAddress(String emailA) {
		txtEmailAddress.sendKeys(emailA);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clickLoginButton() {
		btnLogin.click();
	}
	
	
	
}
