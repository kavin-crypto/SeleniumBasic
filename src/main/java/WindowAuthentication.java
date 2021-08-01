import Browser_invoke.browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class WindowAuthentication {

    public static void main(String[] args) throws AWTException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://admin:admin@the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Basic Auth")).click();
        driver.navigate().back();
        driver.findElement(By.linkText("File Upload")).click();
        driver.findElement(By.id("file-upload")).click();//.sendKeys("/Users/kavin/Desktop/sarathy resume.docx");
        //driver.findElement(By.id("file-submit")).click();
        Thread.sleep(9000);

        Robot rob = new Robot();

        StringSelection sel = new StringSelection("/Users/kavin/Desktop/sarathy resume.docx");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);

        rob.keyPress(KeyEvent.VK_CONTROL);
        rob.keyPress(KeyEvent.VK_V);

        rob.keyRelease(KeyEvent.VK_CONTROL);
        rob.keyRelease(KeyEvent.VK_V);

        rob.keyPress(KeyEvent.VK_ENTER);
        rob.keyRelease(KeyEvent.VK_ENTER);

    }

}
