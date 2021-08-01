import Browser_invoke.browser;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

class AddItems {
    public static void items(WebDriver driver, String[] productNeeded) {

        List<WebElement> cart = driver.findElements(By.xpath("//*[contains(@class,'product')]/h4"));
        int o = 0;
        for (int i = 0; i < cart.size(); i++) {

            String[] name = cart.get(i).getText().split("-"); //by this vegetable name is splitted into two(i.e,Pears as index[0] and 1 kg[1] )
            String formatted = name[0].trim(); // this step is used to remove to whitespace

            List product = Arrays.asList(productNeeded);

            if (product.contains(formatted)) {
                //driver.findElements(By.xpath("//*[contains(@class,'product')]/button")).get(i).click();
                driver.findElements(By.xpath("//*[contains(@class,'product')]//a[2]")).get(i).click();
                if (formatted.equalsIgnoreCase("Beans")) {
                    driver.findElements(By.xpath("//*[contains(@class,'product')]//a[1]")).get(i).click();

                }

                driver.findElements(By.xpath("//*[contains(@class,'product')]/button")).get(i).click();
                o++;
                if (o == product.size()) {
                    break;
                }
            }


        }
    }
}

class Wait {
    public static void hold(WebDriver driver, String loctor) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loctor)));

    }

}

public class AdvanceVeg extends browser {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = Browser();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //selecting the vegetable

        String[] productNeeded = {"Pears", "Beans", "Walnuts"};
        AddItems.items(driver, productNeeded);

        //click the cart
        driver.findElement(By.xpath("//*[@alt=\"Cart\"]")).click();
        driver.findElements(By.xpath("//*[@class = 'cart-items']/li")).size();
        driver.findElement(By.xpath("//*[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        //calculating
        int totala = driver.findElements(By.xpath("//*[contains(@class,'products')]//tbody/tr/td[5]/p")).size();
        int sum = 0;
        for (int amount = 0; amount < totala; amount++) {

            String am = driver.findElements(By.xpath("//*[contains(@class,'products')]//tbody/tr/td[5]/p")).get(amount).getText();
            int amt = Integer.parseInt(am);
            sum = sum + amt;

        }

        String summ = Integer.toString(sum);
        String Tolamt = driver.findElement(By.xpath("//*[contains(@class,'totAmt')]")).getText();
        Assert.assertEquals(Tolamt, summ);

        //Applying discount
        driver.findElement(By.xpath("//*[contains(@class,'promoCode')]")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//*[contains(@class,'promoBtn')]")).click();
        String beforeDiscount = driver.findElement(By.xpath("//*[contains(@class,'discountAmt')]")).getText();

        Wait.hold(driver, "//*[contains(@class,'promoInfo')]");

        String verify = driver.findElement(By.xpath("//*[contains(@class,'promoInfo')]")).getText();
        Assert.assertEquals("Code applied ..!", verify);

        String afterDiscount = driver.findElement(By.xpath("//*[contains(@class,'discountAmt')]")).getText();
        Assert.assertNotEquals(beforeDiscount, afterDiscount);

        driver.findElement(By.xpath("//*[contains(text(),'Place Order')]")).click();

        Select country = new Select(driver.findElement(By.xpath("//*[contains(@class,'wrapperTwo')]//select")));
        country.selectByVisibleText("Switzerland");
        driver.findElement(By.xpath("//*[contains(@class,'chkAgree')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Proceed')]")).click();

        String[] last = driver.findElement(By.xpath("//*[contains(@class,'wrapperTwo')]/span")).getText().split(",");
        System.out.println(last[0]);

        File shot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(shot,new File("/Users/kavin/Documents/seleniumautomation/Basics/src/main/java/screenshot/AdvanceVeg.png"));

        driver.quit();


    }


}

