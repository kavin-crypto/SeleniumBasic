package basic;

import Browser_invoke.browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class mice extends browser {
    public static void main(String[] args) {
        WebDriver driver = Browser();


        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.findElement(By.xpath("/html/body/a")).click();
        ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());

        driver.switchTo().window(tab.get(1));
        //System.out.println(driver.findElement(By.xpath("//*[contains(@class,'im-para red')]")).getText().split("at")[1].trim().split("with")[0].trim());
        String username = driver.findElement(By.xpath("//*[contains(@class,'im-para red')]/strong")).getText();

        driver.switchTo().window(tab.get(0));
        driver.findElement(By.cssSelector("#username")).sendKeys(username);

        driver.findElement(By.id("password")).sendKeys("1234567asfsrdh");
        Select sel = new Select(driver.findElement(By.xpath("//*[contains(@class,'form')]/div[5]/select")));
        sel.selectByVisibleText("Consultant");

        driver.findElement(By.cssSelector("#signInBtn")).click();
    }
}
