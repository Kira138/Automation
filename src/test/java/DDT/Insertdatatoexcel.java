package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Insertdatatoexcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\kiran\\Downloads\\ExcelData.xlsx");
		//Excelfile in read mode
		Workbook book=WorkbookFactory.create(fis);
		//getting control on sheet
		Sheet sheet=book.getSheet("Sheet1");
		//getting control on row number
		Row row=sheet.createRow(5);      //row number starts from zero
		//getting control on cell number
		Cell cel=row.createCell(5);      //cell number also starts from zero
		cel.setCellValue("Test");
		FileOutputStream fos=new FileOutputStream("C:\\Users\\kiran\\Downloads\\ExcelData.xlsx"); //write mode
		book.write(fos);
		book.close();
	}

}
