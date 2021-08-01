import Browser_invoke.browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class practise1 extends browser {
    public static void main(String[] args) {

        WebDriver driver = Browser();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.xpath("//*[@id=\"checkBoxOption3\"] ")).click();
        String tvt = driver.findElement(By.xpath("//*[@for=\"honda\"]")).getText();
        WebElement drop = driver.findElement(By.id("dropdown-class-example"));
        Select sec = new Select(drop);
        sec.selectByVisibleText(tvt);
        driver.findElement(By.cssSelector("#name")).sendKeys(tvt);
        driver.findElement(By.cssSelector("#alertbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        String alertText = driver.switchTo().alert().getText();
        if (alertText.contains(tvt)) {
            System.out.println("Selected option present");
        } else {
            System.out.println("Selected option notpresent");
        }
        driver.switchTo().alert().accept();



    }
}


