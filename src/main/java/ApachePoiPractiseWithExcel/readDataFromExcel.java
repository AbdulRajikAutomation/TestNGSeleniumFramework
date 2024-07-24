package ApachePoiPractiseWithExcel;

import java.io.File;
import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class readDataFromExcel {
	static String excelFilePath= System.getProperty("user.dir")+"\\src\\test\\resources\\TestPlan.xlsx";
	static FileInputStream fis;
	static XSSFWorkbook book;
	static XSSFSheet sheet ;
	static String log4jFilePAth="C:\\Users\\admin\\Documents\\eclipse workspace2\\OrangeHrm\\log4j.properties";
	static Logger log = Logger.getLogger(readDataFromExcel.class);
	public static void readDataFromTestPlanExcel() {
		try {
			PropertyConfigurator.configure(log4jFilePAth);
			int a = 90; // local variable
			log.info("a ="+a);
			fis = new FileInputStream(new File(excelFilePath));
			System.out.println("creating object for file input stream");
			log.debug("creating object for file input stream");
			
			 book = new XSSFWorkbook(fis);
			 System.out.println("creating work book object");
			  sheet = book.getSheet("Sheet1");
			 int rows = sheet.getLastRowNum();
			System.out.println("no of rows = "+(rows));
			
			// to get no of columns from each row
			for(int i=0;i<rows;i++) {
				short lstCellCount =	sheet.getRow(i).getLastCellNum();
				System.out.println("i ="+i);
				System.out.println("lstCellCount = "+lstCellCount);
				
			}
			// to get data from particular row and column
			String val = sheet.getRow(0).getCell(1).getStringCellValue();
			System.out.println("val = "+val);
			// to get all the data from multiple rows and columns
			String data ="";
			double d= 0.0;
			for(int i=0;i<rows;i++) {
				short noOfColumns = sheet.getRow(i).getLastCellNum();
				for(short s=0;s<noOfColumns;s++) {
					int t =sheet.getRow(i).getCell(s).getCellType();
					//System.out.println("t ="+t);
					if(t == 1) {
					 data= sheet.getRow(i).getCell(s).getStringCellValue();
					System.out.print(data+" ,");
					}
					
					if(t == 0) {
						d = sheet.getRow(i).getCell(s).getNumericCellValue();
						System.out.print(d);
					}
				}
				
				}
				System.out.println();
			
		}catch(Exception e) {
			log.error("error in the method"+e.getMessage());
			System.out.println("exception in method readDataFromTestPlanExcel "+e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(excelFilePath);
		readDataFromTestPlanExcel();

	}

}
