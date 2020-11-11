package Tests.PageObjectLesson;

import Pages.B2C_Accelerator.MainPage;
import Pages.driver.WebDriverSingleton;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static Pages.driver.WebDriverSingleton.initialize;
import static Pages.driver.WebDriverSingleton.openurl;
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
    static MainPage mainPage;
    static SoftAssertions softly;

    @BeforeAll
    static void setUpDriver(){
        initialize("chrome");
        mainPage = new MainPage();
        softly = new SoftAssertions();
    }

    @BeforeEach
    public void setUp() throws Exception {
        openurl("url");
    }

    @AfterEach
    public void quit(){
        WebDriverSingleton.quit();
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
        mainPage.openProductFromSearchResults("10.0 MP, 3.3x optical, DIGIC III, 2.5” LCD, red");
        mainPage.clickAddCardButtonOnProductPage();
        mainPage.clickCheckOutButtonInCartPopUp();
        assertEquals("$85.59", mainPage.getOrderSubtotal(),"Order Subtotal is incorrect"); //junit_5
        Assert.assertEquals("Order Total is incorrect","$85.59", mainPage.getOrderTotal()); //junit_4

        mainPage.clickCheckOutSecondButtonInCartPage();
        mainPage.fillInGuestEmail("test@user.com");
        mainPage.fillInConfirmGuestEmail("test@user.com");
        mainPage.clickCheckOutAsGuestButtonInCartPage();

        assertAll("Some error text",
                ()->assertEquals("$85.59", mainPage.getOrderSubtotalDeliveryPage(), "Order Subtotal is incorrect"),
                ()->assertEquals("$89.87", mainPage.getOrderTotalDeliveryPage(), "Order Total is incorrect")
        );

        softly.assertThat(mainPage.getOrderTaxDeliveryPage()).as("Order Tax is incorrect").isEqualTo("$4.28");
        softly.assertAll();
    }


}
