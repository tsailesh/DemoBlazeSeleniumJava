/**
 * @auther sailesh
 *
 */
package demoblazeAutomation.action;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import demoblazeAutomation.actionInterface.ActionInterface;
import org.openqa.selenium.Alert;


public class Action implements ActionInterface{
	WebDriver driver;
	public Action(WebDriver driver) {
		this.driver=driver;
	}

	@Override
	public void click(WebElement element) {
		element.click();
	}

	@Override
	public void type(WebElement element,String value) {
		element.sendKeys(value);
	}

	@Override
	public void pressKey(WebElement element, Keys keys) {
		Actions action = new Actions(driver);
		action.sendKeys(element,keys);
	}
	
	@Override
	public void implicitWait(int timeoutForImplicitWait) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeoutForImplicitWait));
	}

	@Override
	public WebDriverWait explicitWait(WebElement element,int timeoutForExplicitWait) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutForExplicitWait));
		return explicitWait;
	}
	
	@Override
	public WebElement waitForVisibilityOfElement(WebElement element,int timeoutForWait) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutForWait));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	@Override
	public WebElement waitForElementToBeClickable(WebElement element,int timeoutForWait) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutForWait));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	@Override
	public Alert switchToAlert() {
		return driver.switchTo().alert();
	}

	@Override
	public String getTextFromAlert(Alert alert) {
		return alert.getText();
	}

	@Override
	public Alert waitForAlertToBePresent(int timeoutForWait) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutForWait));
		Alert alertPresent= wait.until(ExpectedConditions.alertIsPresent());
		if(alertPresent != null) {
			return alertPresent;
		}
		return null;
	}
	

}
