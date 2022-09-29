package mainPack2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage {
	private WebDriver driver;
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement user ;
	
	@FindBy(xpath = "//input[@id='pass']")
	private WebElement passWord ;
	
	@FindBy(xpath = "//button[@name='login']")
	private WebElement logIn ;
	
    public LogInPage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    	this.driver =driver;
  
    }
    
    public void sendUserName(String userName) {
		user.sendKeys(userName);
	}
    public void sendPassword(String password) {
		passWord.sendKeys(password);
    }

	public void clickOnLogIn() {
		logIn.click();
	}
}
