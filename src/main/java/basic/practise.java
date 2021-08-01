package basic;

import Browser_invoke.browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

class SelectMod {
    public static void sat(WebDriver driver,WebElement locator,String text){
        Select sel = new Select(locator);
        sel.selectByVisibleText(text);
    }
}



public  class practise extends browser {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Browser();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://courses.letskodeit.com/practice");

        //alert
        driver.findElement(By.xpath("//*[@name=\"enter-name\"]")).sendKeys("hello");
        driver.findElement(By.xpath("//*[@id=\"alertbtn\"]")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

        //frame
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@name=\"iframe-name\"]")));
        //driver.switchTo().frame("courses-iframe");
        SelectMod.sat(driver,driver.findElement(By.xpath("//*[@name=\"categories\"]")),"Selenium WebDriver");
        driver.findElement(By.cssSelector(".zen-course-title.dynamic-text")).click();

        driver.navigate().back();
        driver.switchTo().defaultContent();
        driver.findElement(By.id("benzradio")).click();

        //multi tab
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[contains(text(),'Multiple Windows')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Click Here')]")).click();
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        System.out.println(driver.getTitle());
        driver.switchTo().window(tab.get(0));
        System.out.println(driver.findElement(By.xpath("//*[contains(@class,'example')]/h3")).getText());
        driver.navigate().back();

        //frame

        driver.findElement(By.xpath("//*[contains(text(),'Nested Frames')]")).click();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]")).getText());
        driver.switchTo().defaultContent();


    }
}
