package Pages.B2C_Accelerator;

import Pages.AbstarctClasses.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

//TODO: Split all locators and methods to other page classes.
    By addToCart = By.id("addToCartButton");

    By checkOutButtonInCartPopUp = By.cssSelector(".add-to-cart-button");
    By checkOutSecondButtonInCartPage = By.cssSelector("div.main__inner-wrapper > div:nth-child(3) > div:nth-child(6) > div:nth-child(2) > div > div:nth-child(1) > button");
    By checkOutAsGuestButtonInCartPage = By.cssSelector("#guestForm > div:nth-child(3) > button");
    By closeAddToCartPopUpButton = By.cssSelector("#cboxClose > span");

    By guestEmailInput = By.cssSelector("input[name=email]");
    By getGuestConfirmEmailInput = By.cssSelector("#guest\\.confirm\\.email");

    By mapMarketIcon = By.cssSelector("li:nth-child(1) > div > a > span");
    By navigationOrderIcon = By.cssSelector("ul > li:nth-child(2) > div > div:nth-child(1) > div");

    By orderSubtotalValueInCartPage = By.cssSelector(".js-cart-totals.row > div:nth-child(2)");
    By orderTotalValueInCartPage = By.cssSelector(".text-right.grand-total");
    By orderSubtotalValueInDeliveryPage = By.cssSelector("div.subtotal > span");
    By orderTotalValueInDeliveryPage = By.cssSelector("div.totals > span");
    By orderTaxValueInDeliveryPage = By.cssSelector("div.tax > span");

    By siteLogo = By.className("nav__left js-site-logo");
    By signInRegisterLink = By.className("liOffcanvas");
    By shoppingCartIcon = By.cssSelector("ul  div.mini-cart-icon");
    By searchInputField = By.id("js-site-search-input");
    By searchButton = By.cssSelector("span > button > span");
    By searchResults = By.xpath("//a[@class='product__list--name']");


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

    public void addToCartByProductName(String productDescriptionWithoutName){
        String containsName = "//div[contains(text(),'%s')]//following-sibling::div[1]//form[@class='add_to_cart_form']";
        driver.findElement(By.xpath(String.format(containsName,productDescriptionWithoutName))).click();
    }

    public void openProductFromSearchResults(String productDescriptionWithoutName){
        String containsName = "//div[contains(text(),'%s')]/../a[2]";
        driver.findElement(By.xpath(String.format(containsName,productDescriptionWithoutName))).click();
    }

    public void closeAddToCartPopUp(){
        driver.findElement(closeAddToCartPopUpButton).click();
    }

    public void clickAddCardButtonOnProductPage(){
        driver.findElement(addToCart).click();
    }

    public void clickCheckOutButtonInCartPopUp(){
        driver.findElement(checkOutButtonInCartPopUp).click();
    }

    public void clickCheckOutSecondButtonInCartPage(){
        driver.findElement(checkOutSecondButtonInCartPage).click();
    }

    public String getOrderSubtotal(){
        return driver.findElement(orderSubtotalValueInCartPage).getText();
    }

    public String getOrderTotal(){
        return driver.findElement(orderTotalValueInCartPage).getText();
    }

    public String getOrderSubtotalDeliveryPage(){
        return driver.findElement(orderSubtotalValueInDeliveryPage).getText();
    }

    public String getOrderTotalDeliveryPage(){
        return driver.findElement(orderTotalValueInDeliveryPage).getText();
    }
    public String getOrderTaxDeliveryPage(){
        return driver.findElement(orderTaxValueInDeliveryPage).getText();
    }

    public void fillInGuestEmail(String email){
        driver.findElement(guestEmailInput).sendKeys(email);
    }

    public void fillInConfirmGuestEmail(String email){
        driver.findElement(getGuestConfirmEmailInput).sendKeys(email);
    }

    public void clickCheckOutAsGuestButtonInCartPage(){
        driver.findElement(checkOutAsGuestButtonInCartPage).click();
    }
}
