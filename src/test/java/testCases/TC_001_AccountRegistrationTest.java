package testCases;



import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	
	
	
	
	@Test(groups = {"Regression","Master"})
	void test_account_Registration() throws InterruptedException {
		logger.debug("Application logs.....");
		logger.info("***Starting TC_001_AccountRegistrationTest ");
		//this message will be logged into the log file
		try {
			//System.out.println(rb.getString("email"));
		//HomePage class from other package 
		HomePage homepage = new HomePage(driver);
		homepage.clickMyAccount();
		logger.info("Clicked on My Account link");
		homepage.clickRegister();
		logger.info("Clicked on Register link");
		//AccountRegistrationPage form other Package
		AccountRegistrationPage accountRegP = new AccountRegistrationPage(driver);
		logger.info("Providing the customer data");
		accountRegP.setFirstname(randomString().toUpperCase());
		accountRegP.setLastname(randomString().toUpperCase());
		accountRegP.setEmail(randomString()+"@gmail.com");
		accountRegP.setPassword(randomAlphaNumeric());
		Thread.sleep(5000);
		accountRegP.setCheckPolicy();
		Thread.sleep(5000);
		accountRegP.clickContinue();
		logger.info("Clicked on Continue Button");
		Thread.sleep(5000);
		String confmsg=accountRegP.getConfirmationMsg();
		//Thread.sleep(5000);
		logger.info("Verifying expected message");
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!","Test failed - - Not getting Expected message");
		//Thread.sleep(5000);
		}catch (Exception e) {
			logger.error("Test Failed");
			Assert.fail();
		
			
		}
		
		logger.info("Finished TC_001_AccountRegistrationTest");
	}
	
	
	
	
}
