package AutomationFramework.B2C_Accelerator.Page;

import AutomationFramework.AbstarctClasses.BasePage;
import org.openqa.selenium.By;

public class DeliveryAddress extends BasePage {
    By orderSubtotalValueInDeliveryPage = By.cssSelector("div.subtotal > span");
    By orderTotalValueInDeliveryPage = By.cssSelector("div.totals > span");
    By orderTaxValueInDeliveryPage = By.cssSelector("div.tax > span");

    public String getOrderTaxDeliveryPage(){
        return driver.findElement(orderTaxValueInDeliveryPage).getText();
    }
    public String getOrderTotalDeliveryPage(){
        return driver.findElement(orderTotalValueInDeliveryPage).getText();
    }

    public String getOrderSubtotalDeliveryPage(){
        return driver.findElement(orderSubtotalValueInDeliveryPage).getText();
    }


}
