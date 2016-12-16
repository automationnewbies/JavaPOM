package lhv.trinet.expense.page;

import org.openqa.selenium.WebDriver;

import lhv.trinet.expense.component.Button;
import lhv.trinet.expense.component.InputText;
import lhv.trinet.expense.component.Label;
import lhv.trinet.expense.until.Account;

public class LoginPage {
	private static final String locatorActiveMessage ="xpath=//div/p[contains(text(),'activate')]";
	private static final String locatorEmail="id=email";
	private static final String locatorPassword="id=password";
	private static final String locatorLogin="tag=button";
	private InputText txt_email;
	private InputText txt_password;
	private Button btn_login;
	
	private Label activeMessage; 
	private WebDriver driver;
	
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private void fillIn(Account account)
	{
		txt_email = new InputText(driver, locatorEmail);
		txt_password = new InputText(driver, locatorPassword);
		txt_email.enter(account.getEmail());
		txt_password.enter(account.getPassword());
	}
	
	public String getActiveMessage(){
		activeMessage = new Label(driver,locatorActiveMessage);
		return activeMessage.getText();
	}
	
	private void clickButtonLogin(){
		btn_login = new Button(driver, locatorLogin);
		btn_login.click();
		btn_login.waitForPageLoad();
	}
	
	public OverviewPage loginExpense(Account account)
	{
		fillIn(account);
		clickButtonLogin();
		return new OverviewPage(driver);
	}
	
//	public void loginExpense(Account account)
//	{
//		fillIn(account);
//		clickButtonLogin();
//	}
}
