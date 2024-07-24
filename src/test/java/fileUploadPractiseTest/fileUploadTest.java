package fileUploadPractiseTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fileUploadExample.fileUploadPractise;

public class fileUploadTest {
	@BeforeClass
	public void launchChrome() {
		try {
			System.out.println("launch chrome method in before class");
			fileUploadPractise.launchChrome();
		}catch(Exception e) {
			
		}
	}

	@Test
	public void fileUpload() {
		try {
			
			fileUploadPractise.readFiles();
		}catch(Exception e) {
			
		}
	}
	@Test(invocationCount = 3)
	public void gujarath() {
		try {
			System.out.println("this is gujarath method");
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void haryana() {
		System.out.println("haryana");
	}
	
	@AfterClass
	public void shutdownBrowser() {
		try {
			System.out.println("driver shut down");
			fileUploadPractise.teardownBrowser();
		}catch(Exception e) {
			
		}
	}
}
