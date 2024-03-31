package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario2 {
//Edit Contact
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/index.php");
		driver.manage().window().maximize();
		//1.Login to App  with valid credentials
		driver.findElement(By.name("user_name")).sendKeys("admin");//username field
		driver.findElement(By.name("user_password")).sendKeys("admin");//password field

		driver.findElement(By.id("submitButton")).click();//login button

		//2.Navigate to contacts link

		driver.findElement(By.linkText("Contacts")).click();//contacts link

		//3.Click on create contact look up image

		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();//contact lookup image

		//4.Create contact with mandatory information
		driver.findElement(By.name("lastname")).sendKeys("chaitra");//create infor



		//5.Verify for contact

				driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
			
				
		//7.Click on Edit button
				
				driver.findElement(By.name("Edit")).click();
				
				//8.Modify the data and click on save

				WebElement   ldata=driver.findElement(By.name("lastname"));
				ldata.clear();
				ldata.sendKeys("chaitra1");
				
						driver.findElement(By.xpath("(//input[@name=\"button\"])[1]")).click();
						
						//9.Verify the modified data 

						String ctxt=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();		
						
						System.out.println(ctxt);
						if(ctxt.contains("chaitra1"))
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
