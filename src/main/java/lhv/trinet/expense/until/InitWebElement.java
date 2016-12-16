package lhv.trinet.expense.until;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InitWebElement {
	private WebDriver driver;
	private String locator;
	private WebElement webElement;
	private By by;
	private static final String HIGHLIGHT_STYLE = "3px solid red";
	
	public InitWebElement(WebDriver driver, String locator)
	{
		this.driver = driver;
		this.locator = locator;
	}
	
	/*
	 * Return webElement through locator
	 */
	
	public WebElement defineWebElement()
	{
		by = defineLocator();
		webElement = driver.findElement(by);
		highlight();
		return webElement;
	}
	
	
	public WebElement defineWebElement(By by)
	{
		this.by = by;
		webElement = driver.findElement(by);
		highlight();
		return webElement;
	}
	
	/*
		Format of locator:
				css=.a
				xpath=//a[text=()]
				tag=button
		The first text: we define kind of locator that we want to capture
		The second text: The path of locator 		
	*/
	
	public By defineLocator()
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
			case "id":	by = By.id(newLocator);
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
	
	/*
	 * Set locator
	 */
	
	public void setLocator(String locator)
	{
		this.locator = locator;
	}
	
	public void highlight()
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].style.border='"+HIGHLIGHT_STYLE+"'", webElement);
		sleep(200);
		((JavascriptExecutor)driver).executeScript("arguments[0].style.border=''", webElement);
	}
	
  
	
    private void sleep(long time)
    {
    	try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}
