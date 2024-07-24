package handleDropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sauceDemo {
	static WebDriver driver;
	static String url="https://www.saucedemo.com/";
	//div[@id='login_credentials']/h4/following-sibling::br[last()]/preceding-sibling::br[last()]
    public static String nameXpath = "//div[@id='login_credentials']";
	public static void main(String[] args) {
		try {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--incognito","--start-maximized");
//		DesiredCapabilities cap = DesiredCapabilities.chrome();
//		cap.setCapability(ChromeOptions.CAPABILITY, opt);
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver(opt);
			driver.get(url);
			System.out.println("launch chrome");
			Thread.sleep(4000);
			WebElement nam = driver.findElement(By.xpath(nameXpath));
			List<WebElement> namesValue = nam.findElements(By.tagName("br"));
			String pwd = driver.findElement(By.xpath("//div[@class='login_password']//h4")).getAttribute("value");
			System.out.println("namesValue : "+namesValue.size());
			for(WebElement n2 : namesValue) {
			    String v2 = n2.getAttribute("value");
			    System.out.println("v2 = "+v2);
			}
			System.out.println("pwd :"+pwd);
			// inner
			String inner = nam.getAttribute("innerHTML");
			System.out.println(inner);
			String txtVl[] = inner.split("<br>");
			for(String v : txtVl) {
				System.out.println("V :"+v);
			}
		}catch(Exception e) {
			System.out.println("Error"+e.getMessage());
		}
			

	}

}
