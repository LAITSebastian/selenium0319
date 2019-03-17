package pl.lait.SELENIUM;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pl.lait.pageObject.LoginPage;
import pl.lait.pageObject.ReservationPage;
import pl.lait.pageObject.ReservationPage2;

public class LoginTest {

	//pierwszostronne rezerwacje:
	
	WebDriver driver;
		
		@Before
		public void bifor() {
			driver = Init.getDriver();
		}
		@Ignore
		@Test
		public void loginTest() {
			LoginPage lp = new LoginPage(driver);
			lp.goToLoginPage();
			lp.loginAs("sebastianautomat", "Lublin2019");
		}
		
		@Test
		public void reserveTest() {
			LoginPage lp = new LoginPage(driver);
			lp.goToLoginPage();
			lp.loginAs("sebastianautomat", "Lublin2019");
			ReservationPage rp = new ReservationPage();
			rp.from("Frankfurt", "3", "16");
			rp.to("London", "3", "20");
			rp.passCount("2");
			rp.firstClass();
			rp.submit();
			
			//2gi etap czyli druga strona rezerwacji: (17marzec 11;45 - 11:50) ale nagranie zaczeło sie około 11'00.
			ReservationPage2 rp2 = new ReservationPage2();
			rp2.selectFlights(2,  4);
			rp2.submit();
			
			//3 etap rezerwacji nagranie od 12;33 17 marca
			rp2.pass0("seba", "AAAAAA", "KSML");
			Init.sleep(3);
			rp2.submit2();
		}
	
		@After
		public void awter() {
			//tu trzeba podpiąć przeglądarke
			Init.close();
		}
	
}