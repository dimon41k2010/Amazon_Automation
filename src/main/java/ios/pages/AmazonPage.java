package main.java.ios.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.sun.tools.javac.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;
import main.java.ios.utility.CommonIOSFunctions;

public class AmazonPage {

	private IOSDriver<MobileElement> driver;
	

	@iOSFindBy(id = "twotabsearchtextbox")
	IOSElement searchTextBox;
	
	@iOSFindBy(id = "suggestions-template")
	IOSElement autoSuggest;

	@iOSFindBy(xpath = "//*[@id=\"search\"]/span[2]/div/div[3]/div")
	IOSElement searchResult;

	@iOSFindBy(xpath = "//*[@id=\"s-rib-toggle-container\"]/span[2]")
	IOSElement primeButton;
	
	@iOSFindBy(id = "a-badge-label")
	IOSElement amazonChoice;
	
	@iOSFindBy(id = "a-price-whole")
	IOSElement priceElement;

	@iOSFindBy(id = "newBuyBoxPrice")
	IOSElement newBuyBoxPrice;
	
	@iOSFindBy(id = "buy-now-button")
	IOSElement buyNowButton;
	
	@iOSFindBy(id = "ap_email_login")
	IOSElement signIn;
	
	@iOSFindBy(id = "ap_passwordn")
	IOSElement passwordText;

	@iOSFindBy(id = "signInSubmit")
	IOSElement submitButton;
	
	@iOSFindBy(id = "outer-accordion-signin-signup-page")
	IOSElement amazonSignPage;
	
	@iOSFindBy(id = "productTitle")
	IOSElement productTitle;
	
	@iOSFindBy(xpath = "//*[@id=\"spc-orders\"]/div[1]/div/div[3]/div/div/div[2]/div[1]/div/div[2]/div[1]/strong")
	IOSElement checkoutPageItem;
	
	
	String amazonChoicePrice = null; 
	
	String productTitleText = null;

	
	public AmazonPage(IOSDriver<MobileElement> driver2){
		this.driver = driver2;
	}
	
	public  void verifySearchBox() throws Exception{
		if(!searchTextBox.isDisplayed()){
			CommonIOSFunctions.takeScreenShot("verifySearchBox");
			Assert.fail("Search box not found");
		}
	}
	
	public  void autoSuggestion(String serachText , String dropBoxText) throws InterruptedException{
		searchTextBox.sendKeys(serachText);
		Thread.sleep(1000);
		
		java.util.List<MobileElement> optionsToSelect = autoSuggest.findElements(By.id("suggestions2"));
		
		for(MobileElement option : optionsToSelect){
	        if(option.getText().equals(dropBoxText)) {
	        	System.out.println("Trying to select: "+dropBoxText);
	            option.click();
	            break;
	        }
		}
		
	}
	
	public void verifySerachResults() throws Exception {
		if(!searchResult.isDisplayed()){
			CommonIOSFunctions.takeScreenShot("verifySerachResults");
			Assert.fail("No search results");
		}
	}
	
	public void togglePrimeButton() {
		java.util.List<MobileElement> switchPrimeElement = driver.findElements(By
	            .xpath("//*[@id=\\\"s-rib-toggle-container\\\"]/span[2]"));
	    if (switchPrimeElement.size() == 0) {
	    		switchPrimeElement.get(0).findElement(By.cssSelector("span.switch-left")).click();
	    }
	}
	
	public void verifyPrimeSearchResults(String result) {
		java.util.List<MobileElement> results = driver.findElements(By.xpath("//*[@id=\"search\"]/span[5]/divw"));

	    for (int i = 0; i < results.size(); i++) {
	        Assert.assertTrue(results.get(i).getText().contains(result), "Search result validation failed [ + i + ].");
	    }
	}
	
	public void clickOnAmazonChoice() throws Exception {
		if(searchTextBox.isDisplayed()){
			amazonChoicePrice = priceElement.getText(); 
			amazonChoice.click();
			Thread.sleep(1000);
			productTitleText = productTitle.getText();
		}
		else {
			CommonIOSFunctions.takeScreenShot("clickOnAmazonChoice");
			Assert.fail("choice option doesn't displayed");
		}
	}

	public void verifyPrice() throws Exception {
		if(newBuyBoxPrice.isDisplayed()){
			if(!amazonChoicePrice.equals(newBuyBoxPrice.getText()))
			{
				Assert.fail("Mismatch in item price");
			}
		}
		else {
			CommonIOSFunctions.takeScreenShot("verifyPrice");
			Assert.fail("Item price doesn't displayed");
		}
	}
	
	public void clickOnBuyNow() throws Exception {
		if(buyNowButton.isDisplayed()) {
			buyNowButton.click();
		}
		else {
			CommonIOSFunctions.takeScreenShot("clickOnBuyNow");
			Assert.fail("Buy Now button doesn't displayed");
		}
	}
	
	public void loginAmazonAccount(String userId, String password) {
		if(amazonSignPage.isDisplayed())
		{
		
			if(signIn.isDisplayed()){
				signIn.sendKeys(userId);
				passwordText.sendKeys(password);
				submitButton.click();
			}
		}
		else
		{
			System.out.println("Amazon account is already logged");
		}
	}
	
	public void verifyCheckOutPage() throws Exception {
		if(checkoutPageItem.isDisplayed())
		{
			if(!productTitleText.equals(checkoutPageItem.getText())) {
				Assert.fail("Wrong item got added to checkout page");
			}
		}
		else {
			CommonIOSFunctions.takeScreenShot("verifyCheckOutPage");
			Assert.fail("Checkout page doesn't have item");
		}
	}
	
}
