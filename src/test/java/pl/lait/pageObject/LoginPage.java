package pl.lait.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	 
	//linijka nizej to zmienna globalna- koszyczek na przeglądarke
	
	WebDriver driver;
	
	@FindBy(linkText = "SIGN-ON")
	WebElement signOnLink;
	//stwóż nowy web element poprzez znalezienie go na stronie ale w taki sposób ze jego link test wygląda tak...
	@FindBy(name = "userName")
	WebElement loginInput;
	
	@FindBy(name = "password")
	WebElement passwdInput;
	
	@FindBy(name = "login")
	WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void loginAs(String login, String pass) {
		loginInput.sendKeys(login);
		passwdInput.sendKeys(pass);
		loginBtn.click();
		//btn= Baton
	}
	
	//linijka niżej -stwóż metode o nazwie kt bedzie guzików używała
	public void goToLoginPage() {
		signOnLink.click();
	}
	
}
