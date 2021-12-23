package qa.sdt.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.sdt.base.TestBase;

public class LoginPage extends TestBase{
	
	//WebElement - Element repository
	@FindBy(name = "username") 
	WebElement txtusername;
	
	@FindBy(name ="password")
	WebElement txtpassword;
	@FindBy(xpath ="//*[@value='Login']")
	WebElement btnlogin;
	
	@FindBy(xpath ="//*[text()='Sign Up']")
	WebElement linkSignup;
	
	@FindBy(xpath ="(//*[@class='img-responsive'])[1]")
	WebElement crmLogo;
	
	@FindBy(xpath = "//*[contains(text(),'Logout')]")
	WebElement labelLogout;
	
	       //Initialization
	//constructor  - to crate object, while creating an object if we want to execute some.
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	//Actions - methods
	public void login(String username,String password) {
		txtusername.sendKeys(username);
		txtpassword.sendKeys(password);
		btnlogin.click();
	}
	public boolean crmLogovalidation() {
		boolean crmlogo = crmLogo.isDisplayed();
		return crmlogo;
	}
	public String getlabelLogoutText() {
		driver.switchTo().frame("mainpanel");
		String text = labelLogout.getText();
		return text;
	}
	
}
