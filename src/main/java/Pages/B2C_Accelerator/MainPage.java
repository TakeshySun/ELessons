package Pages.B2C_Accelerator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    WebDriver driver;

    By brandsMainLocator = By.cssSelector("[title~=Brands]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickNavLinkBrands(){
        driver.findElement(brandsMainLocator).click();
    }
}
