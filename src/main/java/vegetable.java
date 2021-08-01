import Browser_invoke.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class vegetable extends browser {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Browser();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[contains(@class,'search-keyword')]")).sendKeys("ca");
        Thread.sleep(3000);
        List<WebElement> cart = driver.findElements(By.xpath("//*[contains(@class,'product')]//button"));


        for(WebElement i : cart)
        {
            i.click();
        }

        driver.findElement(By.xpath("//*[@alt=\"Cart\"]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        int price = driver.findElements(By.xpath("//*[contains(@class,'products')]//tbody/tr/td[4]/p")).size();
        int totala = driver.findElements(By.xpath("//*[contains(@class,'products')]//tbody/tr/td[5]/p")).size();
        int sum = 0;
        for(int amount=0;amount<price;amount++)
        {
            for(int asd=0;asd<totala;asd++)
            {
                if(amount == asd)
                {
                    Assert.assertEquals(amount,asd);
                }
            }
            String am = driver.findElements(By.xpath("//*[contains(@class,'products')]//tbody/tr/td[4]/p")).get(amount).getText();
            int amt=Integer. parseInt(am);
            sum= sum+amt;

        }
        //System.out.println(sum);
        String summ = Integer.toString(sum);
        String Tolamt = driver.findElement(By.xpath("//*[contains(@class,'totAmt')]")).getText();
        //System.out.println(Tolamt);
        Assert.assertEquals(summ,Tolamt);

        driver.findElement(By.xpath("//*[contains(@class,'promoCode')]")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//*[contains(@class,'promoBtn')]")).click();
        String beforeDiscount = driver.findElement(By.xpath("//*[contains(@class,'discountAmt')]")).getText();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class,'promoInfo')]")));
        String verify = driver.findElement(By.xpath("//*[contains(@class,'promoInfo')]")).getText();
        Assert.assertEquals("Code applied ..!", verify);
        String afterDiscount = driver.findElement(By.xpath("//*[contains(@class,'discountAmt')]")).getText();
        Assert.assertNotEquals(beforeDiscount,afterDiscount);
        driver.findElement(By.xpath("//*[contains(text(),'Place Order')]")).click();

        Select country = new Select(driver.findElement(By.xpath("//*[contains(@class,'wrapperTwo')]//select")));
        country.selectByVisibleText("Switzerland");
        driver.findElement(By.xpath("//*[contains(@class,'chkAgree')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Proceed')]")).click();

        System.out.println(driver.findElement(By.xpath("//*[contains(@class,'wrapperTwo')]/span")).getText());

        driver.quit();




    }

}
