package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.util.ElementUtil;

/*
 * @CratedBy Vinayak 
 * @date 22-08-2024
 * 
 */
public class LoginPage {

	private WebDriver driver;
	private ElementUtil elemUtil;
	// 1. By Locators: OR
	private By emailId = By.xpath("//input[@type='Email']");
	private By password = By.xpath("//input[@type='Password']");
	private By signInButton = By.xpath("//button[contains(text(),'Sign In')]");
	private By forgotPwdLink = By.linkText("Forgot your password?111");

	// 2. Constructor of the page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elemUtil = new ElementUtil(driver);
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}

	public void enterUserName(String username) {
		elemUtil.elementHighlight(emailId);
		driver.findElement(emailId).sendKeys(username);
	}

	public void enterPassword(String pwd) {
		elemUtil.elementHighlight(password);
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickOnLogin() {
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		elemUtil.elementHighlight(signInButton);
		driver.findElement(signInButton).click();
	}

}
