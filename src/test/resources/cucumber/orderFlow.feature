  Feature: Order flow
    0. Search for "PowerShot A480".
    1. On product details page select "Add to cart" for product "PowerShot A480". Select "Checkout" in cart pop-up
    2. Check Order Subtotal and Order Total is $85.59
    3. Click "Checkout" button after redirect to cart page
    4. Set "test@user.com" as guest e-mail address
    5. After being redirected to multicheckout delivery address page check the following final review:
    6. Subtotal $99.85, Total $104.84 and Tax $4.99

  Scenario: Subtotal, Total and Tax verification
    Given I on main page
    When I type in search field "PowerShot A480"
    And I click search button
    And I open product by product description: "10.0 MP, 3.3x optical, DIGIC III, 2.5” LCD, red"
    And I add product to cart
    And select Checkout in cart pop-up
    Then Order Subtotal is "$85.59"
    And Order Total is "$85.59"
    When I click Checkout button on cart page
    And fill in email fields with "test@user.com" as guest e-mail address
    And checkout as guest
    Then Subtotal is "$85.59", Total is "$89.87", Tax is "$4.28"






