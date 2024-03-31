package practice;

public class GenericMethodpractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a=20;
				int b=30;
		int c=a+b;
		
		int sum=add(19,40);
		System.out.println(sum);
		int data=sum+10;
		System.out.println(data);
		
		int diff=sub(30,45);
		System.out.println(diff);
		int sdata=diff-5;
		System.out.println(sdata);
		
		add(30,40);
		
		
	}
	//parameterization -inputs from caller 1
	public static int add(int a,int b) //called function generic methods
	{
		int c=a+b;
		return c;
	}
public static int sub(int a,int b)  //called function
{
//	int a=20;
//	int b=30;  hard coded
	int c=b-a;
	return c;
	
}

}
