import Browser_invoke.browser;
import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class makemytrip extends browser {

    private static Logger log = LogManager.getLogger(makemytrip.class.getName());
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = Browser();
        log.info("Landing on makemytrip homepage");
        driver.get("https://www.makemytrip.com/");
        driver.findElement(By.xpath("//*[contains(@class,'desktop in')]")).click();

        driver.findElement(By.xpath("//*[@for='fromCity']")).click();
        driver.findElement(By.xpath("//*[@ placeholder ='From']")).sendKeys("New");

        List<WebElement> from_location = driver.findElements(By.xpath("//*[@id='react-autowhatever-1']/div/ul/li/div/div[2]"));

        //System.out.println("Lenght of From location:" +from_location.size());
        Thread.sleep(1000);
        for (WebElement i : from_location) {
            if (i.getText().contains("KGK")) {
                log.info("Departure country: " + i.getText());
                i.click();
                break;

            }

        }

        driver.findElement(By.xpath("//*[@placeholder='To']")).sendKeys("Aus");
        List<WebElement> to_location = driver.findElements(By.xpath("//*[@role='option']/div/div[2]"));

        Thread.sleep(1000);
        for (WebElement loc : to_location) {
            if (loc.getText().contains("WOL")) {
                log.info("Destination country: " + loc.getText());
                loc.click();
                break;
            }

        }


        while (!driver.findElement(By.cssSelector(".DayPicker-Caption")).getText().contains("December")) {
            driver.findElement(By.cssSelector(".DayPicker-NavButton--next")).click();
        }
        List<WebElement> date = driver.findElements(By.cssSelector(".dateInnerCell"));
        for (int i = 0; i < date.size(); i++) {
           String dates =  date.get(i).getText();
            if(dates.contains("27")){
                date.get(i).click();
                break;
            }
        }


        driver.findElement(By.xpath("//*[contains(@class,'DayPicker-Months')]/div[2]/div[3]/div[3]/div[5]")).click();

        driver.findElement(By.xpath("//*[contains(@class,'primaryBtn')]")).click();

        //driver.quit();


    }

}
