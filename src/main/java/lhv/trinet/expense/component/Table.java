package lhv.trinet.expense.component;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;

import lhv.trinet.expense.until.InitWebElement;
import lhv.trinet.expense.until.WaitComponent;

public class Table extends WaitComponent{
	private WebDriver driver;
	private String locator;
	private WebElement table;
	private By by;
	private InitWebElement init;
	public Table(WebDriver driver, String locator)
	{
		super(driver);
		this.driver = driver;
		this.locator = locator;	
		initComponent();
	}
	
	public void initComponent(){
		init = new InitWebElement(driver,locator);
		by = init.defineLocator();
		waitUntilPresent(by);
		table = init.defineWebElement(by);
	}
	
	public String getTableCellValue(int column, int row)
	{
		String cellValue=null;
		List<WebElement> rows=table.findElements(By.tagName("tr"));
		try{
			WebElement cell_row = rows.get(row-1);
			List<WebElement> columns=cell_row.findElements(By.tagName("td"));
			cellValue = columns.get(column-1).getText();
		}catch(NoSuchElementException ex)
		{
			ex.printStackTrace();
		}
		return cellValue;
	}
	
	// Return coulmn and row of selected cell
	
	public int[] getTableCellThroughtValue(String title)
	{
		int[] index = {-1,-1};
		int i=0;
		List<WebElement> rows=table.findElements(By.tagName("tr"));
		// Check table contains header or not
		List<WebElement> header=table.findElements(By.tagName("th"));
		if(header.isEmpty()==false)
			i=1;
		// Get all cells and find
		for (;i<rows.size();i++)
		{
			WebElement row = rows.get(i);
			List<WebElement> columns=row.findElements(By.tagName("td"));
			for(int t=0;t<columns.size();t++)
			{
				String th = columns.get(t).getText();
				if (columns.get(t).getText().equals(title))
				{
					index[0]=i+1;
					index[1]=t+1;
					return index;
				}
			}
		}
		return index;
	}

	public boolean isTableCellExist(String value)
	{
		int[] data = getTableCellThroughtValue(value);
		if(data[0]==-1)	return false;
		return true;
	}
	
	// Click table cell
	
	public void clickTableCell(String title)
	{
		int[] index = {-1,-1};
		int i=0;
		List<WebElement> rows=table.findElements(By.tagName("tr"));
		// Check table contains header or not
		List<WebElement> header=table.findElements(By.tagName("th"));
		if(header.isEmpty()==false)
			i=1;
		// Get all cells and find
		for (;i<rows.size();i++)
		{
			WebElement row = rows.get(i);
			List<WebElement> columns=row.findElements(By.tagName("td"));
			for(int t=0;t<columns.size();t++)
			{
				String th = columns.get(t).getText();
				if (columns.get(t).getText().equals(title))
				{
					row.click();
				}
			}
		}
	}

	// Return rows
	
	public int getRows(WebElement table)
	{
		return table.findElements(By.tagName("tr")).size();
	}
	
	// Return columns
	
	public int getColumns(WebElement table)
	{
		return table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("td")).size();
	}
	
	
}
