package lhv.trinet.expense;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import lhv.trinet.expense.component.Menu;
import lhv.trinet.expense.page.HomePage;
import lhv.trinet.expense.page.LoginPage;
import lhv.trinet.expense.page.OverviewPage;
import lhv.trinet.expense.until.Account;
import lhv.trinet.expense.until.SeleniumBrowser;

public class TestCreateNewExpenseRecord {
	private SeleniumBrowser browser;
	private Account account;
	private HomePage expenseHomePage;
	private LoginPage loginPage;
	private OverviewPage overviewPage;
	private Menu menu;

	@BeforeClass
	public void beforeClass() {
		prepareData();
		browser = new SeleniumBrowser();
	}
	  /*
	   *  Login Expense
	   *  Goes to expense active page
	   *  Create new Basic expense 
	   */
	  @Test(priority=0)
	  public void createNewExpenseAccount() {
		  expenseHomePage = browser.goToExpensePage();
		  loginPage = expenseHomePage.goToExpenseLoginPage();
		  loginPage.loginExpense(account);
//		  overviewPage.selectExpenseMenu("Expenses");
		  menu.selectMenu("Expenses", "Deleted");
	  }

	private void prepareData() {
		account = new Account.Builder().email("se_companyowner@trinetqa.com").password("Lhvcreate@9").build();
	}
}
