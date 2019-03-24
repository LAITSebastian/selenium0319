package pl.lait.SELENIUM;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Init {

	static WebDriver driver;
	// na dole ,to daje nam przeglądarke

	public static WebDriver getDriver() {
		// tworze nowy obiekt webdrivera i importuje chroma
		// "C://chromedriver_win32//chromedriver.exe"
		//niżej pełno wymiarowy adres interntowy pod zmienna url
		
		URL url = null;
		try {
			url = new URL ("http://localhost:4444/wd/hub");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//to samo dla capabilities:
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setPlatform(Platform.WIN10);
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		if(driver==null) {
			driver = new ChromeDriver();
			driver = new RemoteWebDriver(url, cap);
			driver.get("http://www.newtours.demoaut.com/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return driver;
		} else {
			return driver;
		}		
	}

	public static void log(String msg) {
		System.out.println(" --- " + msg + " --- ");
	}

	public static void close() {
		driver.close();
		driver.quit();
		driver=null;
	}

	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
