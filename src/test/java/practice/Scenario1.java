package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Step 0:Launch the browser
WebDriver driver=new ChromeDriver();
driver.get("http://localhost:8888/index.php");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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
		
		
		//span[text()="[ CON3 ] chaitra  -  Contact Information"]
		Thread.sleep(2000);
		
	//String ctxt=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")")).getText();"
		
	String ctxt=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();		
			
	System.out.println(ctxt);
	
	if(ctxt.contains("chaitra"))
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
