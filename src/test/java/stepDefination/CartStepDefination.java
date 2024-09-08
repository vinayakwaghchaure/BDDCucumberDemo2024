package stepDefination;

import org.junit.Assert;

import com.pages.CartPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Then;
/*
 * @CratedBy Vinayak 
 * @date 22-08-2024
 * 
 */
public class CartStepDefination {
	private CartPage cartPage = new CartPage(DriverFactory.getDriver());
	String bookPricefetch = "";
	double priceAdd = 0;
	String removeBookPrice = "";

	@Then("click on the Search button of the Homepage.")
	public void click_on_the_search_button_of_the_homepage() {
		cartPage.searchClickHomePage();
	}

	@Then("enter the books name {string} on Serach Page.")
	public void enter_the_books_name_on_serach_page(String serBookName) {
		cartPage.serchEnter(serBookName);
	}

	@Then("enter the search button on the Search Page.")
	public void enter_the_search_button_on_the_search_page() {
		cartPage.serchButtonBooks();
	}

	@Then("click on the {string} book.")
	public void click_on_the_book(String bookname) {
		cartPage.clickOnTheBooksWithName(bookname);
	}

	@Then("fetch the name of book and price.")
	public void fetch_the_name_of_book_and_price() {
		String booknamefetch = cartPage.fetchBookNameValue();
		System.out.println(booknamefetch + " booknamefetch");
		bookPricefetch = cartPage.fetchBookPriceValue();
		System.out.println(bookPricefetch + " bookPricefetch");
	}

	@Then("click on the {string} button.")
	public void click_on_the_button(String addToCart) {
		cartPage.clickOnAddToCart(addToCart);

	}

	@Then("Verify the after add to cart {string} message displyed.")
	public void verify_the_after_add_to_cart_message_displyed(String msg) {
		String fetchMsg = cartPage.fetchMsgText(msg);
		Assert.assertTrue(fetchMsg.contains(msg));
	}

	@Then("click on the cart button.")
	public void click_on_the_cart_button() {
		cartPage.clickonTheCartButton();
	}

	@Then("Verify the Book price as Selected in CART book {string}.")
	public void verify_the_book_price_as_selected_in_cart_book(String selectedBook) {
		String cartBookPrice = cartPage.fetchTheCartBookPrice(selectedBook);
		String newBookPrice = cartBookPrice.replace("₹", "").replace(",", "");
		double newprice = Double.parseDouble(newBookPrice);
		priceAdd = priceAdd + newprice;
		Assert.assertTrue(cartBookPrice.contains(bookPricefetch));
	}

	@Then("click on the Search button in Cart page.")
	public void click_on_the_search_button_in_cart_page() {
		cartPage.serchButtonCARTpage();
	}

	@Then("Verify the price Selected all Books in Cart.")
	public void verify_the_price_selected_all_books_in_cart() {
		System.out.println(priceAdd);
		String allSelectedTotalPrice = String.valueOf(priceAdd);

		String allBooksValue = cartPage.fetchtheCartAllBooksValue();
		String newBookPriceCart = allBooksValue.replace("₹", "").replace(",", "");
		double newpriceAll = Double.parseDouble(newBookPriceCart);

		String fetchAllprice = String.valueOf(newpriceAll);
		Assert.assertTrue(allSelectedTotalPrice.contains(fetchAllprice));

	}

	@Then("Remove the Particular book in cart {string}.")
	public void remove_the_particular_book_in_cart(String removebook) {
		removeBookPrice = cartPage.removePerticularBook(removebook).replace("₹", "");
	}

	@Then("Verify the after remove the book price will be remove for perticular book and final total.")
	public void verify_the_after_remove_the_book_price_will_be_remove_for_perticular_book_and_final_total() {

		String allSelectedTotalPrice = String.valueOf(priceAdd);
		double allCartBookValue = Double.parseDouble(allSelectedTotalPrice);
		double removeBookVal = Double.parseDouble(removeBookPrice);
		double afterRemoveCal = allCartBookValue - removeBookVal;

		String removeallBooksValue = cartPage.fetchtheCartAllBooksValue();
		String removeBookPriceCart = removeallBooksValue.replace("₹", "").replace(",", "");
		double removePriceAll = Double.parseDouble(removeBookPriceCart);

		String newCalRemovebook = String.valueOf(afterRemoveCal).replace("₹", "").replace(",", "");
		System.out.println(newCalRemovebook + " newCalRemovebook");
		String fetchRemoveBookcal = String.valueOf(removePriceAll);
		System.out.println(fetchRemoveBookcal + " fetchRemoveBookcal");
		Assert.assertTrue(newCalRemovebook.contains(fetchRemoveBookcal));
	}

}
