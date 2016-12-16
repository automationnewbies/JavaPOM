package lhv.trinet.expense.component;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Component {
	private WebDriver driver;
	private String locator;
	private By by;
	private WebElement webElement;
	private static final String HIGHLIGHT_STYLE = "3px solid red";
	private WebDriverWait wait, wait1;
	private static final int TIMEOUT_INTERVAL_UNIT = 20;
	private JavascriptExecutor js;
	private Actions action;

	public static Logger LOGGER = Logger.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

	public Component(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, TIMEOUT_INTERVAL_UNIT);
	}

	public Component(WebDriver driver, String locator) {
		this.driver = driver;
		this.locator = locator;
		initComponents();
	}

	/*
	 * init components
	 */

	private void initComponents() {
		wait = new WebDriverWait(driver, TIMEOUT_INTERVAL_UNIT);
		by = getBy();
	}

	public By getBy() {
		if (locator.startsWith("xpath="))
			return By.xpath(locator.substring(6));
		else if (locator.startsWith("id="))
			return By.id(locator.substring(3));
		else if (locator.startsWith("name="))
			return By.name(locator.substring(5));
		else if (locator.startsWith("class="))
			return By.className(locator.substring(6));
		else if (locator.startsWith("link="))
			return By.linkText(locator.substring(5));
		else if (locator.startsWith("css="))
			return By.cssSelector(locator.substring(4));
		else if (locator.startsWith("tag="))
			return By.tagName(locator.substring(4));
		return by;
	}

	public By getBy(String locator) {
		if (locator.startsWith("xpath="))
			return By.xpath(locator.substring(6));
		else if (locator.startsWith("id="))
			return By.id(locator.substring(3));
		else if (locator.startsWith("name="))
			return By.name(locator.substring(5));
		else if (locator.startsWith("class="))
			return By.className(locator.substring(6));
		else if (locator.startsWith("link="))
			return By.linkText(locator.substring(5));
		else if (locator.startsWith("css="))
			return By.cssSelector(locator.substring(4));
		else if (locator.startsWith("tag="))
			return By.tagName(locator.substring(4));
		return by;
	}

	public WebElement getWebElement() {
		webElement = driver.findElement(by);
		highlight();
		return webElement;
	}

	public WebElement getWebElement(String locator) {
		by = getBy(locator);
		webElement = driver.findElement(by);
		highlight();
		return webElement;
	}

	public List<WebElement> getWebElements() {
		return driver.findElements(by);
	}
	/*
	 * Actions
	 */

	public void click() {
		getWebElement();
		LOGGER.info("Click Element Locator >>> " + locator);
		webElement.click();
	}

	public void mouseOver() {
		// if (webElement == null)
		getWebElement();
		action.moveToElement(webElement).build().perform();
	}

	public void click(String locator) {
		getWebElement(locator);
		webElement.click();
	}

	public String getText() {
		getWebElement();
		return webElement.getText();
	}

	public void getText(String locator) {
		getWebElement(locator);
		LOGGER.info("Get Text Locator >>> " + locator);
		webElement.getText();
	}

	public String getValue() {
		getWebElement();
		return webElement.getAttribute("value");
	}

	public void enter(String value) {
		getWebElement();
		webElement.clear();
		webElement.sendKeys(value);
	}

	public void enter(int value) {
		getWebElement();
		webElement.clear();
		webElement.sendKeys(String.valueOf(value));
	}

	public void pressKey(Keys key) {
		getWebElement();
		webElement.sendKeys(key);
	}

	public boolean isChecked() {
		getWebElement();
		return webElement.isSelected();
	}

	public int getSize() {
		return driver.findElements(by).size();
	}

	public boolean isPresent() {
		try {
			driver.findElement(by);
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

	public boolean isDisplay() {
		try {
			return driver.findElement(by).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/*
	 * Highlight to visual view
	 */

	private void highlight() {
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='" + HIGHLIGHT_STYLE + "'", webElement);
		sleep(160);
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border=''", webElement);
	}

	public void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Wait functions
	 */

	public void waitUntilPresent() {
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public void waitUntilVisibility() {
		waitUntilPresent();
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitUntilToBeClickAble() {
		waitUntilVisibility();
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public void waitUntilPresent(String locator) {
		getBy(locator);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public void waitUntilVisibility(String locator) {
		waitUntilPresent(locator);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitUntilToBeClickAble(String locator) {
		waitUntilVisibility(locator);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public void waitForExpectedValue(String value) {
		int loop = 20;
		for (int i = 0; i < loop; i++) {
			if (!webElement.getText().equals(value))
				sleep(500);
		}
	}

	public void waitForValueChange(String value) {
		getWebElement();
		for (int i = 0; i < TIMEOUT_INTERVAL_UNIT / 4; i++) {
			if (webElement.getText().equals(value))
				sleep(500);
		}
	}

	public void waitForValidNotNull() {
		getWebElement();
		for (int i = 0; i < TIMEOUT_INTERVAL_UNIT / 4; i++) {
			if ((webElement.getText() == null) || (!webElement.getText().equals("")))
				sleep(500);
		}
	}

	public void waitForUntilInvisibility() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(getBy()));
	}

	public void waitForUntilInvisibility(int timeout) {
		wait1 = new WebDriverWait(driver, timeout);
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(getBy()));
	}

	public void waitForPageLoad() {
		String script = "if (typeof window != 'undefined' && window.document) { return window.document.readyState; } else { return 'notready'; }";
		js = (JavascriptExecutor) driver;
		sleep(1000);
		for (int i = 0; i < TIMEOUT_INTERVAL_UNIT; i++) {
			// To check page ready state.
			if (js.executeScript(script).toString().equals("complete"))
				break;
			sleep(500);
		}
	}

	public String getLocator() {
		return locator;
	}

	public void setLocator(String locator) {
		this.locator = locator;
		by = getBy();
	}

	public String getLocatorWithoutPrefix() {
		String xpath = null;
		if (locator.startsWith("css="))
			xpath = locator.substring(4);
		else if (locator.startsWith("xpath="))
			xpath = locator.substring(6);
		return xpath;
	}

	public void scrollToElement() {
		webElement = driver.findElement(by);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
		sleep(100);
		highlight();
	}

	public void waitForURLChange(String url) {
		int loop = 0;
		while (url.equals(driver.getCurrentUrl()) && (loop < 20)) {
			loop++;
			sleep(500);
		}
	}

}
