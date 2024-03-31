package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class Scenario1withDDTandGU {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		
		//
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		SeleniumUtility sUtil=new SeleniumUtility();
		
		
		
String	URL=pUtil.readDataFromPropertyFile("url");
String	USERNAME=pUtil.readDataFromPropertyFile("username");
String	PASSWORD=pUtil.readDataFromPropertyFile("password");


String LASTNAME=eUtil.readDataFromExcelFile("contacts", 1, 2);




//

//Test Script-vtiger
//step 0:Launch the browser		
WebDriver driver=new ChromeDriver();
driver.get(URL);
sUtil.maximizeWindow(driver);
sUtil.addImplicitlywait(driver);


//1.Login to App  with valid credentials
//driver.findElement(By.name("user_name")).sendKeys(USERNAME);//username field
//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);//password field
//
//driver.findElement(By.id("submitButton")).click();//login button


//
//LoginPage lp=new LoginPage(driver);
//lp.getUsernameEdt().sendKeys(USERNAME);
//lp.getPasswordEdt().sendKeys(PASSWORD);
//lp.getSubmitBtn().click();


//using Business Logic
LoginPage lp=new LoginPage(driver);
lp.loginToApp(USERNAME, PASSWORD);

//2.Navigate to contacts link
HomePage hm=new HomePage(driver);
hm.clickContacts();  //contacts link


//3.Click on create contact look up image
ContactsPage cnt=new ContactsPage(driver);
cnt.createLookUptClick();  ////contact lookup image


//4.Create contact with mandatory information 
CreateNewContactPage cntNew=new CreateNewContactPage(driver);
cntNew.createNewContact(LASTNAME);




//5.Verify for contact

		ContactInfoPage info=new ContactInfoPage(driver);
			String contactHeadertxt=info.captureHeaderText();	
			
	System.out.println(contactHeadertxt);
	
	if(contactHeadertxt.contains(LASTNAME))
	{
		System.out.println("PASS");
	}
	else
	{
		System.out.println("FAIL");
	}
	//6.Logout of App

	hm.logOutApp(driver);
	
//	WebElement log=driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
//	
//	sUtil.mouseHoverAction(driver, log);
//	
//	
//	driver.findElement(By.linkText("Sign Out")).click();
	
	//close browser
	driver.quit();



	}

}
