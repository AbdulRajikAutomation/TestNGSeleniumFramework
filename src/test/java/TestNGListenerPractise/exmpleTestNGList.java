package TestNGListenerPractise;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class exmpleTestNGList implements ITestListener {

	public void onTestStart(ITestResult result) {
		    System.out.println("on test start ");
		    System.out.println(result.getMethod().getMethodName());
		  }
	public void onTestSuccess(ITestResult result) {
	    System.out.println("on test success ");
	    // not implemented
	  }
	public void onTestFailure(ITestResult result) {
	    // not implemented
	    System.out.println("onTestFailure");
	  }
	public void onTestSkipped(ITestResult result) {
	    // not implemented
	    System.out.println("onTestSkipped");
	  }
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	    System.out.println("onTestFailedButWithinSuccessPercentage");
	  }
	public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	    System.out.println("onTestFailedWithTimeout");
	    
	  }
	public void onStart(ITestContext context) {
	    // not implemented
	    System.out.println("onStart");
	    }
	 public void onFinish(ITestContext context) {
		    // not implemented
		    System.out.println("onFinish ");
		  }
	 
}
