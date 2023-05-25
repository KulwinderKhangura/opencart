package testBase;

import java.io.File;
import java.io.ObjectInputFilter.Config;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {
	
	public static WebDriver driver;
	//if we donot use the static keyword it will create the driver instance for baseclass and baseclass object in ExtentReportManager class
	//one driver is already here in the base class and one more will created in the ExtentReportManager class to avoid that we are using the static keybord 
	//so in ExtentReportManager baseclass object can access the driver from baseclass
	
	
	//We have to create a Log file for project that store all the information about the tests
	//log file should be stored in the resources folder
	//log file has 3 main parts properties, apenders, loggers
	//we have to initialize the log file in the baseclass
	
	
	public Logger logger; //for logging
	
	// this class make a connection with the file of config.properties 
	//some hard code values we can keep in that file and we can use those value in anywhere in the project
	//we have declared a variable here outside the methods so we can access everywhere in the class
	public ResourceBundle rb;
	
	
	@BeforeClass(groups = {"Sanity","Master","Regression"})
	@Parameters("browser")
	public void setup(String br) throws InterruptedException {
		
		
		rb=ResourceBundle.getBundle("config"); //Load config.properties file with the help of resourceBundle class
		
		
		logger = LogManager.getLogger(this.getClass());// this is representing the current running class
		//this.getClass() will capture the current running class
		//this statement gonna make a connection with log file and generate a  file for current class
		
		//ChromeOptions options = new ChromeOptions();
		
		//options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
		//this will disable the automation message that comes on browser while run time
		//driver = new ChromeDriver(options);
		
		if(br.equals("chrome")){
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		}else if(br.equals("edge")) {
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			
		}else {
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		}
		
		driver.manage().deleteAllCookies();
		//here we have to add the options in the browser
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appURL1")); //here we are using the config.properties file variable with the help of rb.getString Method
		
		//Thread.sleep(5000);
		driver.manage().window().maximize();
		
	}
	
	public String captureScreen(String tname) {
		//we can call this method when failure will happen
		//tname gonna be which method is failing
		
		
		//Breakdown of simpleformat method
		
		//SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
		//here we have created the object of the SimpleDateFormat class
		//then we have to create the object of the date class
		//Date dt = new Date();
		//then we have connect both object together
		//String timeString = df.format(dt);
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
		
		try {
			FileUtils.copyFile(source, new File(destination));
			//here we are copying the file into destination
			//when we created the screenshot it was to specify to ant location
			//then we create the one destination file
			//FileUtils.copyFile used this file to convert source file to destination file
		} catch (Exception e) {
			e.getMessage();
			
		}
		return destination;
	}
	
	
	@AfterClass(groups = {"Sanity","Master","Regression"})
	public void tearDown() {
		
		driver.quit();
	}
	
	public  String randomString() {
		String generatedString  = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomInt() {
		String generatedInt = RandomStringUtils.randomNumeric(10);
		return generatedInt;
	}
	
	public String randomAlphaNumeric() {
		String generatedString  = RandomStringUtils.randomAlphabetic(2);
		String generatedInt = RandomStringUtils.randomNumeric(3);
		return (generatedString + generatedInt);
	}

}
