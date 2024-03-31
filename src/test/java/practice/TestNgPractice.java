package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgPractice {
	
	@Test(invocationCount=3)
	public void createCustomer()
	{
		Assert.fail();
		System.out.println("create");
	}
	
	@Test(priority=1)
	public void modifyCustomer()
	{
		System.out.println("modify");
	}
	
	@Test(enabled=false)

	public void deleteCustomer()
	{
		System.out.println("delete");
	}
	
	
	@Test(dependsOnMethods ="createCustomer")
	public void modifyCustomer1()
	{
		System.out.println("modify1");
	}
}
