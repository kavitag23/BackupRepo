package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	//constructor
	public ContactInfoPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	//Elements
	@FindBy(className="dvHeaderText")
	private WebElement contactheaderTxt;

	//String ctxt1=driver.findElement(By.id("mouseArea_Lead Source")).getText();	
	@FindBy(id="mouseArea_Lead Source")
	private WebElement LeadSrcText;

	
	
	@FindBy(name="Edit")
	private WebElement EdtTxt;



	public WebElement getContactheaderTxt() {
		return contactheaderTxt;
	}
	
	public WebElement getLeadSrcText() {
		return LeadSrcText;
	}
	
	public WebElement getEdtTxt() {
		return EdtTxt;
	}

	
	//business library
	/*
	 * This method will  capture the  header text and return to the caller
	 */
	public String captureHeaderText()
	{
		return contactheaderTxt.getText();
	}
	
	/*
	 * This method will  capture the  drop down text and return to the caller
	 */
	public String captureDpDnText()   //scenario3-Leadscr
	{
		return LeadSrcText.getText();
	}
	
	
	public void clickOnEditBtn()
	{
		EdtTxt.click();
	}
}
