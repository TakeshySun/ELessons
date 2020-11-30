package Tests.AutomationFrameworkTests.PageObjectLesson;

import AutomationFramework.B2C_Accelerator.Page.*;
import AutomationFramework.driver.WebDriverSingleton;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Use your Maven project created before. In Test class use jUnit annotation Test and it's assertions. Do next:
1. On product details page select "Add to cart" for product "1934793". Select "Checkout" in cart pop-up
2. Check Order Subtotal and Order Total is $99.85
3. Click "Checkout" button after redirect to cart page
4. Set "test@user.com" as guest e-mail address
5. After being redirected to multicheckout delivery address page check the following final review:
6. Subtotal $99.85, Total $104.84 and Tax $4.99

Also create runner classes which will run your test by selected package/class/tag.
Browser opening/closing move to @BeforeAll and @AfterAll hooks.

 */
public class JUnitAutomationTaskTest {
    static WebDriverSingleton driver;
    static SoftAssertions softly;
    static MainPage mainPage;
    static CartPage cartPage;
    static DeliveryAddress deliveryAddressPage;
    static LoginCheckOutPage loginCheckOutPage;
    static ProductPage productPage;
    static SearchResultPage searchResultPage;

    @BeforeAll
    static void setUp(){
        driver = new WebDriverSingleton();
        mainPage = new MainPage();
        softly = new SoftAssertions();
        cartPage = new CartPage();
        loginCheckOutPage = new LoginCheckOutPage();
        productPage = new ProductPage();
        searchResultPage = new SearchResultPage();
        deliveryAddressPage = new DeliveryAddress();
    }

    @BeforeEach
    public void setUpProcess() throws Exception {
        driver.initialize("chrome");
        driver.openurl("url");
    }

    @AfterEach
    public void quit(){
        driver.quit();
    }

    @AfterAll
    static void info(){
        System.out.println("We are done");
    }

    @DisplayName("Subtotal, Total and Tax verification")
    @Tag("WebUITest")
    @ParameterizedTest
    @ValueSource(strings = {"PowerShot A480"})
    public void test(String input){
        mainPage.fillInSearchField(input);
        mainPage.clickSearchButton();
        searchResultPage.openProductFromSearchResults("10.0 MP, 3.3x optical, DIGIC III, 2.5” LCD, red");
        productPage.clickAddCardButtonOnProductPage();
        productPage.clickCheckOutButtonInCartPopUp();
        assertEquals("$85.59", cartPage.getOrderSubtotal(),"Order Subtotal is incorrect"); //junit_5
        Assert.assertEquals("Order Total is incorrect","$85.59", cartPage.getOrderTotal()); //junit_4

        cartPage.clickCheckOutSecondButtonInCartPage();
        loginCheckOutPage.fillInGuestEmail("test@user.com");
        loginCheckOutPage.fillInConfirmGuestEmail("test@user.com");
        loginCheckOutPage.clickCheckOutAsGuestButtonInCartPage();

        assertAll("Some error text",
                ()->assertEquals("$85.59", deliveryAddressPage.getOrderSubtotalDeliveryPage(), "Order Subtotal is incorrect"),
                ()->assertEquals("$89.87", deliveryAddressPage.getOrderTotalDeliveryPage(), "Order Total is incorrect")
        );

        softly.assertThat(deliveryAddressPage.getOrderTaxDeliveryPage()).as("Order Tax is incorrect").isEqualTo("$4.28");
        softly.assertAll();
    }


}
