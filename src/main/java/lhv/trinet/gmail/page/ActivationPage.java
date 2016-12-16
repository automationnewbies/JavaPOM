package lhv.trinet.gmail.page;

import org.openqa.selenium.WebDriver;

import lhv.trinet.expense.component.Link;
import lhv.trinet.expense.page.WelcomeToTrinetExpense;

public class ActivationPage {
	private static final String locatorActiveLink= "xpath:=//p[contains(text(),'To activate')]/a";
	private Link activationLink;
	private WebDriver driver;
	
	public ActivationPage(WebDriver driver){
		this.driver = driver;
	}
	
	public WelcomeToTrinetExpense activeAccount(){
		activationLink = new Link(driver, locatorActiveLink);
		activationLink.click();
		activationLink.waitForPageLoad();
		return new WelcomeToTrinetExpense(driver);
	}
}
