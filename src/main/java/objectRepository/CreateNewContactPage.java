package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class CreateNewContactPage extends SeleniumUtility{

	public CreateNewContactPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement lasNameEdt;
	
	@FindBy(name="button")
	private WebElement saveBtn;

	public WebElement getLasNameEdt() {
		return lasNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//leadsource
	@FindBy(name="leadsource")
	private WebElement leadSrcDp;

	public WebElement getLeadSrcDp() {
		return leadSrcDp;
	}
	
	
	//business library
	
	/*
	 * This method will create new contact 
	 */
	public void createNewContact(String lastname)    //overloading concept used
	{
		lasNameEdt.sendKeys(lastname);
		saveBtn.click();
	}
	

	/*
	 * This method will create new contact with lead source drop down
	 */
	public void createNewContact(String lastname,String leadSourceValue)
	{
		lasNameEdt.sendKeys(lastname);
		handledropdown(leadSrcDp, leadSourceValue);
		saveBtn.click();
	}
	
	
	
}
