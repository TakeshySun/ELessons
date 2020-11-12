package AutomationFramework.B2C_Accelerator.Page;

import AutomationFramework.AbstarctClasses.BasePage;
import org.openqa.selenium.By;

public class LoginCheckOutPage extends BasePage {
    By guestEmailInput = By.cssSelector("input[name=email]");
    By getGuestConfirmEmailInput = By.cssSelector("#guest\\.confirm\\.email");
    By checkOutAsGuestButtonInCartPage = By.cssSelector("#guestForm > div:nth-child(3) > button");

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
