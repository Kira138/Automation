package DDT;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FetchingdatafromPDF {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File fis=new File("./src/test/resources/Anurag_Samak_Resume.pdf.pdf");
		PDDocument doc=PDDocument.load(fis);

		int pages=doc.getNumberOfPages();
		System.out.println(pages);

		PDFTextStripper pdfData=new PDFTextStripper();//PDFTextStripper is a class used to extract text from a PDF document.
		//String readDoc=pdfData.getText(doc);
		//System.out.println(readDoc);

		pdfData.setStartPage(5);//This tells the PDFTextStripper to begin extracting text from page 5 of the PDF document.
		//String readDoc=pdfData.getText(doc);
		//System.out.println(readDoc);

		pdfData.setStartPage(1);
		pdfData.setEndPage(3);//This tells PDFTextStripper to stop extracting text after page 4. So, the text will be extracted from pages 2, 3, and 4 (inclusive).
		String readDoc=pdfData.getText(doc);//The method getText(doc) reads the PDF (represented by doc, which is an instance of PDDocument) and extracts the text from the specified page range. The result is stored in the pageData1 variable as a String.
		System.out.println(readDoc);




	}

}
