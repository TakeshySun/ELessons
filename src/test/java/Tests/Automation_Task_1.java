package Tests;

import Pages.B2C_Accelerator.MainPageB2C;
import Pages.PropertyReader;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

/*
In the test write code that opens the chosen internet shop in Chrome browser.
	On the Home page locate logo, Sign in Register, icon, search field, navigation menu, banner.
	Search for "camileo".
	Click "Add to cart" button for product "CAMILEO S10 EU"
	Click on product "CAMILEO S10 EU" on search result page.
	Name a branch as "Selenium Basic". Push this project to Epam gitlab and share the project with your mentor
 */

public class Automation_Task_1 {
    WebDriver driver;
    MainPageB2C mainPageB2C;

    @Before
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(PropertyReader.getProperties("url"));
        mainPageB2C = new MainPageB2C(driver);
    }

    @Test
    public void test(){
        mainPageB2C.fillInSearchField("camileo");
        mainPageB2C.clickSearchButton();
        mainPageB2C.addToCartByProductName("S10 EU");
        mainPageB2C.closeAddToCartPopUp();
        mainPageB2C.clickOnProductInSearchResultList("S10 EU");
    }
}
