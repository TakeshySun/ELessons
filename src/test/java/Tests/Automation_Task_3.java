package Tests;
/*
Завдання 3
Робота з багатьма елементами:
- зайти на сторінку https://gloss.ua/
- вивести на екран список усіх залоголовків статтей, які є на головній сторінці
- вивести на екран список усіх силок (унікальних), які є на головній сторінці
 */

import Pages.GlossUa.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Automation_Task_3 {
    WebDriver driver;
    MainPage mainPage;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Oleksandr_Eskin\\IdeaProjects\\Epa_Lessons\\chromedriver.exe");
        driver.get("https://gloss.ua");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
//    @Ignore
    public void printAllNewsTitles(){

        mainPage.stopPageLoading();
        System.out.println(mainPage.returnAllArticleNames());
    }

    @Test
    public void printAllNewsUrls(){
       mainPage.returnAllUniqueUrls();
    }

    @After
    public void quit(){
        driver.quit();
    }
}
