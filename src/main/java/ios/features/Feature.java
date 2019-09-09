package main.java.ios.features;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import main.java.ios.pages.AmazonPage;

public class Feature {

	private AmazonPage amazonPage;

	private IOSDriver<MobileElement> driver;

	public Feature(IOSDriver<MobileElement> driver2){

		amazonPage = new AmazonPage(driver2);
		PageFactory.initElements(new AppiumFieldDecorator(driver2, 5, TimeUnit.SECONDS), amazonPage);

        this.driver = driver2;
	}
	
	public void verifySearchBox() throws Exception {
		amazonPage.verifySearchBox();
	}
	
	public void autoSuggestion(String searchItem, String autoSuggestion) throws Exception {
		amazonPage.autoSuggestion(searchItem, autoSuggestion);
	}
	
	public void verifySerachResults() throws Exception {
		amazonPage.verifySerachResults();
	}
	
	public void togglePrimeButton() throws Exception {
		amazonPage.togglePrimeButton();		
	}
	
	public void verifyPrimeSearchResults(String result) {
		amazonPage.verifyPrimeSearchResults(result);
	}
	
	public void clickOnAmazonChoice() throws Exception {
		amazonPage.clickOnAmazonChoice();		
	}
	
	public void verifyPrice() throws Exception {
		amazonPage.clickOnAmazonChoice();		
	}
	
	public void clickOnBuyNow() throws Exception {
		amazonPage.clickOnBuyNow();
	}

	public void loginAmazonAccount(String userId, String password) {
		amazonPage.loginAmazonAccount(userId, password);
	}
	
	public void verifyCheckOutPage() throws Exception {
		amazonPage.verifyCheckOutPage();
	}
	
	
}
