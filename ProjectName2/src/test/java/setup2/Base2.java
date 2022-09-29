package setup2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base2 {
	public static WebDriver openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium in java\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    return driver;
	}

	public static WebDriver openFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver", "G:\\Selenium in java\\geckodriver-v0.31.0-win64\\geckodriver.exe");
	    WebDriver driver = new FirefoxDriver();
	    return driver;
	}
	
	}
