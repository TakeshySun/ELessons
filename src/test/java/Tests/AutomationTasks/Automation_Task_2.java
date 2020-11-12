package Tests.AutomationTasks;

import Pages.B2C_Accelerator.Page.MainPage;
import Pages.PropertyReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

/*
Завдання 2
Написати тест, з такими кроками:
- зайти на сторінку, вивести на екран назву сторіки та її url
- перейти на іншу сторінку та вивести на екран назву сторіки та її url
- повернутись, перезакгрузити сторінку, та вивести на екран назву сторіки та її url
 */
public class Automation_Task_2 {
    WebDriver driver;
    MainPage mainPage;

    @Before
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(PropertyReader.getProperties("url"));
        mainPage = new MainPage();
    }

    @Test
    public void printPageTitleAndUrl(){
//        - зайти на сторінку, вивести на екран назву сторіки та її url
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        System.out.println();
//        - перейти на іншу сторінку та вивести на екран назву сторіки та її url
        mainPage.clickNavLinkByText("Brands");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        System.out.println();
//        - повернутись, перезагрузити сторінку, та вивести на екран назву сторіки та її url
        driver.navigate().back();
        driver.navigate().refresh();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
