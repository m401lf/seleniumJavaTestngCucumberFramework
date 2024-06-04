package testScripts.Selenium4_New_Features;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

////@Listeners(testComponents.Listeners.class)

public class RelativeLocatorsSelenium4 {
    public WebDriver driver;

/*

  Selenium 4 - Relative Locators
  ==============================

  below - Login page of TutorialsNinja.com/demo
  toRightOf - Search button beside Search Text Field
  below and toLeftOf - Submit button (Get Text)
  toRightOf and toLeftOf - Login button (Get Text)
  below - compendium dev link
  below and above - compendium and theautomationtester
  near - Search button (Click)

  */


    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/documentation/webdriver/elements/locators/#available-relative-locators");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();

    }

    @Test(description = "Relative locator using below()")
    public void relativeLocatorUsing_below() {
        By passwordLocator = RelativeLocator.with(By.tagName("input")).below(By.id("email"));
        WebElement belowEmail = driver.findElement(passwordLocator);
        belowEmail.sendKeys("pass");
    }

    @Test(description = "Relative locator using above()")
    public void relativeLocatorUsing_above() {

        By emailLocator = RelativeLocator.with(By.tagName("input")).above(By.id("password"));
        WebElement AbovePassword = driver.findElement(emailLocator);
        AbovePassword.sendKeys("emailAddress@email.com");

    }

//    @Test(description = "Relative locator using toRightOf")
//    public void relativeLocatorUsing_toRightOf() {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        driver.get("http://localhost/opencartshop/index.php?route=account/login");
//
//        String keyword = "iMac";
//        WebElement searchBox = driver.findElement(By.cssSelector("input[placeholder='Search']"));
//        WebElement searchButton_toRightOf = driver.findElement(RelativeLocator.with(By.tagName("span")).toRightOf(searchBox));
//        searchBox.click();
//        searchBox.sendKeys(keyword);
//        searchButton_toRightOf.click();
//
//    }
//
//    @Test(description = "Relative locator using toLeftOf()")
//    public void relativeLocatorUsing_toLeftOf() {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        driver.get("http://localhost/opencartshop/index.php?route=account/login");
//
//        String keyword = "iMac";
//        WebElement searchButton = driver.findElement(By.cssSelector("i.fa.fa-search"));
//        WebElement searchBox_toLeftOf = driver.findElement(RelativeLocator.with(By.tagName("input")).toLeftOf(searchButton));
//        searchBox_toLeftOf.click();
//        searchBox_toLeftOf.sendKeys(keyword);
//        searchButton.click();
//
//    }
//
//    @Test(description = "Relative locator using WebDriverWait")
//    public void relativeLocatorUsingWebDriverWait() {
//        driver.get("http://localhost/opencartshop/index.php?route=account/login");
//        String emailAddress = "admin@admin.com";
//        String pass = "Password";
//        WebElement email = driver.findElement(By.id("input-email"));
//        WebElement password = driver.findElement(By.id("input-password"));
//        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Login']"));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        wait.until(ExpectedConditions.visibilityOf(email)).sendKeys(emailAddress);
//        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(pass);
//        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
//
//    }

}