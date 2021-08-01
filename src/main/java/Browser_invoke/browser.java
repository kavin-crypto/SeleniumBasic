package Browser_invoke;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class browser {
    public static WebDriver Browser() { //public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {


        System.setProperty("webdriver.chrome.driver", "/Users/kavin/Downloads/chromedriver-3");
        DesiredCapabilities chrom = DesiredCapabilities.chrome();
        chrom.acceptInsecureCerts();
        ChromeOptions options = new ChromeOptions();
        options.merge(chrom);
        options.addArguments("incognito");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }
}
