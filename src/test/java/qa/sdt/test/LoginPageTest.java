package qa.sdt.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.sdt.base.TestBase;
import qa.sdt.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
  LoginPage loginPage;	
	 @BeforeMethod
	 public void setUp() {
		 initilization();
		 loginPage = new LoginPage();
	 }
	 @Test (priority = 1)
	 public void validateLoginTest() {
		 loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		 String data = loginPage.getlabelLogoutText();
		 //System.out.println(data);
		 Assert.assertEquals(data, "  Logout  "); 
	 }
     @Test(priority = 0,enabled = false)
     public void validateCRMLogoTest() {
    	boolean data = loginPage.crmLogovalidation();
    	Assert.assertEquals(data, true);
     }
	@AfterMethod
	public void closeResources() {
		driver.close();
	}
}