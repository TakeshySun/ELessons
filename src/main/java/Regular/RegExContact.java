package Regular;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExContact {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.epam.com/about/who-we-are/contact");

        WebElement text = driver.findElement(By.cssSelector(" p:nth-child(1) > b > span > span"));
        System.out.println(text.getText());
        String fullText = text.getText();
        System.out.println("-------------------");

//        String fullText = "41 University Drive • Suite 202,\nNewtown, PA 18940 • USA";
        String fullPath = getData(fullText, "^(.+),\\n(.+),(.+)$", 0);
        String zipCountry = getData(fullText, "^(.+),\\n(.+),(.+)$", 3);
        String streetNumStreet = getData(fullText, "^(.+),\\n(.+),(.+)$", 1);

        String streetNumber = getData(streetNumStreet, ".[0-9]", 0);
        String streetName = getData(streetNumStreet, "(.[0-9])(.+)", 2);
        String city = getData(fullText, "^(.+),\\n(.+),(.+)$", 2);
        String zip = getData(zipCountry,"(.+\\d)",0);
        String country = getData(zipCountry,"(.+\\d)(.+\\W)(.+)",3);

        System.out.println(streetNumber);
        System.out.println(streetName);
        System.out.println(city);
        System.out.println(zip);
        System.out.println(country);
        driver.close();
    }

    public static String getData(String text, String regEx, int group){
        Pattern replacementPattern = Pattern.compile(regEx);
        Matcher matcher = replacementPattern.matcher(text);
        matcher.find();
        return matcher.group(group);
    }

}
