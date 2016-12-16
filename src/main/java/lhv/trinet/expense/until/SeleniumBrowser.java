package lhv.trinet.expense.until;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import lhv.trinet.expense.page.HomePage;
import lhv.trinet.gmail.page.GmailLoginPage;

public class SeleniumBrowser {
   private WebDriver driver;
   
   public SeleniumBrowser(){}
   
   public HomePage goToExpensePage(){
//	   	  System.setProperty("webdriver.chrome.driver", "D:\\Soft\\Selenium_sever\\chromedriver.exe");
		  driver = new FirefoxDriver();
	   	  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.get("https://expense01.app7.com/");
	   return new HomePage(driver);
   }
   
   public GmailLoginPage goToGmailPage(){
	   	driver.navigate().to("https://mail.google.com/");
	   	return new GmailLoginPage(driver);
   }
   
   public WebDriver getWebDriver(){
	   return driver;
   }
   
   public void closeBrowser(){
	   driver.quit();
   }
}
