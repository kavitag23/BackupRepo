package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException ,IOException {
		// TODO Auto-generated method stub

		//1
		//FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		FileInputStream fis=new FileInputStream("E:\\Selenium-qspider\\TestData.xlsx");
		
		
		
Workbook wb = WorkbookFactory.create(fis);

Sheet sh = wb.getSheet("Contacts");

Row rw = sh.getRow(1);

Cell cl = rw.getCell(2);
String Value=cl.getStringCellValue();
System.out.println(Value);

wb.close();
	}

}
