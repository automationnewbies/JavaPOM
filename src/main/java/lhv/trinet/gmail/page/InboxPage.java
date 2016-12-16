package lhv.trinet.gmail.page;

import org.openqa.selenium.WebDriver;

import lhv.trinet.expense.component.Table;

public class InboxPage {
	private static final String locatorTable= "xpath:=//table[@class='F cf zt']/tbody";
	
	private Table inboxTable;
	private WebDriver driver;
	public InboxPage(WebDriver driver)
	{
		this.driver = driver;
		initComponents();
	}
		
	private void initComponents()
	{
		inboxTable = new Table(driver, locatorTable);
	}
	
	public boolean checkActivationMail(String title)
	{
		return inboxTable.isTableCellExist(title);
	}

	public ActivationPage openActivationMail(String title)
	{
		inboxTable.clickTableCell(title);
		return new ActivationPage(driver);
	}
}
