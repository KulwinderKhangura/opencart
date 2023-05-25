package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	//Doing the Login Test
	
	@Test(groups = {"Sanity","Master"})
	public void LoginTest() {
		try {
		logger.info("***Starting TC_00_2_LoginTest ");
		//HomePageClass
		HomePage homePage = new HomePage(driver);
		//driver is coming from the BaseClass
		homePage.clickMyAccount();
		logger.info("Clicked on My Account link");
		homePage.clickLogin();
		logger.info("Clicked on Login link");
		
		//LoginPageClass
		LoginPage loginPage = new LoginPage(driver);
		//driver is coming from the BaseClass
		loginPage.setEmailAddress(rb.getString("email"));
		logger.info("Send Email address");
		loginPage.setPassword(rb.getString("password"));
		logger.info("Send Password");
		loginPage.clickLoginButton();
		logger.info("Clicked on Login button");
		
		//MyAccountPageClass
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		//driver is coming from the BaseClass
		boolean accounttxt=	myAccountPage.isMyAccountPageExists();
		logger.info("Verifying expected message");
		Assert.assertEquals(accounttxt, true,"Test failed - - Not getting Expected message");
		}catch (Exception e) {
			Assert.fail();
			logger.info("Test Failed");
		}
		
		
		logger.info("Finished TC_002_LoginTest");
		
		
		
	}

}
