package main;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;


public class Setup {
	public static final String appiumServerURL ="http://127.0.0.1:4723/wd/hub";
	public static final String appBundleID = "com.amazon.shopping";
	public static IOSDriver<MobileElement> iOSDriver=null;
	
	public static IOSDriver<MobileElement> getIOSDriver() throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("device", "iPhone");
		capabilities.setCapability(CapabilityType.VERSION, "6.1");
		capabilities.setCapability(CapabilityType.PLATFORM, "MAC");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("deviceName", "iPhone 10");
		capabilities.setCapability("bundleId",appBundleID);
		capabilities.setCapability( "useLocationServices",true);
		capabilities.setCapability( "automationName","XCUITest");
		capabilities.setCapability( "app","/Users/DrLex/Documents/TestApp/Amazon Shopping_v18.14.0.100_apkpure.com.ipa");
		
		capabilities.setCapability("udid", "35cab68521e1373196a67b098a1bccfd94c308b1d");
		capabilities.setCapability("newCommandTimeout", "6000");

		iOSDriver = new IOSDriver<MobileElement>(new URL(appiumServerURL), capabilities);
		iOSDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		return iOSDriver;
	}

	
}
