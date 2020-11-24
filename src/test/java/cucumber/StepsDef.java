package cucumber;

import AutomationFramework.B2C_Accelerator.Page.*;
import AutomationFramework.driver.WebDriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StepsDef {
    static WebDriverSingleton driver;
    static SoftAssertions softly;
    static MainPage mainPage;
    static CartPage cartPage;
    static DeliveryAddress deliveryAddressPage;
    static LoginCheckOutPage loginCheckOutPage;
    static ProductPage productPage;
    static SearchResultPage searchResultPage;

    @Before
    public void setUp(){
        driver = new WebDriverSingleton();
        mainPage = new MainPage();
        softly = new SoftAssertions();
        cartPage = new CartPage();
        loginCheckOutPage = new LoginCheckOutPage();
        productPage = new ProductPage();
        searchResultPage = new SearchResultPage();
        deliveryAddressPage = new DeliveryAddress();
        driver.initialize("chrome");
    }

    @After
    public void quit(){
        driver.quit();
    }

    @Given("I on main page")
    public void openMainPage() throws Exception {
        driver.openurl("url");
    }

    @When("I type in search field {string}")
    public void searchForProduct(String searchText) {
        mainPage.fillInSearchField(searchText);
    }

    @When("I click search button")
    public void click_search_button() {
        mainPage.clickSearchButton();
    }

    @When("I open product by product description: {string}")
    public void openProductByProductDescription(String descriptionText) {
        searchResultPage.openProductFromSearchResults(descriptionText);
    }

    @When("I add product to cart")
    public void add_product_to_cart() {
        productPage.clickAddCardButtonOnProductPage();
    }

    @When("select Checkout in cart pop-up")
    public void select_in_cart_pop_up() {
        productPage.clickCheckOutButtonInCartPopUp();
    }

    @Then("Order Subtotal is {string}")
    public void order_subtotal_is(String orderSubtotal) {
        assertEquals(orderSubtotal, cartPage.getOrderSubtotal(),"Order Subtotal is incorrect");
    }

    @Then("Order Total is {string}")
    public void order_total_is_$(String orderTotal) {
        Assert.assertEquals("Order Total is incorrect",orderTotal, cartPage.getOrderTotal());
    }

    @When("I click Checkout button on cart page")
    public void i_click_button_on_cart_page() {
        cartPage.clickCheckOutSecondButtonInCartPage();
    }

    @When("fill in email fields with {string} as guest e-mail address")
    public void fill_in_email_fields_with_as_guest_e_mail_address(String email) {
        loginCheckOutPage.fillInGuestEmail(email);
        loginCheckOutPage.fillInConfirmGuestEmail(email);
    }

    @When("checkout as guest")
    public void checkout_as_guest() {
        loginCheckOutPage.clickCheckOutAsGuestButtonInCartPage();
    }

    @Then("Subtotal is {string}, Total is {string}, Tax is {string}")
    public void subtotal_is(String subtotal, String total, String tax) {
        softly.assertThat(deliveryAddressPage.getOrderSubtotalDeliveryPage()).as("Order Subtotal is incorrect").isEqualTo(subtotal);
        softly.assertThat(deliveryAddressPage.getOrderTotalDeliveryPage()).as("Order Total is incorrect").isEqualTo(total);
        softly.assertThat(deliveryAddressPage.getOrderTaxDeliveryPage()).as("Order Tax is incorrect").isEqualTo(tax);
        softly.assertAll();
    }

}

