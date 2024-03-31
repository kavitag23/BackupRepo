package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario2WithDDT {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		Properties p=new Properties();
			
		p.load(fis);
				
		String URL=p.getProperty("url");
		String USERNAME=p.getProperty("username");
		
		String PASSWORD=p.getProperty("password");
		
		/*Read data from Excel file */
FileInputStream fis1=new FileInputStream("E:\\Selenium-qspider\\TestData.xlsx");
		
		
		
		Workbook wb = WorkbookFactory.create(fis1);

		String LASTNAME = wb.getSheet("Contacts").getRow(7).getCell(2).getStringCellValue();
		String MODIFIFIEDLASTNAME = wb.getSheet("Contacts").getRow(7).getCell(3).getStringCellValue();

WebDriver driver=new ChromeDriver();
driver.get(URL);
driver.manage().window().maximize();
//1.Login to App  with valid credentials
driver.findElement(By.name("user_name")).sendKeys(USERNAME);//username field
driver.findElement(By.name("user_password")).sendKeys(PASSWORD);//password field

driver.findElement(By.id("submitButton")).click();//login button

//2.Navigate to contacts link

driver.findElement(By.linkText("Contacts")).click();//contacts link

//3.Click on create contact look up image

driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();//contact lookup image

//4.Create contact with mandatory information
driver.findElement(By.name("lastname")).sendKeys(LASTNAME);//create infor



//5.Verify for contact

		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
	
		
//7.Click on Edit button
		
		driver.findElement(By.name("Edit")).click();
		
		//8.Modify the data and click on save

		WebElement   ldata=driver.findElement(By.name("lastname"));
		ldata.clear();
		ldata.sendKeys(MODIFIFIEDLASTNAME );
		
				driver.findElement(By.xpath("(//input[@name=\"button\"])[1]")).click();
				
				//9.Verify the modified data 

				String ctxt=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();		
				
				System.out.println(ctxt);
				if(ctxt.contains(MODIFIFIEDLASTNAME ))
				{
					System.out.println("Pass");
				}
				else
				{
					System.out.println("Fail");
				}
			
				//close the browser
				//driver.quit();
				
	}

}
