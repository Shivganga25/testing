package mainPack2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessengerPage {
	private WebDriver driver;
	
	
	@FindBy(xpath ="//a[@href='https://messenger.com/']")
	private WebElement messenger;
	
	@FindBy(xpath ="//a[text()='Rooms']")
	private WebElement rooms;
	
	public MessengerPage (WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver = driver;
	}

	public void openMessenger() {
		messenger.click();
	}
	
	public void openRooms() {
		rooms.click();
	}
}
