package tests.ios;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import main.Setup;
import main.java.ios.features.Feature;


public class IOSBaseTest {

	protected static IOSDriver<MobileElement> driver;
	protected static Feature feature;

	
	@BeforeSuite(alwaysRun = true)
	public void setup() throws Exception{
		
		feature = new Feature(driver);
		
		driver = Setup.getIOSDriver();
		driver.launchApp();
	}
	
	@AfterSuite(alwaysRun = true)
	public void tearDown(){
		driver.closeApp();

	}
	
	@AfterMethod(alwaysRun = true)
	public void resetToDefault(){
		driver.closeApp();
		driver.launchApp();
	}
}
