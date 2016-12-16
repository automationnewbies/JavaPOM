package lhv.trinet.expense.page;

import org.openqa.selenium.WebDriver;

import lhv.trinet.expense.component.Button;
import lhv.trinet.expense.component.InputText;
import lhv.trinet.expense.until.Account;

public class RegistryPage {
	private static final String locatorEmail="css:=#email";
	private static final String locatorPassword="css:=#password";
	private static final String locatorConfirmPassword="css:=#confirm-password";
	private static final String locatorCreateAccount="tag:=button";
	private InputText txt_email;
	private InputText txt_password;
	private InputText txt_confirmPassword;
	private Button btn_createAccount;
	private WebDriver driver;
	
	
	
	public RegistryPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private void fillIn(Account account)
	{
		txt_email = new InputText(driver, locatorEmail);
		txt_password = new InputText(driver, locatorPassword);
		txt_confirmPassword = new InputText(driver, locatorConfirmPassword);
		txt_email.enter(account.getEmail());
		txt_password.enter(account.getPassword());
		txt_confirmPassword.enter(account.getPassword());	
	}
	
	private void clickButtonCreateAccount(){
		btn_createAccount = new Button(driver, locatorCreateAccount);
		btn_createAccount.click();
		btn_createAccount.waitForPageLoad();
	}
	
	public LoginPage registryAnAccount(Account account)
	{
		fillIn(account);
		clickButtonCreateAccount();
		return new LoginPage(driver);
	}
}
