package lhv.trinet.expense.component;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class Link extends Component{ 
	
	public Link(WebDriver driver, String locator)
	{
		super(driver, locator);
		LOGGER.info("Click Link Locator >>> " + locator);
	}
	
	public Link(WebDriver driver) {
		super(driver); 
	}
	
//	public void initComponent() { 
//		by = init.defineLocator();
//		waitUntilPresent(by);
//		link = init.defineWebElement(by);
//	}

	public void clickLink(){
		waitUntilToBeClickAble();
		click();
		waitForPageLoad();
	}
	
	public void clickLinkCN(){
		try{
			waitUntilToBeClickAble();
			click();
			waitForPageLoad();
		}catch(TimeoutException ex){}	
	}
	
	public void mouseOver(){
		waitUntilToBeClickAble();
		mouseOver();
	}
}

