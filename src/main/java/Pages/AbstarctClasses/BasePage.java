package Pages.AbstarctClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected static WebDriver driver;

    public void setWebDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    public Boolean isElementPresent(By locator)
    {
        return driver.findElements(locator).size() > 0;
    }

}
