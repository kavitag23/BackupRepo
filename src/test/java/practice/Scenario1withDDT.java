package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario1withDDT {

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

		String LASTNAME = wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();

		
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



		//5.Verify for contact

				driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
				
				
				//span[text()="[ CON3 ] chaitra  -  Contact Information"]
				Thread.sleep(2000);
				
			//String ctxt=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")")).getText();"
				
			String ctxt=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();		
					
			System.out.println(ctxt);
			
			if(ctxt.contains(LASTNAME))
			{
				System.out.println("PASS");
			}
			else
			{
				System.out.println("FAIL");
			}
			//6.Logout of App

			
			WebElement log=driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
			Actions act=new Actions(driver);
			act.moveToElement(log).perform();
				
			driver.findElement(By.linkText("Sign Out")).click();
			
			//close browser
			driver.quit();
			}

	}


