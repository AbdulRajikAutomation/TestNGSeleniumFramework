package herokuAppCheckBoxHandling;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxPractise {
	
	public static WebDriver driver;
	//static String chromePath = "C:\\Users\\admin\\Documents\\eclipse workspace2\\OrangeHrm\\src\\main\\resources\\driverDependency\\chromedriver.exe";
	static String herokuUrl = "https://the-internet.herokuapp.com/";
	public static void launchChrome() {
		try {
//		System.setProperty("webdriver.chrome.driver", chromePath);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(herokuUrl);
		System.out.println("launch herokuUrl url");
		driver.manage().window().maximize();
		System.out.println("maximize the browser");
		}catch(Exception e) {
			System.out.println("failed in launch Chrome"+e.getMessage());
		}
	}
	
	static String chkBoxXpathValue = "//a[contains(text(),'Checkboxes')]";
	public static void clickOnCheckBox() {
		try {
			WebElement chkBox = driver.findElement(By.xpath(chkBoxXpathValue));
			chkBox.click();
			System.out.println("click on checkbox");
			Thread.sleep(4000);
			String currentUrl = driver.getCurrentUrl();
			//assert
		    if(currentUrl.contains("checkboxes")) {
		    	System.out.println("landed on check boxes page");
		    }else {
		    	System.out.println("url doesnot contains check box ");
		    }
		}catch(Exception e) {
			System.out.println("error in clickOnCheckBox"+e.getMessage());
		}
	}
	
	static String chkBox1Xpath="(//form//input[@type='checkbox'])[1]";
	static String chkBox2Xpath="(//form//input[@type='checkbox'])[2]";
	
	static void checkBoxStatus() {
		try {
			WebElement chkBox1 = driver.findElement(By.xpath(chkBox1Xpath));
			WebElement chkBox2 = driver.findElement(By.xpath(chkBox2Xpath));
			
			boolean c1 = chkBox1.isSelected();
			boolean c2 = chkBox2.isSelected();
			System.out.println("chk box1 ="+c1);
			System.out.println("chk box2 ="+c2);
			if(c1 == false) {
				System.out.println("click on chkBox 1");
				chkBox1.click();
			}
			if(c2 == true) {
				System.out.println("de select check box 2");
			     chkBox2.click();
			}
		}catch(Exception e) {
			
		}
	}
	
	static void takePageScreenshot() {
		try {
			String destinationPath =System.getProperty("user.dir")+"\\Results\\checkBox.jpg";
			File screnshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest = new File(destinationPath);
			FileUtils.copyFile(screnshot, dest);
			System.out.println("screenshot file saved");
		}catch(Exception e) {
			System.out.println("method name takePageScreenshot"+e.getMessage());
		}
	}
	
	static String path = "\\src\\main\\resources\\framework.properties";
    public static void readPropertyFileData() {
    	try {
    		path = System.getProperty("user.dir")+path;
    		System.out.println("path = "+path);
    		FileInputStream fis = new FileInputStream( new File(path) );
    		Properties prop = new Properties();
    		prop.load(fis);
    		
    		String val = prop.getProperty("browserName");
    		System.out.println("value = "+val);
    		System.out.println("url ="+prop.getProperty("applicationUrl"));
    	}catch(Exception e) {
    		System.out.println("failed in method readPropertyFileData"+e.getMessage());
    	}
    } 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		launchChrome();
//		clickOnCheckBox();
//		checkBoxStatus();
//		takePageScreenshot();
		readPropertyFileData();
	}

}
