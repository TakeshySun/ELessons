package GlossUa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class MainPageGloss {
    WebDriver driver;
    By articleNamesOnPage = By.cssSelector("h4");
    By articleDescriptionsOnPage = By.cssSelector("a > p");
    By allUrlsOnPage = By.xpath("//a[contains(@href, 'https')]");

    public MainPageGloss(WebDriver driver) {
        this.driver = driver;
    }

    public Map<String,String> returnAllArticleNames(){
        List<WebElement> elements = driver.findElements(articleNamesOnPage);
        List<WebElement> elements1 = driver.findElements(articleDescriptionsOnPage);
        Map<String, String> items = new LinkedHashMap<>();
        int counter = 0;
        for (int i=0; i<elements.size(); i++) {
            ++counter;
            items.put(elements.get(i).getText(), elements1.get(i).getText() + "\n");
        }

        System.out.println("Found " + counter);
        return items;
    }

    public void returnAllUniqueUrls(){
        List<WebElement> links = driver.findElements(allUrlsOnPage);
        Set<String> setList = new LinkedHashSet<>();
        System.out.println(links.size());
        for (WebElement link : links) {
            setList.add(link.getAttribute("href")  + "\n");
        }
        System.out.println(setList);

    }

    public void scrollPageToTheEnd(){
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void stopPageLoading(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return window.stop");
    }

}
