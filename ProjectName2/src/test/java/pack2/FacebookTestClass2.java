package pack2;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import mainPack2.LogInPage;
import mainPack2.OpenGamePage;
import setup2.Base2;
import utitilitis.Utility;

public class FacebookTestClass2 extends Base2{
		private WebDriver driver;
		private LogInPage loginAcc;
		private OpenGamePage game;
		private SoftAssert soft;
		int testId;
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
			 loginAcc=new LogInPage(driver);
			 game =new OpenGamePage(driver);
			 soft=new SoftAssert();
		}
		
		@BeforeMethod
		public void openFacebook() throws Throwable {
			driver.get("https://www.facebook.com/");
			
			String userName = Utility.getDatafromExcel("Student data",2,2);
			loginAcc.sendUserName(userName);
			
			String password = Utility.getDatafromExcel("Student data",2,6);
			loginAcc.sendPassword(password);
		}
		
		@Test
		public void verifyClickOnLogInButton() {
			testId =1234;
			loginAcc.clickOnLogIn();
			
		    String url = driver.getCurrentUrl();
		    String title =driver.getTitle();	
		    soft.assertEquals(url, "https://www.facebook.com/");
		    soft.assertEquals(title, "Log in to Facebook");
		    soft.assertAll();
		}
		
		@Test
		public void verifyOpenGamesPage() {
			testId =5678;
			 game.openGames();
			 String url = driver.getCurrentUrl();
			 String title =driver.getTitle();	
			 soft.assertEquals(url, "https://www.facebook.com/");
			 soft.assertEquals(title, "Log in to Facebook");
			 soft.assertAll();
			
		}
		@AfterMethod
		public void backToMainPage(ITestResult result) throws IOException {
			if(ITestResult.FAILURE == result.getStatus())
			{
				Utility.captureSreenshot(driver,+testId);
			}
		}
			
		@AfterClass
		public void clearObjects() {
			loginAcc=null;
		}
		
		@AfterTest
		public void closeBrowser() {
			driver.close();
			driver=null;
			System.gc(); //garbage collector
		}
		
		

	}

