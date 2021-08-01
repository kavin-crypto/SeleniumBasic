///*package NEW_FEATURES;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.v91.emulation.Emulation;
//
//import java.util.Optional;
//import java.util.concurrent.TimeUnit;
//
//
///*In this,we can perform webtesting for mobile browsers without using external s/w (appium),
//the screen size is converted into mobile size
// */
//public class Emulate_toggle {
//    public static void main(String[] args)
//    {
//        //chromium driver
//        System.setProperty("webdriver.chrome.driver","/Users/kavin/Downloads/chromedriver 2");
//
//        ChromeDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().fullscreen();
//        DevTools dev = driver.getDevTools();
//
//        dev.createSession(); //it's interface b/w selenium code and chrome browser
//
//        //After creating session now ,send command to cdp
//        dev.send(Emulation.setDeviceMetricsOverride(375,812,75,true, Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty()));
//
//
//        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
//
//        driver.findElement(By.xpath("//*[contains(@class,'navbar-toggler-icon')]")).click();
//        driver.findElement(By.xpath("//*[contains(text(),'Library')]")).click();
//        driver.quit();
//    }
//}
//
