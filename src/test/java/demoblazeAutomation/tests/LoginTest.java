/**
 * @auther sailesh
 *
 */
package demoblazeAutomation.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import demoblazeAutomation.base.BaseClass;
import demoblazeAutomation.utilities.DataReader;
import demoblazeAutomation.utilities.Log;

/**
 * 
 */
public class LoginTest extends BaseClass{
	
	
	@Test(priority = 1,dataProvider = "loginDataFromJSON")
	public void login(HashMap<String, String> datas) {
		if (datas.get("validation").equals("empty")) 
		{
			Log.info("Testing When Credentials are empty");
			login.loginToPage(datas.get("username"), datas.get("password"));
			String message = login.getAlertText();
			AssertJUnit.assertEquals(message,datas.get("message"),"Message when username and password are empty didnot match");
		} 
		else if (datas.get("validation").equals("wronguser")) 
		{
			Log.info("Testing When Username Is Invalid");
			login.loginToPage(datas.get("username"), datas.get("password"));
			String message = login.getAlertText();
			AssertJUnit.assertEquals(message,datas.get("message"),"Message when username is invalid didnot match");
		} 
		else if(datas.get("validation").equals("wrongpassword"))
		{
			Log.info("Testing When Password is Invalid");
			login.loginToPage(datas.get("username"), datas.get("password"));
			String message = login.getAlertText();
			AssertJUnit.assertEquals(message,datas.get("message"),"Message when password is invalid didnot match");
		}
		else if(datas.get("validation").equals("success"))
		{
			Log.info("Testing When Cred's Are Valid");
			login.loginToPage(datas.get("username"), datas.get("password"));
		}
	}
	
	/**
	 */
	@DataProvider
	public Object[][] loginDataFromJSON() {
		List<HashMap<String, String>> dataFromJSONFile = DataReader.getJSONdataToMap(
				System.getProperty("user.dir") + prop.getProperty("pathToLoginJSON"));
		Object[][] dataArray = new Object[dataFromJSONFile.size()][1];
		for (int i = 0; i < dataFromJSONFile.size(); i++) {
			dataArray[i][0] = dataFromJSONFile.get(i);
		}
		return dataArray;
	}

}
