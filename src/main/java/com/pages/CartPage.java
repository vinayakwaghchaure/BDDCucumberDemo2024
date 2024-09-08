package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.util.ElementUtil;
/*
 * @CratedBy Vinayak 
 * @date 22-08-2024
 * 
 */
public class CartPage {
	private WebDriver driver;
	ElementUtil elemUtil;

	// 1. By Locators:
	private By serchHomeBtn = By.xpath("//a[@name='search']");
	private By booksInp = By.xpath("//input[@name='q']");
	private By bookserchBtn = By.xpath("//button[@type='submit']/i");
	private By addToCartbtn = By.xpath("(//button//*[name()='svg'])[1]");
	private By cart = By.xpath("//a[@name='cart']//*[name()='svg']");
	private By serchInCart = By.xpath("//a[@name='search']//*[name()='svg']");

	// 2. Constructor of the page class:
	public CartPage(WebDriver driver) {
		this.driver = driver;
		elemUtil = new ElementUtil(driver);
	}

	public void searchClickHomePage() {
		elemUtil.waitForElementToBeClicable(addToCartbtn, 1000);
		elemUtil.elementHighlight(addToCartbtn);
		driver.findElement(serchHomeBtn).click();

	}

	public void serchEnter(String serchBooks) {
		elemUtil.waitForElementPresence(addToCartbtn, 1000);
		elemUtil.elementHighlight(addToCartbtn);
		driver.findElement(booksInp).sendKeys(serchBooks);
		System.out.println(serchBooks + "serchBooks");

	}

	public void serchButtonBooks() {
		elemUtil.waitForElementPresence(bookserchBtn, 2000);
		elemUtil.elementHighlight(bookserchBtn);
		driver.findElement(bookserchBtn).click();
	}

	public void clickOnTheBooksWithName(String bookname) {
		elemUtil.setData(bookname);
		By booknameText = By.xpath("(//div/span[contains(text(),'" + bookname + "')])[1]");
		elemUtil.waitForElementToBeClicable(booknameText, 2000);
		elemUtil.elementHighlight(booknameText);
		driver.findElement(booknameText).click();

	}

	public String fetchBookNameValue() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String bookname = elemUtil.getData();
		By booknameText = By.xpath("//div//h1[contains(text(),'" + bookname + "')]");
		elemUtil.waitForElementPresence(booknameText, 2000);
		elemUtil.elementHighlight(booknameText);
		String fetchbookName = driver.findElement(booknameText).getText();
		System.out.println(fetchbookName + " fetchbookName");
		return fetchbookName;
	}

	public String fetchBookPriceValue() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String bookname = elemUtil.getData();
		By bookPriceText = By.xpath("//div/h1[contains(text(),'" + bookname
				+ "')]//following::span[@class='product-page-price themecolor']");
		elemUtil.waitForElementPresence(bookPriceText, 2000);
		elemUtil.elementHighlight(bookPriceText);
		String fetchbookPrice = driver.findElement(bookPriceText).getText();
		return fetchbookPrice;
	}

	public void clickOnAddToCart(String addToCart) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		elemUtil.waitForElementToBeClicable(addToCartbtn, 2000);
		elemUtil.elementHighlight(addToCartbtn);
		driver.findElement(addToCartbtn).click();

	}

	public String fetchMsgText(String msg) {
		By fetchMSG = By.xpath("(//span[contains(text(),'" + msg + "')])[1]");
		elemUtil.waitForElementPresence(fetchMSG, 2000);
		elemUtil.elementHighlight(fetchMSG);
		String fetchMsg = driver.findElement(fetchMSG).getText();
		System.out.println(fetchMsg + " fetchMsg");
		return fetchMsg;
	}

	public void clickonTheCartButton() {
		elemUtil.elementHighlight(cart);
		driver.findElement(cart).click();
		;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String fetchTheCartBookPrice(String booknameSelected) {
		By fetchBookCartPrice = By.xpath(
				"(//div[contains(text(),'" + booknameSelected + "')]//following::span[@class='cart-productPrice'])[1]");
		elemUtil.waitForElementPresence(fetchBookCartPrice, 2000);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		elemUtil.elementHighlight(fetchBookCartPrice);
		String fetchbookCARTPrice = driver.findElement(fetchBookCartPrice).getText();
		System.out.println(fetchbookCARTPrice + " fetchbookCART");
		return fetchbookCARTPrice;
	}

	public void serchButtonCARTpage() {
		elemUtil.waitForElementPresence(serchInCart, 2000);
		elemUtil.elementHighlight(serchInCart);
		driver.findElement(serchInCart).click();
	}

	public String fetchtheCartAllBooksValue() {
		By allpricebook = By.xpath("(//div[@class='card']//div//div//div//following::span[1])[1]");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		elemUtil.elementHighlight(allpricebook);
		String fetchAllbookCARTPrice = driver.findElement(allpricebook).getText();
		System.out.println(fetchAllbookCARTPrice + " fetchbookCART");
		return fetchAllbookCARTPrice;

	}

	public String removePerticularBook(String removebook) {
		By removeBookBtn = By.xpath("//div[contains(text(),'" + removebook + "')]//following::button[1]");
		By removeBookPrice = By.xpath(
				"(//div[contains(text(),'" + removebook + "')]//following::span[@class='cart-productPrice'])[1]");
		elemUtil.elementHighlight(removeBookPrice);
		String fetchremoveBookPrice = driver.findElement(removeBookPrice).getText();
		System.out.println(fetchremoveBookPrice + " fetchremoveBookPrice");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		elemUtil.elementHighlight(removeBookBtn);
		driver.findElement(removeBookBtn).click();
		return fetchremoveBookPrice;
	}

}
