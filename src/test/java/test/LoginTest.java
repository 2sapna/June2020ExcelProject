package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	
	WebDriver driver;
	
	ExcelReader exlReader = new ExcelReader ("testData\\TF_TestData.xlsx -Microsoft Excel.xlsx") ;
	String userName = exlReader.getCellData("LoginInfo", "UserName", 2);
	String password = exlReader.getCellData("LoginInfo", "Password", 2);
	
	@Test
	public void validUserShouldBeAbleTOLogin() {
		
		
		
	 driver =BrowserFactory.init();
	 LoginPage login = PageFactory.initElements(driver, LoginPage.class);
	 login.enterUserName(userName);
	login.enterPassword(password);
	login.clickSigninButton();	
		
		
	
	DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
	dashboard.validateDashboar();
	
	BrowserFactory.tearDown();
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
