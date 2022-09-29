package mainPack2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoomsPage {
	
private WebDriver driver;
	
	
	@FindBy(xpath ="//a[text()=' Return to messenger.com ']")
	private WebElement returnOnMessenger;
	
	@FindBy(xpath ="//a[text()=' Visit our help center ']")
	private WebElement helpCenter;
	
	public RoomsPage (WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver = driver;
	}

	public void backToMessenger() {
		returnOnMessenger.click();
	}
	
	public void visitHelpCenter() {
		helpCenter.click();
	}

}
