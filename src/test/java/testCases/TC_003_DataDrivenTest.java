package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.*;
public class TC_003_DataDrivenTest extends BaseClass{
	
	
	//@Test(dataProvider = "LoginData")
	//we have to use this concept when dataprovider is in the same class
	//dataProvider = "LoginData",dataProviderClass = DataProviders.class)
	//we are using upper concept because the Dataprovider is not in the same class even it is in different package and in different class
	//.class is representing the class from where we are getting the dataprovider data
	
	DataProviders dataP = new DataProviders();
	
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class)
	public void LoginDataDrivenTest(String email, String password,String exp) {
		
		
		logger.info("***TC_003_DataDrivenTest***");
		try{
		
		HomePage homePage = new HomePage(driver);
		//driver is coming from the BaseClass
		homePage.clickMyAccount();
		homePage.clickLogin();
		
		//LoginPageClass
		LoginPage loginPage = new LoginPage(driver);
		//driver is coming from the BaseClass
		loginPage.setEmailAddress(email);
		
		loginPage.setPassword(password);
		
		loginPage.clickLoginButton();
		
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		//driver is coming from the BaseClass
		boolean accounttxt=	myAccountPage.isMyAccountPageExists();
		
		if(exp.equals("Valid")) {
			
			if(accounttxt==true) {
				myAccountPage.logout();
				Assert.assertTrue(true);
			}else {
				
				Assert.assertTrue(false);
				
			}
		}
		
		if(exp.equals("Invalid")) {
			
			if(accounttxt==true) {
				myAccountPage.logout();
				Assert.assertTrue(false);
			}else {
				
				Assert.assertTrue(true);
				
			}
		}
		}catch (Exception e) {
			Assert.fail();
		}
		logger.info("***Finished TC_003_DataDrivenTest**");
		
	}

}
