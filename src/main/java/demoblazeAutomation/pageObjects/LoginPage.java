/**
 * @auther sailesh
 *
 */

package demoblazeAutomation.pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demoblazeAutomation.action.Action;

public class LoginPage extends Action {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// Objects

	@FindBy(id = "login2")
	private static WebElement loginFormBtnLocator;

	@FindBy(id = "loginusername")
	private static WebElement usernameLocator;

	@FindBy(id = "loginpassword")
	private static WebElement passwordLocator;
	
	@FindBy(id="nameofuser")
	private static WebElement successLoginText;

	private void openLoginForm() {
		try {
			waitForElementToBeClickable(loginFormBtnLocator, 3000);
			click(loginFormBtnLocator);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void typeUserName(String username) {
		try {
			waitForVisibilityOfElement(usernameLocator, 3000);
			type(usernameLocator, username);
		} catch (Exception e) {
			System.out.println("Username is null");
			e.printStackTrace();
		}
	}

	public void typePassword(String password) {
		try {
			waitForVisibilityOfElement(passwordLocator, 3000);
			type(passwordLocator, password);
		} catch (Exception e) {
			System.out.println("Username is null");
			e.printStackTrace();
		}
	}

	public void clickLogin() {
		try {
			Actions actions = new Actions(driver);
			implicitWait(3000);
			actions.sendKeys(passwordLocator,Keys.TAB,Keys.TAB,Keys.ENTER).build().perform();;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Actions

	public HomePage loginToPage(String username, String password) {
		try {
			openLoginForm();
			typeUserName(username);
			typePassword(password);
			clickLogin();
			return new HomePage(driver);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public String getAlertText() {
		try {
			waitForAlertToBePresent(5000);
			Alert alert = switchToAlert();
			return getTextFromAlert(alert);
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	

	public String getUserName() {
		try {
			waitForVisibilityOfElement(successLoginText, 5000);
			return successLoginText.getText();
		}catch(Exception e) {
		e.printStackTrace();	
		}
		return null;
	}
	
}
