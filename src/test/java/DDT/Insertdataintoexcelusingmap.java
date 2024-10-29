package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Insertdataintoexcelusingmap {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("C:\\Users\\kiran\\Downloads\\Excel 2 (1).xlsx");

		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet2");

		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("10", "Banglore");
		map.put("20", "hyd");
		map.put("30", "Goa");
		map.put("40", "pune");

		int runNum = 0;
		for (Entry<String, String> m : map.entrySet()) {
			Row row = sheet.createRow(runNum++);
			row.createCell(0).setCellValue(m.getKey());// 10
			row.createCell(1).setCellValue(m.getValue());// Banglore

		}
		FileOutputStream fos = new FileOutputStream("C:\\Users\\kiran\\Downloads\\Excel 2 (1).xlsx");
		book.write(fos);
		book.close();
	}

}
