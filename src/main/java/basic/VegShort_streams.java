package basic;

import Browser_invoke.browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VegShort_streams extends browser {
    public static void main(String[] args) {
        WebDriver driver = Browser();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        driver.findElement(By.linkText("Top Deals")).click();

        ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));

        //driver.findElement(By.cssSelector("#page-menu")).click();
        //driver.findElement(By.cssSelector(".sort-icon.sort-descending")).click();
        List<WebElement> names = driver.findElements(By.xpath("//td[1]"));

        List<String> originalList = names.stream().map(s -> s.getText()).collect(Collectors.toList());

        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        //Assert.assertTrue(originalList.equals(sortedList));

        for (WebElement i : names) {
            if (i.getText().equalsIgnoreCase("Strawberry")) {
                System.out.println("Actual price: " + i.findElement(By.xpath("following::td[1]")).getText());
                System.out.println("Discount price: " + i.findElement(By.xpath("following::td[2]")).getText());
            }
        }

        //By streams
        List<String> price = names.stream().filter(s -> s.getText().contains("Potato")).map(s -> veggiesPrice(s)).collect(Collectors.toList());
        price.stream().forEach(q -> System.out.println(q));


        //Pagination
        List<String> priceV;
        do {
            List<WebElement> vegNames = driver.findElements(By.xpath("//td[1]"));
            priceV = vegNames.stream().filter(s -> s.getText().contains("Cheese")).map(s -> veggiesPrice(s)).collect(Collectors.toList());
            priceV.stream().forEach(q -> System.out.println("Pagination veg: " +q));

            if (priceV.size() < 1) {
                driver.findElement(By.cssSelector("*[aria-label='Next']")).click();
            }
        } while (priceV.size() < 1);


        //filter search
        driver.findElement(By.cssSelector("#search-field")).sendKeys("Orange");
        List<WebElement> vegName = driver.findElements(By.xpath("//td[1]"));
        List<String> pie = vegName.stream().filter(s -> s.getText().contains("Orange")).map(s-> veggiesPrice(s)).collect(Collectors.toList());
        pie.stream().filter(w->w.contains("Orange")).count();
        pie.stream().forEach(i->System.out.println("filtered veg: "+i));
        Assert.assertEquals(vegName.size(),pie.size());
        

    }



    private static String veggiesPrice(WebElement s) {
        String val = s.findElement(By.xpath("following::td[1]")).getText();

        return val;
    }
}
