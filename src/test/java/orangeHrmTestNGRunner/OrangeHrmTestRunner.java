package orangeHrmTestNGRunner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import TestNGPractise.orangeHrmLogin;

public class OrangeHrmTestRunner {

	// 1. launch chrome 
	//2. hit the page url
//	3.  perform the login
//	4.  validate the page title
	orangeHrmLogin ohm;
	@BeforeClass
	public void launchChrome() {
		ohm = new orangeHrmLogin();
		ohm.launchchrome();
		ohm.launchOrangeHrm();
	}
	
	@Test
	public void performLoginTest() {
		try {
			ohm = new orangeHrmLogin();
			ohm.userlogin("Admin", "admin123");
			ohm.validatePageTitle();
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void quitTheBrowser() {
		System.out.println("quit the browser");
		ohm = new orangeHrmLogin();
		ohm.closeBrowser();
	}
	
}
