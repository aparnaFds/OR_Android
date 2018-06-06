package resources;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base {
	
	public static AndroidDriver<AndroidElement> driver ;

public static AppiumDriverLocalService service;
	
	/*public static void setserverPath(){
		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/bin/node"))
				.withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723));
		
	}
	
	public static void startServer() throws InterruptedException, MalformedURLException{
		service.start();
		Thread.sleep(2000L);
		System.out.println("Starting Server status ="+service.isRunning());
	}
	*/

	public static AndroidDriver<AndroidElement> initializeDriver() throws MalformedURLException {
			File f = new File("/Users/aparna.suresh.phondu/Documents/Aparna/GitRepo/OR_Android/src/main/java/resources/OR_31052018_2.apk");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung");
			cap.setCapability("noReset","true");
			cap.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
			driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);		
			return driver;		
	}
	
	public void getScreenshots(String result) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("OutputFiles/screenshots/"+result+"_screenshot.png"));
	}
	

}
