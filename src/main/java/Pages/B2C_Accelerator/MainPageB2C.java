package Pages.B2C_Accelerator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPageB2C {
    WebDriver driver;

    By siteLogo = By.className("nav__left js-site-logo");
    By signInRegisterLink = By.className("liOffcanvas");
    By mapMarketIcon = By.cssSelector("li:nth-child(1) > div > a > span");
    By navigationOrderIcon = By.cssSelector("ul > li:nth-child(2) > div > div:nth-child(1) > div");
    By shoppingCartIcon = By.cssSelector("ul  div.mini-cart-icon");
    By searchInputField = By.id("js-site-search-input");
    By searchButton = By.cssSelector("span > button > span");
    By searchResults = By.xpath("//a[@class='product__list--name']");
    By closeAddToCartPopUpButton = By.cssSelector("ul > li > div > button > span");

    public MainPageB2C(WebDriver driver) {
        this.driver = driver;
    }

    public void clickNavLinkByText(String navLinkText){
        String navigation = "//a[contains(text(), '%s')]";
        driver.findElement(By.xpath(String.format(navigation,navLinkText))).click();
    }

    public void fillInSearchField(String text){
        driver.findElement(searchInputField).sendKeys(text);
    }

    public void clickSearchButton(){
        driver.findElement(searchButton).click();
    }

    public void addToCartByProductName(String productName){
        String containsName = "//a[contains(text(),'%s')]//following-sibling::div[3]//form[@class='add_to_cart_form']";
        driver.findElement(By.xpath(String.format(containsName,productName))).click();
    }

    public void clickOnProductInSearchResultList(String productName){
        String containsName = "//a[contains(text(),'%s')]";
        driver.findElement(By.xpath(String.format(containsName,productName))).click();
    }

    public void closeAddToCartPopUp(){
        driver.findElement(closeAddToCartPopUpButton);
    }
}
