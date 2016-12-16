package lhv.trinet.expense.until;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class WaitComponent {
	private By by;
	private WebDriver driver;
	private JavascriptExecutor js;
	public static WebDriverWait wait;
	private static final int TIMEOUT_INTERVAL_UNIT = 30;
	private WebElement ele;
	private Actions action;

	public WaitComponent(WebDriver driver) {
		this.driver = driver;
		initComponents();
	}

	public WaitComponent(WebDriver driver, By by) {
		this.driver = driver;
		this.by = by;
		initComponents();
	}

	public void mouseOver() {
		action.moveToElement(ele).build().perform();
	}
	
	
	public void sleep(int timeSleep){
		driver.manage().timeouts().implicitlyWait(timeSleep, TimeUnit.SECONDS);
	}
	
	private void initComponents() {
		wait = new WebDriverWait(driver, TIMEOUT_INTERVAL_UNIT);
	}

	public void waitUntilPresent() {
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public void waitUntilPresent(By by) {
		this.by = by;
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public void waitUntilVisibility() {
		waitUntilPresent();
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitUntilVisibility(By by) {
		waitUntilPresent(by);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitUntilEnable() {
		waitUntilVisibility();
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public void waitUntilEnable(By by) {
		waitUntilVisibility(by);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public void waitForPageLoad() {
		js = (JavascriptExecutor) driver;
		for (int i = 0; i < TIMEOUT_INTERVAL_UNIT; i++) {
			// To check page ready state.
			if (js.executeScript("return document.readyState").toString().equals("complete"))
				break;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}