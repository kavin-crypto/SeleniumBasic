package basic;

import Browser_invoke.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class fb_basic1 extends browser {
    public static void main(String[] args)
    {
        WebDriver driver = Browser();

        driver.get("https://en-gb.facebook.com/");
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("hello");
        driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("!@#$F");
        driver.findElement(By.xpath("//*[@name=\"login\"]")).click();


    }
}
