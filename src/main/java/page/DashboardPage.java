package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashboardPage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;

	}

	// ELEMENT LIBRARY

	@FindBy(how = How.XPATH, using = "//H2[contains(text(), 'Dashboard')]")
	WebElement DASHBOARD_VALIDATION_ELEMENT;

	// INTERACTIVE METHOD

	public void validateDashboar() {
		String dashBoardText = DASHBOARD_VALIDATION_ELEMENT.getText();
		Assert.assertEquals(DASHBOARD_VALIDATION_ELEMENT.getText(), "Dashboard", "Wrong page");
		
		
		

	}

}
