package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;


public class AddCustomerTest {

	WebDriver driver;

	ExcelReader exlReader = new ExcelReader("testData\\TF_TestData.xlsx -Microsoft Excel.xlsx");
	String userName = exlReader.getCellData("LoginInfo", "UserName", 2);
	String password = exlReader.getCellData("LoginInfo", "Password",2);
	String name = exlReader.getCellData("AddContactInfo", "FullName", 2);
	String company = exlReader.getCellData("AddContactInfo", "company", 2);
	String email = exlReader.getCellData("AddContactInfo", "email", 2);
	String phoneNum = exlReader.getCellData("AddContactInfo", "phoneNum", 2);
	String address = exlReader.getCellData("AddContactInfo", "address", 2);
	String city = exlReader.getCellData("AddContactInfo", "city", 2);
	String state = exlReader.getCellData("AddContactInfo", "state", 2);
	String zip = exlReader.getCellData("AddContactInfo", "zip", 2  );
	String country = exlReader.getCellData("AddContactInfo", "country", 2);
	
	
	
	@Test
  public void userShouldBeAbleToCreateNewCustomer() throws InterruptedException {	

		driver = BrowserFactory.init();
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);

		login.enterUserName(userName);
		login.enterPassword(password);
		login.clickSigninButton();

		DashboardPage dashboard = PageFactory.initElements(driver, DashboardPage.class);
		dashboard.validateDashboar();

		AddCustomerPage addCustomer = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomer.clickOnCustomerButton();
		addCustomer.clickOnAddCustomerButton();
		addCustomer.enterName(name);

		addCustomer.enterCompanyName(company);
		addCustomer.enterEmail(email);
		addCustomer.enterPhoneNumber(phoneNum);
		addCustomer.enterAddress(address);
        addCustomer.enterCity(city);
        addCustomer.enterState(state);
        addCustomer.enterZip(zip);
        addCustomer.enterCountryName(country);
        addCustomer.clickSubmitButton();
        
        	
        Thread.sleep(5000);
        addCustomer.clickListCustomersButton();
        Thread.sleep(3000);
       addCustomer.verifyEnteredNameAndDelete();
        
        
		BrowserFactory.tearDown();

	}

}













