package AutomationFramework.B2C_Accelerator.Page;

import AutomationFramework.AbstarctClasses.BasePage;
import org.openqa.selenium.By;

public class MainPage extends BasePage {

//    By mapMarketIcon = By.cssSelector("li:nth-child(1) > div > a > span");
//    By navigationOrderIcon = By.cssSelector("ul > li:nth-child(2) > div > div:nth-child(1) > div");
//    By siteLogo = By.className("nav__left js-site-logo");
//    By signInRegisterLink = By.className("liOffcanvas");
//    By shoppingCartIcon = By.cssSelector("ul  div.mini-cart-icon");
//    By searchResults = By.xpath("//a[@class='product__list--name']");
    By searchButton = By.cssSelector("span > button > span");
    By searchInputField = By.id("js-site-search-input");

    public void clickNavLinkByText(String navLinkText){
        String navigation = "//a[contains(text(), '%s')]";
        driver.findElement(By.xpath(String.format(navigation,navLinkText))).click();
    }

    public void fillInSearchField(String text){
        clearAndSendKeys(searchInputField, text);
    }

    public void clickSearchButton(){
        driver.findElement(searchButton).click();
    }

}
