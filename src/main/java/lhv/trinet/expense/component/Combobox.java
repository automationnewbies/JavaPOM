//package lhv.trinet.expense.component;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.Select;
//
//public class Combobox extends Component{
//	Select selectElement;
//	public Combobox(WebDriver driver, String locator)
//	{
//		super(driver, locator);
//	}
//	
//	public void initComponent(){
//		selectElement = new Select(getWebElement());
//	}
//	
//	public void selectItem(String value){
//		initComponent();
//		selectElement.selectByVisibleText(value);	
//	}
//	
//	public void selectValue(String value){
//		initComponent();
//		waitUntilToBeClickAble();
//		selectElement.selectByValue(value);
//	}
//	
//	public void selectIndex(int index){
//		initComponent();
//		selectElement.selectByIndex(index);
//	}
//	
//	public String getSelectedItem(){
//		initComponent();
//		return selectElement.getFirstSelectedOption().getText();
//	}
//}
