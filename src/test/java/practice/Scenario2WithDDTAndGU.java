package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class Scenario2WithDDTAndGU {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		//Create object of All Utility classes
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		SeleniumUtility sUtil=new SeleniumUtility();
		
		
		//Read data from Property File
	String URL=	pUtil.readDataFromPropertyFile("url");
		
	String USERNAME=pUtil.readDataFromPropertyFile("username");	
		
	String PASSWORD=pUtil.readDataFromPropertyFile("password");
		
		

		/*Read data from Excel file */
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 7, 2);
		String MODIFIFIEDLASTNAME = eUtil.readDataFromExcelFile("Contacts", 7, 3);
		
		
//Launch the browser
WebDriver driver=new ChromeDriver();
driver.get(URL);
sUtil.addImplicitlywait(driver);


//1.Login to Application  

LoginPage lp=new LoginPage(driver);
lp.loginToApp(USERNAME, PASSWORD);

//driver.findElement(By.id("submitButton")).click();//login button


//2.Navigate to contacts link
HomePage hm=new HomePage(driver);
hm.clickContacts(); //contacts link

//3.Click on create contact look up image

ContactsPage cnt=new ContactsPage(driver);
cnt.createLookUptClick();//contact lookup image

//4.Create contact with mandatory information

CreateNewContactPage cntNew=new CreateNewContactPage(driver);
cntNew.createNewContact(LASTNAME);

//create infor



//5.Verify for contact


	
		
//7.Click on Edit button
		
driver.findElement(By.name("Edit")).click();
		
//8.Modify the data and click on save
WebElement   ldata=driver.findElement(By.name("lastname"));
ldata.clear();
ldata.sendKeys(MODIFIFIEDLASTNAME );

driver.findElement(By.xpath("(//input[@name=\"button\"])[1]")).click();

//driver.findElement(By.xpath("//td[text()=\"Last Name						\"]/following-sibling::td[@class=\"dvtCellInfo\"]/child::input[@name=\"lastname\"]")).click();
				
//9.Verify the modified data 
String Apptxt=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();		
				
System.out.println(Apptxt);

				if(Apptxt.contains(MODIFIFIEDLASTNAME ))
				{
					System.out.println("PASS");
				}
				else
				{
					System.out.println("FAIL");
				}
			
				//6.Logout of App

				
				WebElement log=driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
				sUtil.mouseHoverAction(driver, log);
				
				
				driver.findElement(By.linkText("Sign Out")).click();
				
				//close browser
				driver.quit();
	}

}
