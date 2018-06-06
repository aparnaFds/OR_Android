package android_Testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.PageObj_JoinOcean_screen;
import pageObjects.PageObj_Login_screen;

public class JoinOcean extends EnvironmentSelection{
	
	public static Logger log = LogManager.getLogger(JoinOcean.class.getName());

	@BeforeTest
	public void invokeDriver() throws IOException {
		AndroidDriver<AndroidElement> driver = initializeDriver();
		log.info("Driver initialized");
		verifyEnvSelection();
	}
	
	
	@Test(priority=0)	
	public void verifyJoinOceanLink() throws MalformedURLException {
		PageObj_Login_screen login = new PageObj_Login_screen(driver);
		login.getJoinOceanLink().click();
	//	Boolean salutationtrue =login.getWelcomeToOcean().isDisplayed();
	//	Assert.assertTrue(salutationtrue);	
	}
	
	@Test(priority=1, dataProvider = "getData")	
	public void verifyJoinoceanflow(String firstname, String lastname, String email, String password) throws MalformedURLException {
		PageObj_JoinOcean_screen joinOcean = new PageObj_JoinOcean_screen(driver);
		driver.navigate().back();
		joinOcean.getfirstname().sendKeys(firstname);
		joinOcean.getlastname().sendKeys(lastname);
		joinOcean.getemail().sendKeys(email);
		joinOcean.getNextBTN().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		Assert.assertTrue(JoinOceanlinktrue);	
		/*if(driver.getPageSource().contains("there is already an account")) {
			System.out.println("Account already exists");
		}*/
	}
	
	@Test(priority=2)	
	public void verifyCreatePwdSubHeader() throws MalformedURLException {
		PageObj_JoinOcean_screen joinOcean = new PageObj_JoinOcean_screen(driver);
		Boolean subtitletrue =joinOcean.getcreatePwdTitle().isDisplayed();
		Assert.assertTrue(subtitletrue);	
	}
	
	@Test(priority=2)	
	public void verifyemailField() throws MalformedURLException {
		PageObj_JoinOcean_screen joinOcean = new PageObj_JoinOcean_screen(driver);
		Boolean emailtrue =joinOcean.getemail().isDisplayed();
		Assert.assertTrue(emailtrue);		
	}
	
	@Test(priority=2)	
	public void verifyPasswordField() throws MalformedURLException {
		PageObj_JoinOcean_screen joinOcean = new PageObj_JoinOcean_screen(driver);
		Boolean emailtrue =joinOcean.getpwd().isDisplayed();
		Assert.assertTrue(emailtrue);		
	}
	
	@Test(priority=3, dataProvider = "getData")	
	public void verifyCreatePassword(String firstname, String lastname, String email, String password) throws MalformedURLException {
		PageObj_JoinOcean_screen joinOcean = new PageObj_JoinOcean_screen(driver);
		joinOcean.getpwd().sendKeys(password);
	//	driver.navigate().back();
		joinOcean.getNextBTN().click();
		joinOcean.getconfirmpwd().sendKeys(password);
		joinOcean.getjoinoceanbtn().click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/*if(driver.getPageSource().contains("Welcome")) {
			System.out.println("Join ocean is successful");
			
	}
		
		else {
		System.out.println("Join ocean failed");
		}		*/
		}	


	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][4];
		data[0][0]="aparna";
		data[0][1]="s";
		data[0][2] = "a@c.com";
		data[0][3]="Welcome1";
		
		return data;
	}
	
	
}
