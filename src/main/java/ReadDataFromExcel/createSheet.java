package ReadDataFromExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class createSheet {
	static String ExcelPAth = "C:\\Users\\admin\\Documents\\eclipse workspace2\\OrangeHrm\\src\\test\\resources\\TestData.xlsx";
    static String sheetname = "qa test data";
    static FileInputStream fis ;
    static XSSFWorkbook book ;
    static FileOutputStream fout ;
    static XSSFSheet sheet2;
	public static void createNewQaSheet() {
		try {
			 fis = new FileInputStream(new File(ExcelPAth));
			 book = new XSSFWorkbook(fis);
			 fout = new FileOutputStream(new File(ExcelPAth));
			System.out.println("create book");
			Random ran = new Random();
			int v = ran.nextInt();
			System.out.println("v ="+v);
			System.out.println("sheet name="+sheetname+v);
			 sheet2 =	book.createSheet(sheetname+v);
			 book.removeSheetAt(0);
			System.out.println("sheet 2");
			book.write(fout);
			System.out.println("write into book");
			fis.close();
			System.out.println("closed fis");
		}catch(Exception e) {
			System.out.println("Error "+e.getMessage());
		}
	}
	static XSSFRow xrow;
	static XSSFCell xcell ;
	public static void writedataIntoExcel() {
		try {
			 fis = new FileInputStream(new File(ExcelPAth));
			 book = new XSSFWorkbook(fis);
			 fout = new FileOutputStream(new File(ExcelPAth));
			 sheet2 = book.getSheet("Sheet1");
			 for(int j=0;j<=7;j++) {
				 System.out.println("j ="+j);
			  xrow = sheet2.createRow(j);
			 for(int i=0;i<=5;i++) {

				  xcell = xrow.createCell(i); 
				  System.out.println("i ="+i);
					 xcell.setCellValue("selenium");
			 }
			 
			 }
			 sheet2.createRow(8).createCell(2).setCellValue("Automation testing");
			 book.write(fout);
			 fis.close();
		}catch(Exception e) {
			System.out.println("error in write");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createNewQaSheet();
		writedataIntoExcel();
	}

}
