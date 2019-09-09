package main.java.ios.utility;

import java.io.File;
import java.util.NoSuchElementException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;

import tests.ios.IOSBaseTest;

public class CommonIOSFunctions extends IOSBaseTest{

	public static  void takeScreenShot(String fileName) throws Exception{
		try
		{
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

			if(scrFile.exists())
				Files.copy(scrFile, new File("test-output/Automationscreenshots/"+fileName+".png"));
			else
				takeScreenShot(fileName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
