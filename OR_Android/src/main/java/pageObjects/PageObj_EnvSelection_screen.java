package pageObjects;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class PageObj_EnvSelection_screen {

	public AndroidDriver<AndroidElement> driver ;
	By env = By.xpath("//*[@text='Select Environment']");
	By qaenv =By.xpath("(//android.widget.TextView)[7]");
	By Btn = By.className("android.widget.Button");
	
	public PageObj_EnvSelection_screen(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
	}

	public AndroidElement getselectEnv() {
	return driver.findElement(env);
	}
	
	public AndroidElement getQA() {
	return driver.findElement(qaenv);
	}
	
	public AndroidElement getButton() {
	return driver.findElement(Btn);
	}

}