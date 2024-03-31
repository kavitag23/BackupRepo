package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class HomePage extends SeleniumUtility{
	
	
	
public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	PageFactory.initElements(driver, this);
	
	}

@FindBy(linkText = "Contacts")
private WebElement contactlnk;

@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
private WebElement administlnk;

@FindBy(linkText = "Sign Out")
private WebElement signOutlnk;

@FindBy(linkText = "Products")
private WebElement productslnk;


@FindBy(linkText = "Campaigns")
private WebElement campaignslnk;


@FindBy(linkText = "Leads")
private WebElement leadslnk;


public WebElement getCampaignslnk() {
	return campaignslnk;
}



public WebElement getContactlnk() {
	return contactlnk;
}




public WebElement getAdministlnk() {
	return administlnk;
}




public WebElement getSignOutlnk() {
	return signOutlnk;
}




public WebElement getProductslnk() {
	return productslnk;
}




public WebElement getLeadslnk() {
	return leadslnk;
}

/*
 * This method will perform Contacts click
 */

public void clickContacts()
{
	contactlnk.click();
}
/*
 * This method will perform log out operati
 */

public void logOutApp(WebDriver driver) throws InterruptedException
{
	mouseHoverAction(driver, administlnk);
	Thread.sleep(1000);
	signOutlnk.click();
}
}
