

package com.realestate.paramountProperty.gennericUtility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.Icon;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {
	/**
	 * it's an implicitly wait Always wait for Element in DOM document & release the
	 * control if element available
	 * 
	 * @param driver
	 */
	public void waitForElementInDOM(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(IConstatants.Implicitly_TimeOut,TimeUnit.SECONDS);
	}

	/**
	 * 
	 * 
	 * 
	 * it's an Explicitly wait Always wait for Page to be loaded & available in GUI
	 * 
	 * @Rakesh driver
	 * @Rakesh partailPageURL
	 */
	public void waitForPage(WebDriver driver, String partailPageURL) {
		WebDriverWait wait = new WebDriverWait(driver, IConstatants.Explicitly_TimeOut);
		wait.until(ExpectedConditions.urlContains(partailPageURL));
	}

	/**
	 * it's an Explicitly wait Always wait for Page to be loaded & available in GUI
	 * 
	 * @Rakesh driver
	 * @Rakesh partailPageURL
	 */
	public void waitForElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, IConstatants.Explicitly_TimeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * used to Switch to Any Window based on Window Title
	 * 
	 * @Rakesh driver
	 * @Rakesh partialWindowTitle
	 */
	public void swithToWindow(WebDriver driver, String partialWindowTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String wID = it.next();
			driver.switchTo().window(wID);
			String currentWindowTitle = driver.getTitle();
			if (currentWindowTitle.contains(partialWindowTitle)) {
				break;
			}
		}
	}

	/**
	 * used to Switch to Alert Window & click on OK button
	 * 
	 * @Rakesh driver
	 */
	public void swithToAlertWindowAndAccpect(WebDriver driver, String expectedMsg) {
		Alert alt = driver.switchTo().alert();
		if (alt.getText().trim().equalsIgnoreCase(expectedMsg.trim())) {
			System.out.println("Alert Message is verified");
		} else {
			System.out.println("Alert Message is not verified");
		}
		alt.accept();
	}

	/**
	 * used to Switch to Alert Window & click on Cancel button
	 * 
	 * @Rakesh driver
	 */
	public void swithToAlertWindowAndCancel(WebDriver driver, String expectedMsg) {
		Alert alt = driver.switchTo().alert();
		if (alt.getText().equals(expectedMsg)) {
			System.out.println("Alert Message is verified");
		} else {
			System.out.println("Alert Message is not verified");
		}
		alt.dismiss();
	}

	/**
	 * used to Switch to Frame Window based on index
	 * 
	 * @Rakesh driver
	 * @Rakesh index
	 */
	public void swithToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * used to Switch to Frame Window based on id or name attribute
	 * 
	 * @Rakesh driver
	 * @Rakesh id_name_attribute
	 */
	public void swithToFrame(WebDriver driver, String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}

	/**
	 * used to select the value from the dropDwon based on index
	 * 
	 * @Rakesh driver
	 * @Rakesh index
	 */
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * used to select the value from the dropDwon based on value / option avlaible
	 * in GUI
	 * 
	 * @Rakesh element
	 * @Rakesh value
	 */
	public void select(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * used to place mouse cursor on specified element
	 * 
	 * @Rakesh driver
	 * @Rakesh elemnet
	 */
	public void mouseOverOnElement(WebDriver driver, WebElement elemnet) {
		Actions act = new Actions(driver);
		act.moveToElement(elemnet).perform();
	}

	/**
	 * used to right click on specified element
	 * 
	 * @Rakesh driver
	 * @Rakesh elemnet
	 */

	public void rightClickOnElement(WebDriver driver, WebElement elemnet) {
		Actions act = new Actions(driver);
		act.contextClick(elemnet).perform();
	}

	/**
	 * 
	 * @Rakesh driver
	 * @Rakesh javaScript
	 */
	public void executeJavaScript(WebDriver driver, String javaScript) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript(javaScript, null);
	}

	public void waitAndClick(WebElement element) throws InterruptedException {
		int count = 0;
		while (count < 20) {
			try {
				element.click();
				break;
			} catch (Throwable e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}

	/**
	 * pass enter Key appertain in to Browser
	 * 
	 * @Rakesh driver
	 */
	public void passEnterKey(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}

}
