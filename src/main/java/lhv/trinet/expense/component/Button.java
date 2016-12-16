package lhv.trinet.expense.component;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class Button extends Component {

	public Button(WebDriver driver, String locator) {
		super(driver, locator);
		LOGGER.info("Click Button Locator >>> " + locator);
	}

	public Button(WebDriver driver) {
		super(driver);
	}

	public void clickButton() {
		waitUntilToBeClickAble();
		click();
		waitForPageLoad();
	}

	public void clickButtonWithOutWaitForPageLoad() {
		waitUntilToBeClickAble();
		click();
	}

	public void clickButtonCN() {
		try {
			waitUntilToBeClickAble();
			click();
			waitForPageLoad();
		} catch (TimeoutException ex) {
		}
	}
}
