package pageObjects;

import org.openqa.selenium.By;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class PageObj_JoinOcean_screen {
	
	public AndroidDriver<AndroidElement> driver ;
	By joinoceantitle = By.xpath("//*[@text='Let's Begin']");
	By firstname = By.id("com.carnival.gxi.ocean.compass.oceanready:id/input_first_name");
	By lastname =By.id("com.carnival.gxi.ocean.compass.oceanready:id/input_last_name");
	By email = By.id("com.carnival.gxi.ocean.compass.oceanready:id/input_email");
	By NextBtn = By.id("com.carnival.gxi.ocean.compass.oceanready:id/nextButton");
	By info = By.className("android.widget.LinearLayout");
	By pwd = By.id("com.carnival.gxi.ocean.compass.oceanready:id/input_password");
	By tc = By.id("com.carnival.gxi.ocean.compass.oceanready:id/textTermsConditions");
	
	By creatpwdtitle = By.xpath("//*[@text='Create a \n" + 
			" Password']");
	
	By confirmpwd = By.id("com.carnival.gxi.ocean.compass.oceanready:id/input_password_confirm");
	By joinoceanBtn = By.id("com.carnival.gxi.ocean.compass.oceanready:id/joinOceanButton");
	
	public PageObj_JoinOcean_screen(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
	}
	
	public AndroidElement getfirstname() {
	return driver.findElement(firstname);
	}
	
	public AndroidElement getlastname() {
		return driver.findElement(lastname);
		}
	
	public AndroidElement getemail() {
		return driver.findElement(email);
		}
	
	public AndroidElement getNextBTN() {
		return driver.findElement(NextBtn);
		}
	
	public AndroidElement getInfoIcon() {
		return driver.findElement(info);
		}
	
	public AndroidElement getcreatePwdTitle() {
		return driver.findElement(creatpwdtitle);
		}
	
	public AndroidElement getpwd() {
		return driver.findElement(pwd);
		}
	
	public AndroidElement getconfirmpwd() {
		return driver.findElement(confirmpwd);
		}
	
	public AndroidElement getjoinoceanbtn() {
		return driver.findElement(joinoceanBtn);
		}

}
