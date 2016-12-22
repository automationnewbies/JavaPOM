package lhv.trinet.expense.page;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import lhv.trinet.expense.component.Label;
import lhv.trinet.expense.component.Link;
import lhv.trinet.expense.component.Menu;

public class OverviewPage extends ExpensePage{


	private WebDriver driver;
	private final static String LOCATOR_USER_LOGGED ="xpath=//*[@id='subNav']//*[@class='email']";
//	private static final String LINK_EXPENSE_ACTIVE="xpath:=//a[@href='/expenses/active']";
	
	Label userLogged;
	Link link_ExpenseActive;
	Menu menu;
	
	public OverviewPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	} 

	public void userLoggedShouldBe(String userName)
	{
		userLogged = new Label(driver, LOCATOR_USER_LOGGED);
		Assert.assertEquals(userLogged.getText(), userName);
	}
	
	public ExpenseActivePage goToExpenseActivePage(){
		menu.selectMenu("Expenses");
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		try {
//			wait(5);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return new ExpenseActivePage(driver);
	}
}

