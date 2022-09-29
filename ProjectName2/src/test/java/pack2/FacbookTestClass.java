package pack2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import mainPack2.MessengerPage;
import mainPack2.RoomsPage;
import setup2.Base2;

public class FacbookTestClass extends Base2{
	private WebDriver driver;
	private MessengerPage openMessengerPage ;
	private RoomsPage openRoomsOption;
	private SoftAssert soft;
	
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browserName) {
		System.out.println(browserName);
		
		if(browserName.equals("Chrome")) {
				driver =openChromeBrowser();
			}
		
		if(browserName.equals("Firefox")) {
			driver=openFirefoxBrowser();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@BeforeClass
	public void createPOMobjects() {
		openMessengerPage = new MessengerPage(driver);
	    openRoomsOption=new RoomsPage(driver);
		openRoomsOption=new RoomsPage(driver);

	}
	
	@BeforeMethod
	public void openMessengerAndRooms() {
		driver.get("https://www.facebook.com/");
		openMessengerPage.openMessenger();
		openMessengerPage.openRooms();
		soft=new SoftAssert();
	}
	
	@Test
	public void verifyReturnToMessengerPage() {
		openRoomsOption.backToMessenger();
	    String url = driver.getCurrentUrl();
	    String title =driver.getTitle();
	    soft.assertEquals(url, "https://www.messenger.com");
	    soft.assertEquals(title, "Messenger");
	    soft.assertAll();
	}
	
	@Test
	public void verifyContactToHelpCenter() {
		openRoomsOption.visitHelpCenter();
		String url = driver.getCurrentUrl();
	    String title =driver.getTitle();
	    soft.assertEquals(url, "https://www.messenger.com/help");
	    soft.assertEquals(title, "Messenger Help Centre");
	    soft.assertAll();
	}
	
	@AfterMethod
	public void backToMainPage() {
		driver.navigate().back();
	}
		
	@AfterClass
	public void clearObjects() {
		openMessengerPage = null;
	    openRoomsOption=null;
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver=null;
		System.gc(); //garbage collector
	}
	
	

}
