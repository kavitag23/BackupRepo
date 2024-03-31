package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to Excel file
 * @author Yeshwant
 *
 */
public class ExcelFileUtility {

	/**
	 * This method will read data from  excel file and return the value to the caller
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readDataFromExcelFile(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("E:\\\\Selenium-qspider\\\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
	  String value=wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
	  return value;
		
	}
}
