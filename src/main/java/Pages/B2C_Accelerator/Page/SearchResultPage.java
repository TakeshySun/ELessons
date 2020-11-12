package Pages.B2C_Accelerator.Page;

import Pages.AbstarctClasses.BasePage;
import org.openqa.selenium.By;

public class SearchResultPage extends BasePage {

    public void openProductFromSearchResults(String productDescriptionWithoutName){
        String containsName = "//div[contains(text(),'%s')]/../a[2]";
        driver.findElement(By.xpath(String.format(containsName,productDescriptionWithoutName))).click();
    }

}
