package lhv.trinet.expense.page;

import org.openqa.selenium.WebDriver;

import lhv.trinet.expense.component.Menu;

public class ExpensePage extends Menu{
	private WebDriver driver; 
	
	public ExpensePage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}
	
	public ExpenseActivePage goToExpenseActivePage(){
		selectMenu("Expenses", "Active");
		return new ExpenseActivePage(driver);
	}
	
	public ExpenseReceiptPage goToExpenseReceiptPage(){
		selectMenu("Expenses");
		return new ExpenseReceiptPage(driver);
	}
}
