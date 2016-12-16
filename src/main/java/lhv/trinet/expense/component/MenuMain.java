//package lhv.trinet.expense.component;
//
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.WebDriver;
//
//import lhv.trinet.expense.until.WaitComponent;
//
//public class MenuMain extends WaitComponent {
//	private WebDriver driver;
//	Link link_menu;
//	private static String LINK_MAIN_MENU="xpath:=//*[@id='homeMenu']/ul/li/a[text()='%s']";
//	private static String LINK_SUB_MENU="xpath:=//*[@id='homeMenu']/ul/li/a[text()='%s']/following-sibling::ul/li/a[text()='%s']";
//	
//	Link link_MainMenu;
//	public MenuMain(WebDriver driver)
//	{
//		super(driver);
//		this.driver = driver;
//	}
//	
//	private void initMainMenu(String mainMenuName)
//	{
//		LINK_MAIN_MENU = String.format(LINK_MAIN_MENU, mainMenuName);
//		link_menu = new Link(driver, LINK_MAIN_MENU);
//	}
//	
//	private void initSubMenu(String mainMenuName, String subMenuName)
//	{
//		LINK_SUB_MENU = String.format(LINK_SUB_MENU, mainMenuName, subMenuName); 
//		link_menu = new Link(driver, LINK_SUB_MENU);
//	}
//	
//	public void clickMainMenu(String mainMenuName)
//	{
//		initMainMenu(mainMenuName);
//		link_menu.click();
//	}
//	
//	public void clickSubMenu(String mainMenuName, String subMenuName)
//	{
//		initSubMenu(mainMenuName, subMenuName);
//		link_menu.click();
//	}
//	
//	public void mouseOverMainMenu(String mainMenuName)
//	{
//		initMainMenu(mainMenuName);
//		link_menu.mouseOver();
//	}
//	
//	public void selectExpenseMenu(String mainMenuName)
//	{
//		clickMainMenu(mainMenuName);
//	}
//	
//	public void selectExpenseMenu(String mainMenuName, String subMenuName)
//	{
//		mouseOverMainMenu(mainMenuName);
//		sleep(5);
////		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		clickSubMenu(mainMenuName, subMenuName);
//	}
//	
//}
