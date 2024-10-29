package DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		//Step1:path connection
				FileInputStream fis=new FileInputStream("C:\\Users\\kiran\\Downloads\\TestData.xlsx");
				//Excelfile in read mode
				Workbook book=WorkbookFactory.create(fis);
				//getting control on sheet
				Sheet sheet=book.getSheet("Sheet1");
				//getting control on row number
				Row row=sheet.getRow(0);      //row number starts from zero
				//getting control on cell number
				Cell cel=row.getCell(0);      //cell number also starts from zero
				String excelData=cel.getStringCellValue();
				System.out.println(excelData);
	}

}
