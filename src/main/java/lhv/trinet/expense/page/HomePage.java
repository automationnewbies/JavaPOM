package lhv.trinet.expense.page;

import org.openqa.selenium.WebDriver;

import lhv.trinet.expense.component.Link;

public class HomePage {
	private WebDriver driver;
	Link link_SignUp;
	
	private static final String LINK_SIGNUP="xpath=//a[text()='Sign Up']";
	private static final String LINK_LOGIN="xpath=//a[text()='Login']";
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public RegistryPage goToCreateNewAccountExpensePage(){
		link_SignUp = new Link(driver,LINK_SIGNUP);
		link_SignUp.click();
		return new RegistryPage(driver);
	}
	
	public LoginPage goToExpenseLoginPage(){
		link_SignUp = new Link(driver,LINK_LOGIN);
		link_SignUp.click();
		return new LoginPage(driver);
	}
}
