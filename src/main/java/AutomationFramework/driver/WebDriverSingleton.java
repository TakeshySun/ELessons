package AutomationFramework.driver;

import java.util.concurrent.TimeUnit;

import AutomationFramework.AbstarctClasses.BasePage;
import AutomationFramework.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverSingleton
{
    private WebDriver webDriver;
    protected static BasePage basePage;

    public void initialize(String browser)
    {
        //Use Of Singleton Concept and Initialize webDriver
        if(webDriver == null)
        {
            switch (browser) {
                case "chrome":
//                    System.setProperty("webdriver.chrome.driver", "\\chromedriver.exe");
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--ignore-certificate-errors");
                    webDriver = new ChromeDriver(options);
                    basePage =new BasePage();
                    basePage.setWebDriver(webDriver);
                    break;
                case "Firefox":
//                    System.setProperty("webdriver.gecko.driver", "\\geckodriver.exe");
                    FirefoxOptions options1 = new FirefoxOptions();
                    options1.addArguments("--ignore-certificate-errors");
                    webDriver = new FirefoxDriver(options1);
                    basePage =new BasePage();
                    basePage.setWebDriver(webDriver);
                    break;
            }
        }

        //Perform Basic Operations
        webDriver.manage().deleteAllCookies();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    public void quit()
    {
        webDriver.quit();
        webDriver =null; // we destroy the driver object after quit operation
    }

    public void close()
    {
        webDriver.close();
        webDriver =null;  // we destroy the driver object after quit operation
    }

    public  void openurl(String KEY) throws Exception {
        webDriver.get(PropertyReader.getProperties(KEY));
    }

}

