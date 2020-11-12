package Pages.B2C_Accelerator.Page;

import Pages.AbstarctClasses.BasePage;
import org.openqa.selenium.By;

public class CartPage extends BasePage {
    By checkOutSecondButtonInCartPage = By.cssSelector("div.main__inner-wrapper > div:nth-child(3) > div:nth-child(6) > div:nth-child(2) > div > div:nth-child(1) > button");
    By orderSubtotalValueInCartPage = By.cssSelector(".js-cart-totals.row > div:nth-child(2)");
    By orderTotalValueInCartPage = By.cssSelector(".text-right.grand-total");

    public String getOrderSubtotal(){
        return driver.findElement(orderSubtotalValueInCartPage).getText();
    }

    public String getOrderTotal(){
        return driver.findElement(orderTotalValueInCartPage).getText();
    }

    public void clickCheckOutSecondButtonInCartPage(){
        driver.findElement(checkOutSecondButtonInCartPage).click();
    }
}
