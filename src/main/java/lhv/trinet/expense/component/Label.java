package lhv.trinet.expense.component;

import org.openqa.selenium.WebDriver;

public class Label extends Component{
	
	public Label(WebDriver driver, String locator){
		super(driver, locator);
		LOGGER.info("Label Locator >>> " + locator);
	}

	public Label(WebDriver driver) {
		super(driver);
	}
	
//	public String getText(){
//		waitUntilVisibility();
//		return getText();
//	}
}
