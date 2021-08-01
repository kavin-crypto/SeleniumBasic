package basic;

import Browser_invoke.browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class flight extends browser {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Browser();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.findElement(By.xpath("//*[contains(@class,'cart')]/a[3]")).click();
        ArrayList<String> tab =new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));

        //Selecting country
        driver.findElement(By.xpath("//*[@id='autosuggest']")).sendKeys("co");
        List<WebElement> country = driver.findElements(By.xpath("//*[contains(@class,'ui-menu-item')]/a"));

        for(WebElement i : country )
        {
            if(i.getText().equalsIgnoreCase("Mexico"))
            {
                i.click();
            }
        }

        //Departure city
        driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).click();

        List<WebElement> from = driver.findElements(By.xpath("//*[contains(@class,'mapbg')]//ul/li/a[1]"));
        //Thread.sleep(2000);
        for (WebElement departure:from)
        {
            if(departure.getText().equalsIgnoreCase("Kochi (COK)"))
            {
                departure.click();
            }
        }
        String con = driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).getAttribute("value");
        Assert.assertEquals("Kochi (COK)",con);


        //Arrival city
        List<WebElement> to = driver.findElements(By.xpath("//*[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//ul/li/a"));
        for (WebElement Arrival:to)
        {
            if(Arrival.getText().equalsIgnoreCase("Dubai, All Airports(DWC) (DXB)"))
            {
                Arrival.click();
            }
        }
        String arrivalcity = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).getAttribute("value");
        Assert.assertEquals("Dubai, All Airports(DWC) (DXB)",arrivalcity);

        //DEPART DATE
        driver.findElement(By.xpath("//*[contains(@class,'ui-state-default ui-state-highlight')]")).click();
        //driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        if(driver.findElement(By.id("spclearDate")).getAttribute("class").contains("disabled"))
        {
            System.out.println("is disabled");
        }else
            {
                System.out.println("is enabled");
            }

        //PASSENGERS
        driver.findElement(By.xpath("//*[@id=\"divpaxinfo\"]")).click();
        for(int i=1;i<5;i++)
        {
            driver.findElement(By.id("hrefIncChd")).click();
        }

        //CURRENCY
        Select sel = new Select(driver.findElement(By.xpath(" //*[@id='ctl00_mainContent_DropDownListCurrency']")));
        sel.selectByVisibleText("USD");

        //Discount
        List<WebElement> dis = driver.findElements(By.xpath("//*[@id='discount-checkbox']/div"));
        System.out.println(dis.size());
        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();

        driver.quit();
    }

}
