/**
 * @auther sailesh
 *
 */
package demoblazeAutomation.actionInterface;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;

/**
 * 
 */
public interface ActionInterface {
	public void click(WebElement element);
	public void type(WebElement element,String value);
	public void pressKey(WebElement element,Keys keys) throws InterruptedException;
	public void implicitWait(int timeoutForImplicitWait);
	public WebDriverWait explicitWait(WebElement element,int timeoutForExplicitWait);
	public WebElement waitForVisibilityOfElement(WebElement element,int timeoutForWait);
	public WebElement waitForElementToBeClickable(WebElement element,int timeoutForWait);
	public Alert switchToAlert();
	public String getTextFromAlert(Alert alert);
	public Alert waitForAlertToBePresent(int timeoutForWait);
}
