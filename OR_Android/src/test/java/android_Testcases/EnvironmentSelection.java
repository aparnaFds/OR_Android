package android_Testcases;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import pageObjects.PageObj_EnvSelection_screen;
import resources.Base;

public class EnvironmentSelection extends resources.Base{
	/*static ExtentReports report;
	static ExtentTest logger; */
	
	public static Logger log = LogManager.getLogger(EnvironmentSelection.class.getName());
	
	@BeforeTest
	public void invoke() throws MalformedURLException, InterruptedException {
		/*report=new ExtentReports("src/report");
		 logger=report.startTest("Verify invoking appium server and ocean ready app");
		 setserverPath();
		 startServer();*/
		initializeDriver();
		/*logger.log(LogStatus.INFO, "Appium server is started ");
		logger.log(LogStatus.INFO, "Application is up and running");
		PropertyConfigurator.configure("/Users/aparna.suresh.phondu/Documents/Aparna/OceanReady_Workspace/OceanReady_Android/src/main/java/resources/Log4j.properties");
//		 logger.debug("app is starting....");
*/	}
	
	@Test
	public void verifyEnvSelection() throws MalformedURLException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageObj_EnvSelection_screen envselect = new PageObj_EnvSelection_screen(driver);
		envselect.getselectEnv().click();
		log.info("Environment dropdown is clicked");
		envselect.getQA().click();
		log.info("QA Environment is selected");
		envselect.getButton().click();
		log.error("Submit button is clicked");		
	}
	
	

}
