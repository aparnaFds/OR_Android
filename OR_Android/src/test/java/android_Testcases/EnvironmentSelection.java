package android_Testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import pageObjects.PageObj_EnvSelection_screen;
import resources.Base;

public class EnvironmentSelection extends Base{
	
	public static Logger log = LogManager.getLogger(EnvironmentSelection.class.getName());
	
	@BeforeTest
	public void invoke() throws MalformedURLException, InterruptedException {
		initializeDriver();
	}
	
	@Test
	public void verifyEnvSelection() throws MalformedURLException {
		PageObj_EnvSelection_screen envselect = new PageObj_EnvSelection_screen(driver);
		envselect.getselectEnv().click();
		log.info("Environment dropdown is clicked");
		envselect.getQA().click();
		log.info("QA Environment is selected");
		envselect.getButton().click();
		log.error("Submit button is clicked");		
	}
		

}
