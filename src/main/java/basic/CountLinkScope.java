package basic;

import Browser_invoke.browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CountLinkScope extends browser {
    public static void main(String[] args) {

        WebDriver driver = Browser();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        int count = driver.findElements(By.tagName("a")).size();
        System.out.println("Allow link size:" + count);
        System.out.println("Footer link size:" + driver.findElements(By.xpath("//*[@id='gf-BIG']//a")).size());
        System.out.println("Particular column link size:" + driver.findElements(By.xpath("//*[@id='gf-BIG']//td[1]//a")).size());
        int len = driver.findElements(By.xpath("//*[@id='gf-BIG']//td[1]//a")).size();

        for (int i = 0; i < len; i++) {
            String clickLink = Keys.chord(Keys.COMMAND, Keys.ENTER);
            driver.findElements(By.xpath("//*[@id='gf-BIG']//td[1]//a")).get(i).sendKeys(clickLink);
        }
        Set<String> tab = driver.getWindowHandles();
        Iterator<String> newTab = tab.iterator();

        while (newTab.hasNext()) { //hasNext--> will check whether next index is present or not

            driver.switchTo().window(newTab.next()); //next--> it moves to next
            System.out.println(driver.getTitle());
        }




    }
}
