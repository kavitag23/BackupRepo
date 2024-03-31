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
import org.openqa.selenium.support.ui.Select;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class Scenario3WithDDTandGU {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//Step1:Read the required Data
				/*Read data from property file*/
		

		//
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		SeleniumUtility sUtil=new SeleniumUtility();
		
		
		
String	URL=pUtil.readDataFromPropertyFile("url");
String	USERNAME=pUtil.readDataFromPropertyFile("username");
String	PASSWORD=pUtil.readDataFromPropertyFile("password");


String LASTNAME=eUtil.readDataFromExcelFile("contacts", 1, 2);

String LEADSOURCEVALUE = eUtil.readDataFromExcelFile("contacts", 4, 3);			
		
				
				/*Read data from Excel file */
		
                System.out.println(LEADSOURCEVALUE);
				
				//Test Script-vtiger
				//step 0:Launch the browser		
                WebDriver driver=new ChromeDriver();
                driver.get(URL);
                sUtil.maximizeWindow(driver);
                sUtil.addImplicitlywait(driver);

                
                //POM class implementation
				//1.Login to App  with valid credentials
                LoginPage lp=new LoginPage(driver);
                lp.loginToApp(USERNAME, PASSWORD);
                
				//2.Navigate to contacts link

                HomePage hm=new HomePage(driver);
                hm.clickContacts();  //contacts link


				//3.Click on create contact look up image

                ContactsPage cnt=new ContactsPage(driver);
                cnt.createLookUptClick(); //contact lookup image

				//4.Create contact with mandatory information
                
                CreateNewContactPage cntNew=new CreateNewContactPage(driver);
                cntNew.createNewContact(LASTNAME, LEADSOURCEVALUE);//create infor


			//5.
                ContactInfoPage info=new ContactInfoPage(driver);
    			String contactDpDntxt=info.captureDpDnText();	
    			
    	System.out.println(contactDpDntxt);
//					
//					
//					
					if(contactDpDntxt.contains("Partner"))
					{
						System.out.println("PASS DROP DOWN");
					}
					else
					{
						System.out.println("FAIL DROP DOWN");
				}
	}


}
