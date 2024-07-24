package ReadDataFromExcel;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.sl.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellType;

public class readDataUsingPOI {
	private static final int STRING = 0;
	private static final int NUMERIC = 0;
	static String ExcelPAth = "C:\\Users\\admin\\Documents\\eclipse workspace2\\OrangeHrm\\src\\test\\resources\\TestData.xlsx";

	public static void readData() {
		try {
			FileInputStream fis = new FileInputStream(new File(ExcelPAth));
			XSSFWorkbook book = new XSSFWorkbook(fis);
//			XSSFSheet sheet23 = book.createSheet("Test qa2 data");)
	        XSSFSheet sheet = book.getSheet("Sheet1");
	       int rowCount =  sheet.getLastRowNum();
	       System.out.println("rowCount = "+rowCount);
	       for(int i=0;i<=rowCount;i++) {
	    	short cellVal =    sheet.getRow(i).getLastCellNum();
	    	
	    	System.out.println("cellVal ="+cellVal);
	    	for(short s = 0;s<cellVal;s++) {
	    		int type = sheet.getRow(i).getCell(s).getCellType();
	    		System.out.println("cell type = "+type);
	    		if(type == 1) {
	    		String v23 = sheet.getRow(i).getCell(s).getStringCellValue();
	    	 System.out.println("v23 = "+v23);
	    		}
	    		if(type == 0){
	    			double d= sheet.getRow(i).getCell(s).getNumericCellValue();
	    		    System.out.println("d = "+d);
	    		}
	    	}
	       }
		}catch(Exception e) {
			System.out.println("error in read data"+e.getMessage());
		}
	}
	
	
	public static void writeDataIntoExcel() {
		try {
			
		}catch(Exception e) {
			System.out.println("error in write data");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readData();
		
	}

}
