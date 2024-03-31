package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class Scenario3withDDT {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//Step1:Read the required Data
				/*Read data from property file*/
				
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
						
				Properties p=new Properties();
					
				p.load(fis);
						
				String URL=p.getProperty("url");
				String USERNAME=p.getProperty("username");
				
				String PASSWORD=p.getProperty("password");
				
				/*Read data from Excel file */
		FileInputStream fis1=new FileInputStream("E:\\Selenium-qspider\\TestData.xlsx");
				
				
				
				Workbook wb = WorkbookFactory.create(fis1);

				String LASTNAME = wb.getSheet("Contacts").getRow(4).getCell(2).getStringCellValue();
				String LEADSOURCEVALUE = wb.getSheet("Contacts").getRow(4).getCell(3).getStringCellValue();
                System.out.println(LEADSOURCEVALUE);
				
				//Test Script-vtiger
				//step 0:Launch the browser		
				WebDriver driver=new ChromeDriver();
				driver.get(URL);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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


			
					Thread.sleep(3000);
					WebElement dpdn = driver.findElement(By.xpath("//select[@name=\"leadsource\"]"));
					
					Select sel=new Select(dpdn);
					
					//sel.selectByVisibleText(LEADSOURCEVALUE);
					Thread.sleep(3000);
					sel.selectByValue(LEADSOURCEVALUE);   
					Thread.sleep(2000);
					driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
					Thread.sleep(2000);
					
//					
//					//
					String ctxt1=driver.findElement(By.id("mouseArea_Lead Source")).getText();		
					System.out.println(ctxt1);
//					
					if(ctxt1.contains("Partner"))
					{
						System.out.println("PASS DROP DOWN");
					}
					else
					{
						System.out.println("FAIL");
				}
	}

}
