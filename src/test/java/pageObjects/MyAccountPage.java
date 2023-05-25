package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	
	//Elements on the myAccount page for verification
	
	@FindBy(xpath ="//h2[normalize-space()='My Account']") WebElement txtmyAccount;
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']") WebElement lnkLogout;
	
	
	//Action
	
	public boolean isMyAccountPageExists() {
		try {
		return	(txtmyAccount.isDisplayed());
		} catch (Exception e) {
			return false;
		}
		
	}
	
	
	public void logout() {
		lnkLogout.click();
	}
	
}
