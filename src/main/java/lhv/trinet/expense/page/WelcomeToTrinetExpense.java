package lhv.trinet.expense.page;

import org.openqa.selenium.WebDriver;

import lhv.trinet.expense.component.Button;
import lhv.trinet.expense.component.Label;

public class WelcomeToTrinetExpense {
	private WebDriver driver;
	private final static String locatorSuccessfulLabel ="xpath:=//li[@class='notification']/span[contains(text(),'Thanks for signing')]";
	private final static String locatorCancelButton = "css:=#btnCancel";
	
	private Label successfulLabel;
	private Button btnCancel;
	public WelcomeToTrinetExpense(WebDriver driver)
	{
		this.driver = driver;
		initComponents();
	}
	
	private void initComponents()
	{
		successfulLabel = new Label(driver, locatorSuccessfulLabel);
		btnCancel = new Button(driver, locatorCancelButton);
	}

	public String getSuccessfulMessage()
	{
		return successfulLabel.getText();
	}
}

