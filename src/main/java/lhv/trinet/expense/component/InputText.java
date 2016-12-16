package lhv.trinet.expense.component;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class InputText extends Component{
	public InputText(WebDriver driver, String locator)
	{
		super(driver, locator);
		LOGGER.info("Input Text To Locator >>> " + locator);
	}
	
	public InputText(WebDriver driver)
	{
		super(driver);
	}
	
	public void enterValue(String value){
		waitUntilToBeClickAble();
		if(value!=null)
			enter(value);
	}
	
	public void pressEnter(){
		pressKey(Keys.ENTER);
		waitForPageLoad();
	}

	public void enterValue(int value) {
			enter(value);
	}
}
