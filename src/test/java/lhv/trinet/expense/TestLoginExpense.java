package lhv.trinet.expense;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import lhv.trinet.expense.page.HomePage;
import lhv.trinet.expense.page.LoginPage;
import lhv.trinet.expense.page.OverviewPage;
import lhv.trinet.expense.until.Account;
import lhv.trinet.expense.until.ConfReader;
import lhv.trinet.expense.until.SeleniumBrowser;

public class TestLoginExpense {
	private SeleniumBrowser browser;
	private ConfReader conf;
	private Account account;
	private HomePage expenseHomePage;
	private LoginPage loginPage;
	private OverviewPage overviewPage;

	@BeforeClass
	public void beforeClass() {
		prepareData();
		browser = new SeleniumBrowser();
	}
	  /*
	   *  Go to expense page
	   *  Launch LoginPage
	   *  Fill in an valid account
	   *  Click button Login
	   *  Verify user logged successfully
	   */
	  @Test(priority=0)
	  public void loginExistedExpenseAccount() {
		  expenseHomePage = browser.goToExpensePage();
		  loginPage = expenseHomePage.goToExpenseLoginPage();
		  overviewPage = loginPage.loginExpense(account);
		  
	  }
	  
	  @Test (dependsOnMethods = "loginExistedExpenseAccount")
	  public void verifyUserLoggedSuccessfully() {
		  overviewPage.userLoggedShouldBe(account.getEmail());
	  }
	  
	  @AfterClass
	  public void afterClass(){
		  browser.closeBrowser();
	  }

	private void prepareData() {
		conf = new ConfReader();
		account = new Account.Builder().email(conf.getPropValues("username")).password(conf.getPropValues("password")).build();
	}
}
