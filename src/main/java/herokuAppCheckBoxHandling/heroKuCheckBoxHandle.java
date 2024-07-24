package herokuAppCheckBoxHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class heroKuCheckBoxHandle {

	public static WebDriver driver;
	static String chromePath = "C:\\Users\\admin\\Documents\\eclipse workspace2\\OrangeHrm\\src\\main\\resources\\driverDependency\\chromedriver.exe";
	static String herokuUrl = "https://the-internet.herokuapp.com/";
	public static void launchChrome() {
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.get(herokuUrl);
		System.out.println("launch herokuUrl url");
		driver.manage().window().maximize();
		System.out.println("maximize the browser");
		
	}
	
	public static void clickOnCheckBoxesLink() {
		try {
			WebElement chkBoxLink = driver.findElement(By.linkText("Checkboxes"));
			chkBoxLink.click();
			System.out.println("click on chek box link");
			Thread.sleep(4000);
			WebElement chkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
			boolean b1 =chkBox1.isDisplayed();
			boolean b2 = chkBox1.isSelected();
			System.out.println(b1+" "+b2);
			if(b2 == false) {
				chkBox1.click();
				System.out.println("check box is selected");
			}
		}catch(Exception e) {
			System.out.println("failed on click on checkbox link");
		}
	}
	
	public static void main(String[] args) {
		launchChrome();
		clickOnCheckBoxesLink();
	}

}
