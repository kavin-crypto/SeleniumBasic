package basic;

import Browser_invoke.browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Irctc extends browser {
    public static void main(String[] args) {
        WebDriver driver = Browser();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.irctc.co.in/nget/train-search");
        driver.findElement(By.cssSelector(".text-center.col-xs-12 button")).click();
        driver.findElement(By.xpath("(//*[@type=\"text\"])[3]")).click();
        driver.findElement(By.xpath("(//*[@role='searchbox'])[1]")).click();
        //dp.From().sendKeys("Ben");
        driver.findElement(By.xpath("(//*[@role='searchbox'])[1]")).sendKeys("Ben");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pr_id_1_list']/li/span")));
        List<WebElement> from = driver.findElements(By.xpath("//*[@id='pr_id_1_list']/li/span"));
        for (WebElement i : from) {
            if (i.getText().equalsIgnoreCase("KSR BENGALURU - SBC")) {
                i.click();
                break;
            }
        }
        driver.findElement(By.xpath("(//*[@role='searchbox'])[2]")).click();
        driver.findElement(By.xpath("(//*[@role='searchbox'])[2]")).sendKeys("MGR");
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@id='pr_id_2_list']/li/span"))));
        List<WebElement> to = driver.findElements(By.xpath("//*[@id='pr_id_2_list']/li/span"));
        for (WebElement j : to) {
            if (j.getText().equalsIgnoreCase("MGR CHENNAI CTL - MAS")) {
                j.click();
                break;
            }
        }


        while (!driver.findElement(By.xpath("//*[contains(@class,'ui-datepicker-title ng-tns-c59-10')]/span[1]")).getText().contains("October")) {
            driver.findElement(By.cssSelector(".ui-datepicker-next.ui-corner-all.ng-tns-c59-10.ng-star-inserted")).click();
        }
        List<WebElement> day = driver.findElements(By.cssSelector(".ui-state-default.ng-tns-c59-10.ng-star-inserted"));

        for (int i = 0; i < day.size(); i++) {
            String num = day.get(i).getText();
            if (num.equalsIgnoreCase("15")) {
                day.get(i).click();
                break;
            }
        }
        driver.findElement(By.cssSelector("[type=\"submit\"]")).click();
    }

}
