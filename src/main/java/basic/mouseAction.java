package basic;

import Browser_invoke.browser;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class mouseAction extends browser {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = Browser();

        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("amazon",Keys.ENTER);


        Actions act = new Actions(driver);
        WebElement clk = driver.findElement(By.xpath("(//*[contains(@class,'LC20lb DKV0Md')])[1]"));
        act.moveToElement(clk).click().perform();
        WebElement txt = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        act.moveToElement(txt).click().keyDown(Keys.SHIFT).sendKeys("chair").perform();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.open()");

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.findElement(By.xpath("/html/body/a")).click();
        driver.switchTo().window(tabs.get(2));


    }

}
