package genericUtilities;

import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/*
 * This clas consists of generic method related to webpage
 */
public class SeleniumUtility {
/*
 * This method will maximize the window
 */
	public void maximizeWindow(WebDriver driver)
	{
	
	driver.manage().window().maximize();
	
	}
	
	/*
	 * This method will minimise the window
	 */
	public void minimiseWindow(WebDriver driver)
	{
	
	driver.manage().window().minimize();
	
	}
	
	/*
	 * This method will add 10 seconds of implicitly wait
	 */
	public void addImplicitlywait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/*
	 * This method will wait for 10 seconds for a webelement to be visible
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/*
	 * This method will wait for 10 seconds for a webelement to be clickable
	 */
	
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	/*
	 * This method will wait for 10 seconds for a Alert  to be Present
	 */
	
	public void waitForAlertToBePesent(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
	}
	
	
	public void waitForPageTitle(WebDriver driver,String title)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleIs(title));
		
	}
	
	/*
	 * This method will handle drop down by index
	 */
	
	public void handledropdown(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	
	/*
	 * This method will handle drop down by value--
	 * overloading concept example-same method no.of args same but different data type 
	 */
	
	public void handledropdown(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	
	
	
	/*
	 * This method will handle drop down by visible text
	 */
	
	public void handledropdown(String text,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/*
	 * This method will perform mouse Hover action
	 */
	
	public void mouseHoverAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();;
	}
	
	
	/*
	 * This method will perform move by offset
	 */
	
	public void moveByOffsetAction(WebDriver driver,int x,int y)
	{
		Actions act=new Actions(driver);
		act.moveByOffset(x, y).perform();;
	}
	/*
	 * This method will perform drag and drop action
	 */
	
	public void dragdropAction(WebDriver driver,WebElement src,WebElement dest)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(src, dest).perform();;
	}
	
	

	/*
	 * This method will perform right click on web page
	 */
	
	public void rightClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();;
	}
	

	/*
	 * This method will perform right click on element 
	 */
	
	public void rightClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();;
	}
	
	/*
	 * This method will perform double click on web page 
	 */
	
	public void doubleClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();;
	}
	
	
	/*
	 * This method will perform double click on element 
	 */
	
	public void doubleClickAction(WebDriver driver,WebElement dest)
	{
		Actions act=new Actions(driver);
		act.doubleClick(dest).perform();;
	}
	
	/*
	 * This method will perform scroll down by 500 units
	 * @param driver
	 */
	
	
	public void scrollDownAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("Window.scrollBy(0,500);","");
	}
	
	/*
	 * This method will perform scroll up by 500 units
	 * @param driver
	 */
	
	
	public void scrollUpAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("Window.scrollBy(0,-500);","");
	}
	
	
	public void scrollHandleCompleteDown(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("Window.scrollTo(0,document.body.scrollHeight)");
	}
	
	/*
	 * This method will scroll  to  a particular element
	 * @param diver
	 * @param element
	 */
	
	public void scrollToElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.scrollToElement(element).perform();
		
	}
	
	/*
	 * This method will handle frame using index
	 */
	
	public void framehandling(WebDriver driver,int index)
	{
		
		driver.switchTo().frame(index);
	}
	
	
	/*
	 * This method will handle frame using name or ID
	 */
	public void framehandling(WebDriver driver,String nameOrID )
	{
		
		driver.switchTo().frame(nameOrID);
	}
	
	/*
	 * This method will handle frame using webelement
	 */
	public void framehandling(WebDriver driver,WebElement element )
	{
	
		driver.switchTo().frame(element);
	}
	
	/*
	 * This method will switch to main page from frame
	 */
	
	public void defaultContentSwitching(WebDriver driver )
	{
	
		
		driver.switchTo().defaultContent();
	}
	
	
	/*
	 * This method will switch to parent frame from child frame
	 */
	
	public void parentframeSwitching(WebDriver driver )
	{
	
		
		driver.switchTo().parentFrame();
	}
	
	/*
	 * This method will accept the alert popup 
	 * @param driver
	 */
	
	public void acceptAlert(WebDriver driver)
	{
		 driver.switchTo().alert().accept();
		
	}
	
	
	/*
	 * This method will cancel the alert popup 
	 * @param driver
	 */
	
	public void cancelAlert(WebDriver driver)
	{
		 driver.switchTo().alert().dismiss();;
		
	}
	
	/*
	 * This method  enters the text into alert popup
	 * @param driver
	 */
	
	public void enterTextAlert(WebDriver driver,String txt)
	{
		 driver.switchTo().alert().sendKeys(txt);;
		
	}
	
	/*
	 * This method will capture  the alert text and return it to caller
	 */
	
	public String getAlertText(WebDriver driver)
	{
		
		
		return driver.switchTo().alert().getText();
		
	}
	
	/*
	 * This method will capture the screenshot and return the path to the caller
	 */
	
	public String captureScreenshot(WebDriver driver,String Screenshotname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst=new File(".\\Screenshot\\"+Screenshotname+".png");
		
		Files.copy(src, dst);
		
		return dst.getAbsolutePath(); // used for extent reports
		
		//dst.getPath()----use this if complete path given
	}
	
	public void closeBrowser(WebDriver  driver)
	{
		driver.close();
		
	}
	
	
	
}
