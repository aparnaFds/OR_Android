package android_Testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import pageObjects.PageObj_Login_screen;
import resources.Base;

public class Login extends Base{
	
	public static Logger log = LogManager.getLogger(Login.class.getName());
//	@BeforeTest
	public void invokeDriver() throws IOException {
		AndroidDriver<AndroidElement> driver = initializeDriver();
		log.info("Driver initialized");
	}
	
	
	@Test(priority=1)	
	public void verifyUsernameField() throws MalformedURLException {
		PageObj_Login_screen login = new PageObj_Login_screen(driver);
		Boolean usernametrue =login.getuname().isDisplayed();
		Assert.assertTrue(usernametrue);	
	}
	
	@Test(priority=1)	
	public void verifyWelcomeToOCEAN() throws MalformedURLException {
		PageObj_Login_screen login = new PageObj_Login_screen(driver);
		Boolean salutationtrue =login.getWelcomeToOcean().isDisplayed();
		Assert.assertTrue(salutationtrue);	
	}
	
	@Test(priority=1)	
	public void verifyPasswordField() throws MalformedURLException {
		PageObj_Login_screen login = new PageObj_Login_screen(driver);
		Boolean pwdtrue =login.getuname().isDisplayed();
		Assert.assertTrue(pwdtrue);		
	}
	
	@Test(priority=1)	
	public void verifyRememberMeField() throws MalformedURLException {
		PageObj_Login_screen login = new PageObj_Login_screen(driver);
		Boolean getremembermetrue =login.getrememberme().isDisplayed();
		Assert.assertTrue(getremembermetrue);	
	}
	
	@Test(priority=1)	
	public void verifygetLogOnBTN() throws MalformedURLException {
		PageObj_Login_screen login = new PageObj_Login_screen(driver);
		Boolean getLogOnBTNtrue =login.getLogOnBTN().isDisplayed();
		Assert.assertTrue(getLogOnBTNtrue);	
	}
	
	@Test(priority=1)	
	public void verifyJoinOceanLink() throws MalformedURLException {
		PageObj_Login_screen login = new PageObj_Login_screen(driver);
		Boolean JoinOceanlinktrue =login.getJoinOceanLink().isDisplayed();
		Assert.assertTrue(JoinOceanlinktrue);	
	}
	
	@Test(priority=2, dataProvider = "getData")	
	public void verifyLogin(String username, String password) throws MalformedURLException {
		PageObj_Login_screen login = new PageObj_Login_screen(driver);
		login.getuname().clear();
		log.info("Username cleared");
		login.getuname().sendKeys(username);
		log.info("Username entered");
		login.getpwd().sendKeys(password);
		log.info("Password entered");
//		Assert.assertEquals(true, login.getrememberme().isEnabled());
		login.getrememberme().click();
		log.info("Remember me selected");
//		Assert.assertEquals(true, login.getLogOnBTN().isEnabled());
		login.getLogOnBTN().click();
		log.info("Log on button clicked");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if(driver.getPageSource().contains("Compass Is Currently Unavailable")) {
			System.out.println("API failed");
			log.error("Login API failed or network issue");
			TouchAction t = new TouchAction(driver);
			t.tap(driver.findElementById("com.carnival.gxi.ocean.compass.oceanready:id/img_close")).perform();
		}
		else {
			System.out.println("Login successful");
			
		}
		
		}	

	
//	@Test(priority=3, dependsOnMethods={"verifyLogin"})
	public void verifyGetOceanReadyLink() throws MalformedURLException {
		PageObj_Login_screen login = new PageObj_Login_screen(driver);
//		driver.getPageSource().contains("welcome");
		Boolean getwelcometrue =driver.getPageSource().contains("welcome");
		Assert.assertTrue(getwelcometrue);	
		if(getwelcometrue=true) {
			System.out.println("Guest has future journey");
			log.debug("Get Ocean Ready link is displayed");
		}
		else
			System.out.println("No active journey for this guest");
			log.debug("Get Ocean Ready link is not displayed");
	}

	

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][2];
		data[0][0]="VOWL50@GXITESTMAIL.COM";
		data[0][1]="Welcome1";
	//	data[1][0]="sim.sim@gxitestmail.com";
	//	data[1][1]="Welcome1";
		
		return data;
	}
	
	
}
