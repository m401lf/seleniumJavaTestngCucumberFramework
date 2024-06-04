package testScripts.streams.sortedDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.GlobalVars;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;

public class toList_sorted {
    WebDriver driver;

    @Test
    public void sorted_assert() {

        driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();


        List<WebElement> topMenuList = driver.findElements(By.xpath("/html/body/nav/div/div/ul/li"));

        List<String> originalList = topMenuList.stream()
                .parallel()
                //.filter(s-> s.getText().startsWith("Home"))
                .filter(s-> s.isDisplayed() && s.isEnabled())
                .map(WebElement::getText)
                .toList();

        List<String> sortedList = originalList.stream().sorted().toList();

        //topMenuList.stream().parallel().map(WebElement::getText).forEach(System.out::println);
        System.out.println("======================originalList===========================");
        System.out.println(originalList);

        //originalList.stream().sorted().forEach(System.out::println);

        System.out.println("=============forEach print i items===========");
        originalList.stream().sorted().forEach(s-> System.out.println("forEach print i items" +s));

        System.out.println("=========================sortedList===========================");
        System.out.println(sortedList);

        Assert.assertTrue(sortedList.contains(originalList.get(4)));
        Assert.assertTrue(sortedList.contains(originalList.get(3)));
        Assert.assertTrue(sortedList.contains(originalList.get(2)));
        Assert.assertTrue(sortedList.contains(originalList.get(1)));
        Assert.assertTrue(sortedList.contains(originalList.get(0)));

        //Assert.assertTrue(originalList.contains(sortedList));

        System.out.println("======================sortedNaturalOrder=============================");
        List<String> sortedNaturalOrder = originalList.stream().sorted(Comparator.naturalOrder()).toList();
        System.out.println(sortedNaturalOrder);
        System.out.println("======================sortedReversedOrder=============================");
        List<String> sortedReversedOrder = originalList.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(sortedReversedOrder);

    }

}
