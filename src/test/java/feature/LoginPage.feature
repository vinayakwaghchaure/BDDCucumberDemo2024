Feature: books cart add remove

  @vinayak @positive @tc_abc1
  Scenario: books cart add and remove feature end to end flow
    Given user is on login page
    When user enters username "vinayakwaghchaure93@gmail.com"
    And user enters password "Vinayak123"
    And user clicks on Login button
    Then user gets the title of the page
    #And page title should be "Home to India's Best Book Boxes| 99bookscart"
    Then click on the Search button of the Homepage.
    Then enter the books name "indian history" on Serach Page.
    Then enter the search button on the Search Page.
    Then click on the "footfalls of indian history" book.
    Then fetch the name of book and price.
    Then click on the "Add to Cart" button.
    Then Verify the after add to cart "Added to Cart!" message displyed.
    Then click on the cart button.
    Then Verify the Book price as Selected in CART book "Footfalls of Indian History".
    Then click on the Search button in Cart page.
    Then enter the books name "indian history" on Serach Page.
    Then enter the search button on the Search Page.
    Then click on the "a noble queena romance of indian history" book.
    Then fetch the name of book and price.
    Then click on the "Add to Cart" button.
    Then Verify the after add to cart "Added to Cart!" message displyed.
    Then click on the cart button.
    Then Verify the Book price as Selected in CART book "A Noble Queena Romance Of Indian History".
    Then click on the Search button in Cart page.
    Then enter the books name "indian history" on Serach Page.
    Then enter the search button on the Search Page.
    Then click on the "epochs of indian history ancient india : 2000 b.c. - 800 a.d." book.
    Then fetch the name of book and price.
    Then click on the "Add to Cart" button.
    Then Verify the after add to cart "Added to Cart!" message displyed.
    Then click on the cart button.
    Then Verify the Book price as Selected in CART book "Epochs of Indian History Ancient India : 2000 B.C. - 800 A.D.".
    Then click on the Search button in Cart page.
    Then enter the books name "geography" on Serach Page.
    Then enter the search button on the Search Page.
    Then click on the "physical geography of western tibet" book.
    Then fetch the name of book and price.
    Then click on the "Add to Cart" button.
    Then Verify the after add to cart "Added to Cart!" message displyed.
    Then click on the cart button.
    Then Verify the Book price as Selected in CART book "Physical Geography Of Western Tibet".
    Then click on the Search button in Cart page.
    Then enter the books name "The Kite Runner" on Serach Page.
    Then enter the search button on the Search Page.
    Then click on the "the kite runner" book.
    Then fetch the name of book and price.
    Then click on the "Add to Cart" button.
    Then Verify the after add to cart "Added to Cart!" message displyed.
    Then click on the cart button.
    Then Verify the Book price as Selected in CART book "The Kite Runner".
    Then Verify the price Selected all Books in Cart.
    Then Remove the Particular book in cart "Footfalls of Indian History".
    Then Verify the after remove the book price will be remove for perticular book and final total.
