package contactsTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
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

@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateNewContactTest extends BaseClass{
	
	@Test(groups="SmokeSuite")
	public void createContactWithMandatoryfields() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

/* Read the data from Excel File */
String LASTNAME=eUtil.readDataFromExcelFile("contacts", 1, 2);



//2.Navigate to contacts link
HomePage hm=new HomePage(driver);
hm.clickContacts();  //contacts link


//3.Click on create contact look up image
ContactsPage cnt=new ContactsPage(driver);
cnt.createLookUptClick(); ////contact lookup image


//4.Create contact with mandatory information 
CreateNewContactPage cntNew=new CreateNewContactPage(driver);
cntNew.createNewContact(LASTNAME);

//for failure
//Assert.fail();


//5.Verify for contact

		ContactInfoPage info=new ContactInfoPage(driver);
			String contactHeadertxt=info.captureHeaderText();	
			
	
	
	//if(contactHeadertxt.contains(LASTNAME))
	
	
	Assert.assertTrue(contactHeadertxt.contains(LASTNAME));
	System.out.println(contactHeadertxt);
	

	}
	
	
	@Test
	public void Sample()
	{
		System.out.println("demo");
	}

	}


