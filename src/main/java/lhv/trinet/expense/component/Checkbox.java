//package lhv.trinet.expense.component;
//
//import org.openqa.selenium.WebDriver;
//
//public class Checkbox extends Component{
//	public Checkbox(WebDriver driver, String locator)
//	{
//		super(driver, locator);
//	}
//	
//	public void set(boolean value)
//	{
//		waitUntilToBeClickAble(getLocator());
//		if (value && !this.isChecked())
//			click();
//		else if (!value && this.isChecked())
//			click();
//	}
//	
//	public void set(String value)
//	{
//		waitUntilToBeClickAble(getLocator());
//		if (value.equals("unchecked") && this.isChecked())
//			click();
//		else if (value.equals("checked") && !this.isChecked())
//			click();
//		waitUntilToBeClickAble();
//	}
//}
