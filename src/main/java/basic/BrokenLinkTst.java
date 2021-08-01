package basic;

import Browser_invoke.browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class BrokenLinkTst extends browser {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = Browser();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//        int ink = driver.findElements(By.xpath("//*[@id='gf-BIG']//td[2]/ul/li/a")).size();
//        for(int i=0;i<ink;i++){
//            String tab = Keys.chord(Keys.COMMAND,Keys.ENTER);
//            driver.findElements(By.xpath("//*[@id='gf-BIG']//td[2]/ul/li/a")).get(i).sendKeys(tab);
//        }
//
//        Set<String> tabs = driver.getWindowHandles();
//        Iterator<String> nexxt = tabs.iterator();
//
//        while (nexxt.hasNext()){
//            driver.switchTo().window(nexxt.next());
//            System.out.println(driver.getTitle());
//        }
        String url1 = driver.findElement(By.xpath("//*[@id='gf-BIG']//td[1]/ul/li[2]/a")).getAttribute("href");
        String url2 = driver.findElement(By.xpath("//*[@id='gf-BIG']//td[2]/ul/li[2]/a")).getAttribute("href");

//        HttpURLConnection ulrs = (HttpURLConnection) new URL(url1).openConnection();
//        ulrs.setRequestMethod("HEAD");
//        ulrs.connect();
//        int con = ulrs.getResponseCode();
//        System.out.println(con);

        List<WebElement> link = driver.findElements(By.xpath("//*[@id='gf-BIG']//td/ul/li/a"));
        SoftAssert ast = new SoftAssert();
        for (WebElement links : link) {
            String url = links.getAttribute("href");
            HttpURLConnection lrs = (HttpURLConnection) new URL(url).openConnection();
            lrs.setRequestMethod("HEAD");
            lrs.connect();
            int conn = lrs.getResponseCode();
            System.out.println(conn);
            ast.assertFalse(conn > 400,"The Broken link name is: " + links.getText() + ",and broken link code is: " + conn);
//            if (conn > 400) {
//                System.out.println("The Broken text is: " + links.getText() + " ,and broken link code is: " + conn);
//
//            }

        }
        ast.assertAll();

    }
}
