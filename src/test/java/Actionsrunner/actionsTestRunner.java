package Actionsrunner;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import actionsClassExample.googlePageRightClickUsingActions;

public class actionsTestRunner{
	static String path = "C:\\Users\\admin\\Documents\\eclipse workspace2\\OrangeHrm\\src\\main\\resources\\framework.properties";
	static int a=90;
	static File f;
	static FileInputStream fis;
	static Properties prop;
	
	static void readPropertyFile() {
		try {

			f = new File(path);
			fis = new FileInputStream(f);
//			FileInputStream fiss = new FileInputStream(new File(path));
			 prop = new Properties();
			 prop.load(fis);
			 System.out.println("google url "+prop.getProperty("googleUrl"));
			
		}catch(Exception e) {
			System.out.println("failed in readPropertyFile method "+e.getMessage());
		}
	}

	public static void main(String[] args) {
		readPropertyFile();
		System.out.println("browser name ="+prop.getProperty("browserName"));
		String browser = prop.getProperty("browserName");
		String applicationUrl = prop.getProperty("googleUrl");
		
		googlePageRightClickUsingActions obj = new googlePageRightClickUsingActions();
		obj.launchGooglePage(browser);
		obj.hitPageUrl(applicationUrl);
		obj.rightClickOnGmail();
		obj.keyBoardOperation();

	}

}
