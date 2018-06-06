package pageObjects;

import org.openqa.selenium.By;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class PageObj_Login_screen {
	
	public AndroidDriver<AndroidElement> driver ;
	By username = By.id("com.carnival.gxi.ocean.compass.oceanready:id/input_email");
	By password =By.id("com.carnival.gxi.ocean.compass.oceanready:id/input_password");
	By rememberMe = By.className("android.widget.CheckBox");
	By LoginBtn = By.className("android.widget.Button");
	By JoinOceanLink = By.xpath("//*[@text='JOIN O·C·E·A·N']");
	By ForgotLoginDetailsLink = By.xpath("//*[@text='FORGOT LOGIN DETAILS']");
	By WelcomeToOcean = By.xpath("//*[@text='Welcome to O·C·E·A·N™']");
	By GetOceanReadyLink = By.xpath("//*[@text='GET O.C.E.A.N READY']");
	
	
	
	public PageObj_Login_screen(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
	}
	
	public AndroidElement getuname() {
	return driver.findElement(username);
	}
	
	public AndroidElement getpwd() {
		return driver.findElement(password);
		}
	
	public AndroidElement getrememberme() {
		return driver.findElement(rememberMe);
		}
	
	public AndroidElement getLogOnBTN() {
		return driver.findElement(LoginBtn);
		}
	
	public AndroidElement getJoinOceanLink() {
		return driver.findElement(JoinOceanLink);
		}
	
	public AndroidElement getForgotLoginDetailsLink() {
		return driver.findElement(ForgotLoginDetailsLink);
		}
	
	public AndroidElement getWelcomeToOcean() {
		return driver.findElement(WelcomeToOcean);
		}
	
	public AndroidElement getGetOceanReadyLink() {
		return driver.findElement(GetOceanReadyLink);
		}
	

}
