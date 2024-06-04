@Homepage_CompleteOrder_E2E_1
Feature: Online ordering

  Scenario: should be able to place an order
    Given I am on ecommerce website
    And I can see in current page title and url as follows:
      | A place to practice your automation skills! |
      | https://automationteststore.com             |
    And I add the following items to cart:
      | SKINSHEEN BRONZER STICK    |
      | BENEFIT BELLA BAMBA        |
      | ABSOLUE EYE PRECIOUS CELLS |
    And I hoverOver items cart and click on checkout icon from dropdown
    And can see No Of Items in Cart and Total Amount are displayed as follows:
      | No Of Items in Cart |
      | 3                   |
    And I click Checkout Icon button
    #And I click View Cart Icon button
    And I can see "Returning Customer" and  "I am a new customer."
    And I login in login page as a returning customer:
      | username     | password     |
      | webdriverio2 | webdriverio2 |
    And I should be on "CHECKOUT CONFIRMATION" in the Checkout Confirmation page
    And I can see "Edit Ship", "Edit Payment", "Edit Coupon", "Edit Cart", "Back" and "Confirm Order" buttons are displayed
    And I should see "Order Summary" in checkout confirmation page
    And I click on confirm order button
    And I can see "YOUR ORDER HAS BEEN PROCESSED!" is Displayed
    Then I am presented with an order number "Your order #"
    And I click on "Continue" Button
    And I can see page title "A place to practice your automation skills!" and page header "https://automationteststore.com/" in the Home page
    And I am back on ecommerce website
