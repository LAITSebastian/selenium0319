package pl.lait.SELENIUM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Init {

	static WebDriver driver;
	// na dole ,to daje nam przeglądarke

	public static WebDriver getDriver() {
		// tworze nowy obiekt webdrivera i importuje chroma
		// "C://chromedriver_win32//chromedriver.exe"

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		if(driver==null) {
			driver = new ChromeDriver();
			driver.get("http://www.newtours.demoaut.com/");
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
