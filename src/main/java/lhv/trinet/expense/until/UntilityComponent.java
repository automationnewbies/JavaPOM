package lhv.trinet.expense.until;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class UntilityComponent {
	private WebDriver driver;
	private By by;
	
	public UntilityComponent(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public boolean doesWebElementExit(String locator)
	{
		by = defineLocator(locator);
		{
			try{
				driver.findElement(by);
			}catch(NoSuchElementException ex)
			{
				return false;
			}
			return true;
		}
	}
	
	private By defineLocator(String locator)
	{
		String[] split = locator.split(":=");
		String newLocator = split[1];
		switch(split[0]){
			case "css":	by = By.cssSelector(newLocator);
				break;
			case "xpath":	by = By.xpath(newLocator);
				break;
			case "tag":		by = By.tagName(newLocator);
				break;
			case "name":	by = By.name(newLocator);
				break;
			default:
				try {
					throw new Exception("Please define kind of webElement locator" + newLocator);
				} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		return by;
	}
	
}
