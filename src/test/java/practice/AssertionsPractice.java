package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
	
	@Test
	public void sample()
	{
		String a="hi";
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		
		Assert.assertEquals(1, 1); //pass  //2 arg-exp,act
		
		Assert.assertTrue(a.contains("i")); //condn
		
		System.out.println("Step4");
		System.out.println("Step5");
	}

	@Test
	public void sample1()
	{
		SoftAssert sa=new SoftAssert();
		String a="hi";
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		
		sa.assertEquals(0, 1); //pass  //2 arg-exp,act
		
		sa.assertTrue(a.contains("e")); //condn
		
		System.out.println("Step4");
		System.out.println("Step5");
		sa.assertAll();
	}

}
