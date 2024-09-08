package com.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	WebDriver driver;
	WebDriverWait webDriverwait;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void waitForElementPresence(By locator, long wait) throws NotFoundException {
		webDriverwait = new WebDriverWait(driver, wait);
		webDriverwait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void waitForElementToBeClicable(By locator, long wait) throws NotFoundException {
		webDriverwait = new WebDriverWait(driver, wait);
		webDriverwait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void elementHighlight(By locator) {
		WebElement element = driver.findElement(locator);
		for (int i = 0; i < 1; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
					"color: black  ; border: 4px solid red ;");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
		}
	}

}
