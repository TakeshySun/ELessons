package Tests;

import Pages.B2C_Accelerator.MainPage;
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
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Oleksandr_Eskin\\IdeaProjects\\Epa_Lessons\\chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ecsc00a07e9f.epam.com:9002/yacceleratorstorefront/?site=electronics");
    }

    @Test
    public void printPageTitleAndUrl(){
        mainPage = new MainPage(driver);
//        - зайти на сторінку, вивести на екран назву сторіки та її url
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        System.out.println();
//        - перейти на іншу сторінку та вивести на екран назву сторіки та її url
        mainPage.clickNavLinkBrands();
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
