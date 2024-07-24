package fileUploadExample;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class fileUploadPractise {
	
	public static WebDriver driver;
	static String chromePath = "C:\\Users\\admin\\Documents\\eclipse workspace2\\OrangeHrm\\src\\main\\resources\\driverDependency\\chromedriver.exe";
	static String heroKuappUrl = "https://the-internet.herokuapp.com/";
	public static void launchChrome() {
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.get(heroKuappUrl);
		System.out.println("launch heroKuappUrl");
		driver.manage().window().maximize();
		System.out.println("maximize the browser");
		
	}
	
	static String fileUploadXpath = "//a[text()='File Upload']";
	public static void clickonFileUploadLink() {
		try {
			driver.findElement(By.xpath(fileUploadXpath)).click();
			System.out.println("clicked on file upload link");
		}catch(Exception e) {
			System.out.println("Error in clickonFileUploadLink "+e.getMessage());
		}
	}
	
	public static void teardownBrowser() {
		driver.close();
		System.out.println("*********tear down browser******");
	}
	
	static String chooseFileXpath = "//input[@id='file-upload']";
	public static void chooseFile() {
		try {
			String path = System.getProperty("user.dir");
			System.out.println("path ="+path);
			path = path +"\\src\\main\\resources\\driverDependency\\Test.java";
			WebElement fileUpload = driver.findElement(By.xpath(chooseFileXpath));
			fileUpload.sendKeys(path);
			System.out.println("file upload is success ful");
		}catch(Exception e) {
			System.out.println("failed in choose file method");
		}
	}
	
	static String fileDwnldXpath = "//a[text()='File Download']";
	static String fileXpath = "//a[text()='excelParaValidar.xlsx']";
	public static void fileDownloadLink() {
		try {
			driver.findElement(By.xpath(fileDwnldXpath)).click();
			System.out.println("click on file download ");
			Thread.sleep(4000);	
		 	driver.findElement(By.xpath(fileXpath)).click();
		 	System.out.println("file downloaded");
		}catch(Exception e) {
			System.out.println("failed file download");
		}
	}
	
	public static void readFiles() {
		try {
			String path = System.getProperty("user.home");
			System.out.println("path = "+path);
			path = path +"\\Downloads";
			System.out.println("path value ="+path);
			File file = new File(path);
			File[] allFileValues =   file.listFiles();
			System.out.println("no of files ="+allFileValues.length);
			for(File val :allFileValues ) {
				String name = val.getName();
				if(name.endsWith(".xlsx"))
				System.out.println("name ="+name);
				if(name.equalsIgnoreCase("excelParaValidar.xlsx")) {
					System.out.println(name+" file is present");
					break;
				}
			}
			 
		}catch(Exception e) {
			System.out.println("failed at read files");
		}
	}

//	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		launchChrome();
//		fileDownloadLink();
//		clickonFileUploadLink();
//		chooseFile();
//		teardownBrowser();
//		readFiles();
//	}

}
