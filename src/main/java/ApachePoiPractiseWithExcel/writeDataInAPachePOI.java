package ApachePoiPractiseWithExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writeDataInAPachePOI {

	public static String filePath = "C:\\Users\\admin\\Documents\\eclipse workspace2\\OrangeHrm\\src\\test\\resources\\TestPlan.xlsx";
	public static String sheetname= "Automation_QATestData";
	public static FileInputStream fis;
	public static FileOutputStream fout;
	public static XSSFWorkbook book ;
	public static void writeDataInSheet() {
		try {
	      fis= new FileInputStream(new File(filePath));
	      System.out.println("fis"+fis);
	      System.out.println("book ="+book);
	     book= new XSSFWorkbook(fis);
	     System.out.println("book ="+book);
	     book.createSheet(sheetname);
	     System.out.println("sheet created");
	      fout= new FileOutputStream(new File(filePath));
	     book.write(fout);
	     System.out.println("write int the book");
	     fis.close();
	     
	     
		}catch(Exception e) {
			System.out.println("error in writeDataInSheet"+e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		writeDataInSheet();

	}

}
