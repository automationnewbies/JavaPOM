package lhv.trinet.expense;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import lhv.trinet.expense.page.HomePage;
import lhv.trinet.expense.page.LoginPage;
import lhv.trinet.expense.page.RegistryPage;
import lhv.trinet.expense.until.Account;
import lhv.trinet.expense.until.SeleniumBrowser;
import lhv.trinet.expense.page.WelcomeToTrinetExpense;
import lhv.trinet.gmail.page.ActivationPage;
import lhv.trinet.gmail.page.InboxPage;
import lhv.trinet.gmail.page.GmailLoginPage;


public class TestCreateNewExpenseAccount {
  private SeleniumBrowser browser;
  private HomePage expenseHomePage;
  private RegistryPage userRegistry;
  private Account account,gmailAccout;
  private LoginPage loginPage;
  private GmailLoginPage gmailLoginPage;
  private InboxPage inboxPage;
  private ActivationPage activePage;
  private WelcomeToTrinetExpense welcomePage;
 
  private static final String messageActiveAccount = "Please check your email to activate your account.";
  
  @BeforeClass
  public void beforeClass() {
	  prepareData();
	  browser = new SeleniumBrowser();
	  
  }
  
  /*
   *  Go to expense page
   *  Launch RegistryPage
   *  Fill in an valid account
   *  
   */
  @Test(priority=0)
  public void createNewExpenseAccount() {
	  expenseHomePage = browser.goToExpensePage();
	  userRegistry = expenseHomePage.goToCreateNewAccountExpensePage();
	  loginPage = userRegistry.registryAnAccount(account);
  }
  
  @Test(dependsOnMethods ="createNewExpenseAccount")
  public void verifyCreateExpenseAccount() {
	  Assert.assertEquals(messageActiveAccount, loginPage.getActiveMessage());
  }
  
  @Test(dependsOnMethods ="verifyCreateExpenseAccount")
  public void checkActiveMail()
  {
	  gmailLoginPage = browser.goToGmailPage();
	  inboxPage = gmailLoginPage.signIn(gmailAccout);
	  activePage = inboxPage.openActivationMail("TriNet Expense");
	  welcomePage = activePage.activeAccount();
  }
  
  @AfterClass
  public void afterClass() {
	 browser.closeBrowser();
  }

  private void prepareData(){
	  account = new Account.Builder().email("hieunguyenduy699@gmail.com").password("abc12345678").build();  
	  gmailAccout = new Account.Builder().email("hieunguyenduy699@gmail.com").password("abc120885").build();
  }
}
