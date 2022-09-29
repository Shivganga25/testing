package mainPack2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenGamePage {
	private WebDriver driver;
	
	@FindBy(xpath = "//a[text()='Games']")
	private WebElement games ;
	
	public OpenGamePage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    	this.driver =driver;
    }
	
	public void openGames() {
		games.click();
		
	}
}
