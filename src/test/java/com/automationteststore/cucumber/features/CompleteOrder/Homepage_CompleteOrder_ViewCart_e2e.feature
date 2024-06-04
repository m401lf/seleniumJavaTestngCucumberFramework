@Homepage_CompleteOrder_E2E_2
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
    And I hoverOver items cart and click on view Cart icon from dropdown
    And I can see current page submenu breadcrumbs "Basket" are correctly displayed
    And I can see product "SKINSHEEN BRONZER STICK" and per unit price $29.50
    And I can see product "ABSOLUE EYE PRECIOUS CELLS" and per unit price $89.00
    And I should see the product name "Skinsheen Bronzer Stick" in the cart
    And can see "Skinsheen Bronzer Stick" product model as "558003"
    And verify the product name "SKINSHEEN BRONZER STICK" and the model 558003
    And I removed "BENEFIT BELLA BAMBA" item from cart
    And I update "SKINSHEEN BRONZER STICK" quantity in cart by 8
    And I update "ABSOLUE EYE PRECIOUS CELLS" quantity in cart by 4
    And click "Update" button
    And I can see product "SKINSHEEN BRONZER STICK" and total price $236.00
    And I can see product "ABSOLUE EYE PRECIOUS CELLS" and total price $356.00
    And I tap Checkout button
    And I can see current page submenu breadcrumbs "Login" are correctly displayed
    And I can see RETURNING CUSTOMER and I AM A NEW CUSTOMER. in login page
    And I login in login page as a returning customer:
      | username     | password     |
      | webdriverio2 | webdriverio2 |
    And I can see current page submenu breadcrumbs "Confirm" are correctly displayed
    And I should be on CHECKOUT CONFIRMATION in the Checkout Confirmation page
    And I can see "Edit Ship", "Edit Payment", "Edit Coupon", "Edit Cart", "Back" and "Confirm Order" buttons are displayed
    And I should see Order Summary in checkout confirmation page
    And I tap on Confirm Order
    And I can see current page submenu breadcrumbs "Success" are correctly displayed
    And I can see YOUR ORDER HAS BEEN PROCESSED! is Displayed
    Then I am presented with Your order #
    And I click on Continue button
    And I can see page title "A place to practice your automation skills!" and page url "https://automationteststore.com/" in the Home page
    And I am back on ecommerce website