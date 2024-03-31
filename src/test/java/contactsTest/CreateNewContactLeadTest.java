package contactsTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateNewContactLeadTest extends BaseClass{


	@Test(groups="RegressionSuite")
	public void createContactWithLeadSrcValueDropDown() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//Step1:Read the required Data
				/*Read data from property file*/
		

		

/* Read data from Excel File */
String LASTNAME=eUtil.readDataFromExcelFile("contacts", 1, 2);

String LEADSOURCEVALUE = eUtil.readDataFromExcelFile("contacts", 4, 3);			
		
	                System.out.println(LEADSOURCEVALUE);
				
				//Test Script-vtiger
	                
				
                
                //POM class implementation
				
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
