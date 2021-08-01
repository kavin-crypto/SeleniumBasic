/*package NEW_FEATURES;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v91.emulation.Emulation;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class geolocation {
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","/Users/kavin/Downloads/chromedriver 2");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        DevTools devtool = driver.getDevTools();

        devtool.createSession();

        Map<String,Object> coordinates = new HashMap<>();

        coordinates.put("latitude",51);
        coordinates.put("longitude",10);
        coordinates.put("accuracy",1);

        driver.executeCdpCommand("Emulation.setGeolocationOverride",coordinates);
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("amazon", Keys.ENTER);
        driver.findElement(By.xpath("//*[contains(@class,'LC20lb DKV0Md')]")).click();
        //driver.findElement(By.xpath("//*[@data-hveid='CAEQAw']")).click();
        //System.out.println(driver.getTitle());






    }
}




 */