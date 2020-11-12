package Tests.AutomationTasks;

import Pages.B2C_Accelerator.Page.MainPage;
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
    MainPage mainPage;

    @Before
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(PropertyReader.getProperties("url"));
        mainPage = new MainPage();
    }

//    @Test
//    public void test(){
//        mainPage.fillInSearchField("camileo");
//        mainPage.clickSearchButton();
//        mainPage.addToCartByProductName("S10 EU 5MP CMOS");
//        mainPage.closeAddToCartPopUp();
//        mainPage.openProductFromSearchResults("S10 EU 5MP CMOS");
//    }
}
