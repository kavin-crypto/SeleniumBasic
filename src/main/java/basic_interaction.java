import Browser_invoke.browser;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class basic_interaction extends browser {


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = Browser();

        //radio functionality
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.xpath("//*[@value=\"radio2\"]")).click();
    

        WebElement text = driver.findElement(By.xpath("//*[@id=\"autocomplete\"]"));
        text.click();
        text.sendKeys("chennai");

        //select functionality
        Select opt = new Select(driver.findElement(By.xpath("//*[@id=\"dropdown-class-example\"]")));
        opt.selectByVisibleText("Option3");

        //checkbox functionality
        List<WebElement> inbox = driver.findElements(By.xpath("//*[@id=\"checkbox-example\"]//input"));
        int size = inbox.size();

        for (int i = 0; i < size; i++) {
            String box = inbox.get(i).getAttribute("value");
            if (box.equalsIgnoreCase("option1")) {
                continue;

            }
            inbox.get(i).click();
        }

        //js alert

        driver.findElement(By.xpath("//*[@name=\"enter-name\"]")).sendKeys("hello");
        driver.findElement(By.xpath("//*[@id=\"alertbtn\"]")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

        //frame
        /*driver.switchTo().frame("courses-iframe");
        driver.findElement(By.xpath("//*[contains(text(),'Job Support')]")).click();
        driver.switchTo().defaultContent();*/

        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//*[@id=\"mousehover\"]"))).perform();
        act.moveToElement(driver.findElement(By.xpath("//*[contains(@class,'mouse-hover-content')]/a[2]"))).click().perform();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.open()");

        ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());

        driver.switchTo().window(tab.get(1));
        driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");

        WebElement mission = driver.findElement(By.xpath("//*[contains(@class,'w25 moveleft')]/span[2]"));
        WebElement destination = driver.findElement(By.xpath("//*[@id=\"mydropzone\"]"));

        act.dragAndDrop(mission, destination).build().perform();


    }
}
