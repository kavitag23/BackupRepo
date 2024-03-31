package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataPropertyFile {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		//step 1:open the document in Java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		
		//step 2:create an object of Properties class
		Properties p=new Properties();
		
		//step 3:load the file input stream to property 
		p.load(fis);
		
		//provide the key and read the value
		String URL=p.getProperty("username");
		
		System.out.println(URL);
	}

}
