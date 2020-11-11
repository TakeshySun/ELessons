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

    public WebElement findByCss(String locator){
        return driver.findElement(By.cssSelector(locator));
    }

    public WebElement findByXPath(String locator){
        return driver.findElement(By.xpath(locator));
    }

    public WebElement findsByCss(String locator){
        return driver.findElement(By.cssSelector(locator));
    }

    public WebElement findsByXPath(String locator){
        return driver.findElement(By.xpath(locator));
    }
}
