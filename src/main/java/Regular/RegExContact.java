package Regular;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExContact {

    public static void main(String[] args) {
//        WebDriver driver = new ChromeDriver();
//
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("https://www.epam.com/about/who-we-are/contact");
//
//        WebElement text = driver.findElement(By.cssSelector(" p:nth-child(1) > b > span > span"));
//        String fullText = text.getText();
//        System.out.println(fullText);
        System.out.println("-------------------");

        String fullText = "41 University Drive • Suite 202,\nNewtown, PA 18940 • USA";
        String regEx = "^(.+),\\n(.+),(.+)$";
        String fullPath = getData(fullText, regEx, 0);
        String zipCountry = getData(fullText, regEx, 3);
        String streetNumStreet = getData(fullText, regEx, 1);

//        String streetNumber = getData(streetNumStreet, ".[0-9]", 0);
        String streetNumber = getData(fullText, "^\\d.");
        String streetName = getData(fullText, "([A-Z]\\w+.\\w+.+\\d)");
        String city = getData(fullText, "^(.+),\\n(.+),(.+)$", 2);
//        String zip = getData(zipCountry,"(.+\\d)",0);
        String zip = getData(fullText, "([A-Z]{2}\\s\\d+)");
        String country = getData(zipCountry,"(.+\\d)(.+\\W)(.+)",3);

        System.out.println(streetNumber);
        System.out.println(streetName);
        System.out.println(city);
        System.out.println(zip);
        System.out.println(country);
//        driver.close();
    }

    public static String getData(String text, String regEx, int group){
        Pattern replacementPattern = Pattern.compile(regEx);
        Matcher matcher = replacementPattern.matcher(text);
        matcher.find();
        return matcher.group(group);
    }

    public static String getData(String text, String regEx){
        String matchesValue = "";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);
            if (matcher.find()){
                matchesValue = matcher.group();
            }
        return matchesValue;
    }
}
