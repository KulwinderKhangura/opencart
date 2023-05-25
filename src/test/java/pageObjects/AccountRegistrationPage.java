package pageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	

	//Elements
	@FindBy (name = "firstname") WebElement txtFirstname;
	@FindBy (name = "lastname") WebElement txtLastname;
	@FindBy (name = "email") WebElement txtEmail;
//	@FindBy (name = "telephone") WebElement txtTelephone;
	@FindBy (name = "password") WebElement txtPassword;
//	@FindBy (name = "confirm") WebElement txtConfirmPassword;
	@FindBy (xpath = "//input[@name='agree']") WebElement chkdPolicy;
	@FindBy (xpath = "//button[normalize-space()='Continue']") WebElement btnContinue;
	@FindBy (xpath = "//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirmation;
	
	//Actions
	public void setFirstname(String fname) {
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastname(String Lname) {
		txtLastname.sendKeys(Lname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
//	public void setTelephone(String telephoneNumber) {
//		txtTelephone.sendKeys(telephoneNumber);
//	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
//	public void setzconfirmPassword(String confirmPwd) {
//		txtConfirmPassword.sendKeys(confirmPwd);
//	}
//	
	public void setCheckPolicy() {
		chkdPolicy.click();
	}
	
	public void clickContinue() {
		//sol1
		btnContinue.click();
		
		//sol2
		//btnContinue.submit();
		
		//sol3
		//Actions act = new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();
		
		//sol4
		//JavascriptExecutor js =(JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();", btnContinue);
		
		//sol5
		//btnContinue.sendKeys(Keys.RETURN);
		
		
		//sol6
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(50));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
	
}
