package lhv.trinet.expense.component;

import org.openqa.selenium.WebDriver;

public class Menu extends Component {
	private static String MAIN_MENU = "xpath:=//*[@id='homeMenu']/ul/li/a[text()='%1$s']";
	private static String SUB_MENU = MAIN_MENU + "/following-sibling::ul/li/a[text()='%1$s']";
	private WebDriver driver;
	private Link menu;

//	public Menu(WebDriver driver) {
//		super(driver, locator);
//		this.driver = driver;
//	}

	public Menu(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private void initMenu(String mainMenu) {
		menu = new Link(driver, String.format(MAIN_MENU, mainMenu));
		menu.mouseOver();
	}

	private void initMenu(String mainMenu, String subMenu) {
		menu = new Link(driver, String.format(SUB_MENU, mainMenu, subMenu));
		menu.mouseOver();
	}

	public void selectMenu(String mainMenu) {
		initMenu(mainMenu);
		menu.click();
	}

	public void selectMenu(String mainMenu, String subMenu) {
		initMenu(mainMenu, subMenu);
		menu.click();
	}
}
