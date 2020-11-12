package Pages.AbstarctClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected static WebDriver driver;

    public void setWebDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    public Boolean isElementPresent(By locator)
    {
        return driver.findElements(locator).size() > 0;
    }

    public void clearAndSendKeys(By locator, String keys){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(keys);
    }
}
