package Pages.B2C_Accelerator.Page;

import Pages.AbstarctClasses.BasePage;
import org.openqa.selenium.By;

public class ProductPage extends BasePage {
    By addToCart = By.id("addToCartButton");
    By checkOutButtonInCartPopUp = By.cssSelector(".add-to-cart-button");

    public void clickAddCardButtonOnProductPage(){
        driver.findElement(addToCart).click();
    }

    public void clickCheckOutButtonInCartPopUp(){
        driver.findElement(checkOutButtonInCartPopUp).click();
    }
}
