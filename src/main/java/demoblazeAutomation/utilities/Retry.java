/**
 * @auther sailesh
 *
 */
package demoblazeAutomation.utilities;

/**
 * 
 */
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	int count = 0;
	int maxTry = 1;//Integer.parseInt(prop.getProperty("IReTry"));

	@Override
	public boolean retry(ITestResult result) {
		System.out.println("Here is retry");
		if (count < maxTry) {
			count++;
			return true;
		}
		return false;
	}

}
