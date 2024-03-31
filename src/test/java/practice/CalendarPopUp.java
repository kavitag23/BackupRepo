package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarPopUp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//span[text()=\"Departure\"]")).click();
		
		//String month=
		//case1
		//driver.findElement(By.xpath("//div[text()=\"April 2024\"]/ancestor::div[@class=\"DayPicker-Month\"]/descendant::p[text()=\"4\"]")).click();
		
		
		//case 2
		for(int i=0;i<4;i++)
		{
			
		driver.findElement(By.xpath("//span[@class=\"DayPicker-NavButton DayPicker-NavButton--next\"]")).click();
		Thread.sleep(2000);
		
				
		}
		//driver.findElement(By.xpath("))
		//div[text()="August 2024"]/ancestor::div[@class="DayPicker-Month"]/descendant::p[text()="9"]

	}
}


