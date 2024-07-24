package ReadDataFromExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class insertDatainCell {
	static String ExcelPAth = "C:\\Users\\admin\\Documents\\eclipse workspace2\\OrangeHrm\\src\\test\\resources\\TestData.xlsx";
	static FileInputStream fis ;
	static XSSFWorkbook book ;
	static FileOutputStream fout;
	static XSSFSheet sheet;
	public static void insertIntoCell() {
		try {
			 fis = new FileInputStream(new File(ExcelPAth));
			 book = new XSSFWorkbook(fis);
			  sheet =  book.getSheet("Sheet1");
			  Row r ;
			  r = sheet.createRow(0);
			  r.createCell(0).setCellValue("selenium");

			 fout = new FileOutputStream(new File(ExcelPAth));
			 book.write(fout);
			 System.out.println("write into ook");
		}catch(Exception e) {
			System.out.println("error in "+e.getMessage());
		}
	}
	
	public static void insertDataIntoMultipleCells() {
		try {
			 fis = new FileInputStream(new File(ExcelPAth));
			 book = new XSSFWorkbook(fis);
			  sheet =  book.getSheet("Sheet1");
			  Row r ;
			  for(int i=1;i<3;i++) {
					r =  sheet.createRow(i);
					for(int j = 0;j<=5;j++) {
						r.createCell(j).setCellValue("online java selenium training");
						System.out.println("setting cell value");	
					}
				  }
			 fout = new FileOutputStream(new File(ExcelPAth));
			 book.write(fout);
			 System.out.println("write into ook");
		}catch(Exception e) {
			System.out.println("error in insertDataIntoMultipleCells"+e.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		insertIntoCell();
		insertDataIntoMultipleCells();
	}

}
