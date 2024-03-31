package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	
	public ContactsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@title=\"Create Contact...\"]")
	private WebElement createContImg;

	public WebElement getCreateContImg() {
		return createContImg;
	}
	
	
	/*
	@FindBy(cssSelector="[title=\"Create Contact...\"]")
	private WebElement createContImg;*/
	
	/*
	 * This method will click on create contact loop Image button
	 */
	public void createLookUptClick()
	{
		createContImg.click();
	}
	
}
