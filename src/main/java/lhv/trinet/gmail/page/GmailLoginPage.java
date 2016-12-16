package lhv.trinet.gmail.page;

import org.openqa.selenium.WebDriver;

import lhv.trinet.expense.component.Button;
import lhv.trinet.expense.component.InputText;
import lhv.trinet.expense.component.Link;
import lhv.trinet.expense.until.Account;
import lhv.trinet.expense.until.UntilityComponent;

public class GmailLoginPage {
	private static final String locatorEmail="css:=#Email";
	private static final String locatorPassword="css:=#Passwd";
	private static final String locatorSignIn = "xpath:=.//input[@id='signIn']";
	private static final String locatorNext = "xpath:=.//input[@id='next']";
	private static final String locatorDifferentAccount = "xpath:=.//*[@id='account-chooser-link']";
	private static final String locatorAddAnotherAccount = "xpath:=.//*[@id='account-chooser-add-account']";
	
	private InputText email;
	private InputText password;
	private Button signIn;
	private Button next;
	private Link differentLink;
	private Link addAnotherAccount;
	private WebDriver driver;
	
	private UntilityComponent checkTool;
	
	public GmailLoginPage(WebDriver driver)
	{
		this.driver = driver;
		initComponents();
	}
	
	
	private void initComponents(){
		checkTool = new UntilityComponent(driver);
	}
	/* 
	 * Step#1: check differentLink exist? click:enter email
	 * enter email
	 * click on Next button
	 * enter password
	 * click on SignIn
	 */
	
	public InboxPage signIn(Account account)
	{
		email = new InputText(driver,locatorEmail);
		next = new Button(driver,locatorNext);
		email.enter(account.getEmail());
		next.click();
		password = new InputText(driver,locatorPassword);
		signIn = new Button(driver,locatorSignIn);
		password.enter(account.getPassword());
		signIn.click();
		signIn.waitForPageLoad();
		return new InboxPage(driver);
	}
	
	
}
