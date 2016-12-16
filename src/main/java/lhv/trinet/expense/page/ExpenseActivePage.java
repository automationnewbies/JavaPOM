package lhv.trinet.expense.page;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import lhv.trinet.expense.component.Label;

public class ExpenseActivePage {
	private WebDriver driver;
	private final static String LOCATOR_USER_LOGGED ="xpath:=.//*[@class='email']";
	
	private Label userLogged;
	public ExpenseActivePage(WebDriver driver)
	{
		this.driver = driver;
		initComponents();
	}
	
	private void initComponents()
	{
		userLogged = new Label(driver, LOCATOR_USER_LOGGED);
	}

	public void userLoggedShouldBe(String userName)
	{
		Assert.assertEquals(userLogged.getText(), userName);
	}
}

