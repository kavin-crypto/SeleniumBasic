package basic;

import Browser_invoke.browser;
import org.openqa.selenium.*;
import org.testng.Assert;


import java.util.List;

public class Calendar extends browser {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Browser();

        driver.get("https://www.makemytrip.com/");
        driver.findElement(By.xpath("//*[contains(@class,'desktop in')]")).click();
        driver.findElement(By.xpath("//*[@for=\"departure\"]")).click();
        while (!driver.findElement(By.xpath("//*[contains(@class,'DayPicker-Caption')]/div")).getText().contains("January 2022")) {
            driver.findElement(By.xpath("//*[contains(@class,'DayPicker-NavBar')]/span[2]")).click();
        }
        List<WebElement> day = driver.findElements(By.cssSelector(".dateInnerCell p"));
        //int dayy = driver.findElements(By.cssSelector(".dateInnerCell p")).size();

        for (int i = 0; i < day.size(); i++) {
            String txt = day.get(i).getText();
            if (txt.equalsIgnoreCase("31")) {
                day.get(i).click();
                break;
            }
        }

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scroll(0,550)");
        Thread.sleep(1000);
        js.executeScript("document.querySelector(\".tableFixHead\").scroll(0,50)");
        int val = driver.findElements(By.xpath("//*[contains(@class,'tableFixHead')]//td[4]")).size();

        int sum = 0;
        for (int num = 0; num < val; num++) {
            String valu = driver.findElements(By.xpath("//*[contains(@class,'tableFixHead')]//td[4]")).get(num).getText();
            int value = Integer.parseInt(valu);
            sum = sum + value;
        }
        System.out.println(sum);
        String tot = driver.findElement(By.xpath("//*[contains(@class,'totalAmount')]")).getText().split(":")[1].trim();
        int total = Integer.parseInt(tot);
        Assert.assertEquals(sum, total);

        System.out.println(tot);

        int row = driver.findElements(By.xpath("//*[contains(@class,'table-display')]//tr")).size();
        System.out.println("Row: " + row);
        int column = driver.findElements(By.xpath("//*[contains(@class,'table-display')]//tr[1]/th")).size();
        System.out.println("Column: " + column);
        System.out.println(driver.findElement(By.xpath("//*[contains(@class,'table-display')]//tr[3]")).getText());

        driver.findElement(By.id("autocomplete")).sendKeys("sw");
        Thread.sleep(2000);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));


    }
}
