package pl.lait.SELENIUM;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MenuTest {

	WebDriver driver;
	
	public void linkClick(String linkText) {
		Init.log("Klikam w link: " + linkText);
		driver.findElement(By.linkText(linkText)).click();
	}
	
	public void radioClick(String xpath) {
		Init.log("Klikam w element z xpath: " + xpath);
		driver.findElement(By.xpath(xpath)).click();
		
	}
	
	
	@Before
	public void bifor() {
		// otwieramy przeglądarke przed testem
		Init.log("Otwieram okno przeglądarki");
		driver = Init.getDriver();
	}
	
	@Ignore
	@Test
	public void topMenu() {
		linkClick("CONTACT");
		driver.findElement(By.linkText("SUPPORT")).click();
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.linkText("SIGN-ON")).click();
	}
	
	@Ignore
	@Test
	public void leftMenu() {
		driver.findElement(By.linkText("Home")).click();
		driver.findElement(By.linkText("Flights")).click();
		driver.findElement(By.linkText("Hotels")).click();
		driver.findElement(By.linkText("Car Rentals")).click();
		driver.findElement(By.linkText("Cruises")).click();
		driver.findElement(By.linkText("Destinations")).click();
		driver.findElement(By.linkText("Vacations")).click();
	}
	
	@Test
	
	public void loginAndReservationLevel1() {
		driver.findElement(By.linkText("SIGN-ON")).click();
		Init.sleep(1);
		
		driver.findElement(By.name("userName")).sendKeys("sebastianautomat");
		driver.findElement(By.name("password")).sendKeys("Lublin2019");
		driver.findElement(By.name("login")).click();
		
		Init.sleep(3);
		//driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[2]");
		//i ten napis string niżej znaczy to samo co to co linijkę wyżej.
		
		String oneWayXpath = "/html/body/div/table/tbody/tr/td[2]/table/"
				+ "tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/"
				+ "td/form/table/tbody/tr[2]/td[2]/b/font/input[2]";
		
		driver.findElement(By.xpath(oneWayXpath)).click();
		WebElement passCountWebElem = driver.findElement(By.name("passCount"));
		Select passCountSelect = new Select(passCountWebElem);
		passCountSelect.selectByVisibleText("3");
		
		Select fromPortSelect = new Select(driver.findElement(By.name("fromPort")));
		fromPortSelect.selectByVisibleText("Paris");
		Select fromMonth = new Select(driver.findElement(By.name("fromMonth")));
		fromMonth.selectByValue("12");
		Select fromDay = new Select(driver.findElement(By.name("fromDay")));
		fromDay.selectByValue("23");
		
		Init.sleep(2);
		
		Select toPortSelect = new Select(driver.findElement(By.name("toPort")));
		toPortSelect.selectByVisibleText("Sydney");
		Select toMonth = new Select(driver.findElement(By.name("toMonth")));
		toMonth.selectByValue("4");
		Select toDay = new Select(driver.findElement(By.name("toDay")));
		toDay.selectByValue("23");
		
		String servClassXpath = "/html/body/div/table/tbody/tr/td[2]/"
				+ "table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/"
				+ "tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[2]";
		
		driver.findElement(By.xpath(servClassXpath)).click();
		
		WebElement servClassWebElem = driver.findElement(By.name("airline"));
		Select servClassSelect = new Select(servClassWebElem);
		servClassSelect.selectByVisibleText("Pangea Airlines");
	
		String continueXpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table"
				+ "/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td/input";
		
		driver.findElement(By.xpath(continueXpath)).click();
		
		Init.sleep(2);
	
	//Depart
		
		String outFlightXpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table"
			+ "/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[5]/td[1]/input";	
		radioClick(outFlightXpath);
		
	//Return
		String inFlightXpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table"
				+ "/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[7]/td[1]/input";	
		radioClick(inFlightXpath);
		Init.sleep(1);
		
	driver.findElement(By.name("reserveFlights")).click();
	Init.log("Klikam w przycisk CONTINUE -->");
	
	//passangers
	
	driver.findElement(By.name("passFirst0")).sendKeys("Sebek");
	driver.findElement(By.name("passLast0")).sendKeys("Abcdefgh");
	driver.findElement(By.name("creditnumber")).sendKeys("122222233334");
	
	//securepuchase
	driver.findElement(By.name("reserveFlights")).click();
	Init.log("Klikam w przycisk CONTINUE -->");
	
	Init.sleep(2);
	
	
	
	}
	
	@Ignore
	@After
	public void awter() {
		// tu trzeba zamknąć przeglądarke
		Init.close();
	}
}