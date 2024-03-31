package genericUtilities;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

/*
 * This class consists of basic configuration annotations of TestNG
 */


public class BaseClass {

	//create object of all utility classes
		public	PropertyFileUtility pUtil=new PropertyFileUtility();
		public	ExcelFileUtility eUtil=new ExcelFileUtility();
		public 	SeleniumUtility sUtil=new SeleniumUtility();
		public WebDriver driver;
		
		//For listeners
		public static WebDriver sDriver;
	
	@BeforeSuite(groups={"SmokeSuite","RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("====DB Connection Successful=====");   //in vtiger app we are not using DB connection.so just print stmt
	}
	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(alwaysRun=true)
	
	//public void bcConfig(String BROWSER) throws IOException---for parameterisation
	
	public void bcConfig() throws IOException
	{
		String URL=pUtil.readDataFromPropertyFile("url");
		
//		if(BROWSER.equals("chrome"))
//		{
//		driver=new ChromeDriver();
//		}
//		
//		else if(BROWSER.equals("edge"))
//		{
//			driver=new EdgeDriver();
//		}
//		else
//		{
//			driver=new ChromeDriver();
//		}
		driver=new ChromeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlywait(driver);
		
		driver.get(URL);
		
		//For listeners
		sDriver=driver;
		
		System.out.println("====Browser Launch Successful===");
		
	}
	
	@BeforeMethod(alwaysRun=true)
	public void bmConfig() throws IOException
	{
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("====Login To App Successful=====");
		
	}
	
	
	
	@AfterMethod(alwaysRun=true)
	public void amConfig() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		hp.logOutApp(driver);
		
		System.out.println("======Log Out of App Successful======");
	}
	
	//@AfterTest
	@AfterClass(alwaysRun=true)
	public void acConfig()
	{
		driver.quit();
		
		System.out.println("=====Browser closure successful====");
	}
	
	
	@AfterSuite(alwaysRun=true)
	public void asConfig()
	{
		System.out.println("====DB closure successful====");
	}
	
	
}
