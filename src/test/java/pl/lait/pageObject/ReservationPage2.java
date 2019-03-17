package pl.lait.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pl.lait.SELENIUM.Init;

public class ReservationPage2 {
	//to jest nowa klasa i w niej konstruktor
		WebDriver driver;
		
		//nizej linijka to 1 xparh z DEPART
		@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/"
				+ "tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[3]/td[1]/input")
		WebElement radio_d_1;
		
		// to linijke niżej jest xpath do 2 kropki w DEPART - Blue Skies Airlines 361
		@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/"
				+ "tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[5]/td[1]/input")
		WebElement radio_d_2;
		
		//to niżej linijka to xpath z kropki 3 w DEPART
		@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/"
				+ "tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[7]/td[1]/input")
		WebElement radio_d_3;
		
		//to nilijke // to linijke niżej jest xpath do 4 kropki w RETURN 
		@FindBy(xpath ="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/"
				+ "tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[9]/td[1]/input")
		WebElement radio_d_4;
		
		//RETURNING:
		
		@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/"
				+ "tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[3]/td[1]/input")
		WebElement radio_r_1;
		
		@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/"
				+ "tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[5]/td[1]/input")
		WebElement radio_r_2;
		
		@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/"
				+ "tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[7]/td[1]/input")
		WebElement radio_r_3;
		
		@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/"
				+ "tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[9]/td[1]/input")
		WebElement radio_r_4;
		
		@FindBy(name = "reserveFlights")
		WebElement reserveFlightsBtn;
		
		// nagranie od 12;35 17 marzec
		//------------------------------------------reservation 3 level---------------------------------------------------------------
		//passFirst0input to zakładka passangers first name
		
		@FindBy(name = "passFirst0")
		WebElement passFirst0Input;
		
		@FindBy(name = "passLast0")
		WebElement passLast0Input;
		
		@FindBy(name = "pass.0.meal")
		WebElement meal0Select;
		
		//to buyFlights to jest przycisk zatwierdzający- pomarańczowy na samym dole.
		@FindBy(name = "buyFlights")
		WebElement buyFlights;
		
		//teraz juz po przyciśnieciu buyFlights dajemy ostatni przycisk juz na następnej stronie pokazujacej sie po tym buyFlights
		@FindBy(name = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table"
				+ "/tbody/tr[1]/td[2]/table/tbody/tr[7]/td/table/tbody/tr/td[2]/a/img")
		WebElement BackToHome;
		
		//------------------------------------------resery 3 END ---------------------------------------------------------------------
		
		//konstruktor:
		public ReservationPage2() {
			driver = Init.getDriver();
			PageFactory.initElements(driver, this);
		}
		//dwie metody:
		public void selectFlights(int departing, int returning) {
			switch (departing) {
			case 1:
				radio_d_1.click();
				break;
			case 2:
				radio_d_2.click();
				break;
			case 3:
				radio_d_3.click();
				break;
			case 4:
				radio_d_4.click();
				break;
			default:
				break;
			}//end switch
		}//end selectFlights()
		
		public void submit() {
			reserveFlightsBtn.click();
		}
	//end class
	//-------- r3 start----------

	public void pass0(String firstName, String lastName, String mealCode) {
	// KSML-koszerny posiłek
	//dla inputa 1 pasażera wyślij przycisk..:
	passFirst0Input.sendKeys(firstName);
	passLast0Input.sendKeys(lastName);
	Select m = new Select(meal0Select);
	m.selectByValue(mealCode);
	
		}
	/**
	* Buy Flights (3 ekran rezerwacji)
	*/
	
	public void submit2() {
		buyFlights.click();
	}
	public void BackToHome() {
		BackToHome.click();
	}
}
 //----------r3 end-----------

	
	
	

