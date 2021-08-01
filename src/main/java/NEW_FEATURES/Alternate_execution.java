/*package NEW_FEATURES;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import java.util.HashMap;
import java.util.Map;

public class Alternate_execution {
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","/Users/kavin/Downloads/chromedriver 2");
        ChromeDriver driver = new ChromeDriver();

        DevTools devtool = driver.getDevTools();

        devtool.createSession();

        Map<String,Object> deviceMatrix = new HashMap<>();

        deviceMatrix.put("width",375);
        deviceMatrix.put("height",812);
        deviceMatrix.put("deviceScaleFactor",75);
        deviceMatrix.put("mobile",true);
        deviceMatrix.put("screenHeight",1000);

        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride",deviceMatrix);
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.xpath("//*[contains(@class,'navbar-toggler-icon')]")).click();
        System.out.println(driver.getTitle());

    }
}
*/