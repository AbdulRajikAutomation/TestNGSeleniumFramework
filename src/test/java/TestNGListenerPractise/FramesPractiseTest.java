package TestNGListenerPractise;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ApachePoiPractiseWithExcel.readDataFromExcel;
import handlesFrames.frame_PractiseExample;

public class FramesPractiseTest {
	static String log4jFilePAth="C:\\Users\\admin\\Documents\\eclipse workspace2\\OrangeHrm\\log4j.properties";
	static Logger log = Logger.getLogger(readDataFromExcel.class);
	
	FramesPractiseTest(){
		PropertyConfigurator.configure(log4jFilePAth);
	}
	
	@BeforeSuite
	public void suite1() {
		log.info("this is before suite");
	}
	
	@AfterSuite
	public void aftrsuite() {
		log.info("this is after suite");		
	}
	
	@BeforeTest
	public void bfrTest() {
		log.info("this is before test");
	}

	@AfterTest
	public void aftrTest() {
		log.info("this is after test");
	}
	
	@BeforeClass
	public void bfrclass() {
		log.info("this is before class");
	}
	
	@AfterClass
	public void aftrclass() {
		log.info("this is after class");
	}
	
	@BeforeMethod
	public void bfrmethod() {
		log.info("this is before method");		
	}
	
	@AfterMethod
	public void aftrmethod() {
		log.info("this is after method");		
	}
	
	
	@Test
	public void framesTestmthod() {
		try {
			log.info("this is test method");
//			frame_PractiseExample obj = new frame_PractiseExample();
//			obj.launchHYRPage();
		}catch(Exception e) {
			log.error("Error in test method");
			System.out.println("error in frames test method"+e.getMessage());
		}
	}
	
	@Test
	public void frames2() {
		log.info("frames 2 method");
	}
	
	@Test
	public void frames3() {
		log.info("frames 3 method");
	}
}
