package testScripts.SeleniumWebDriverWaitExample;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.GlobalVars;

import java.time.Duration;
import java.util.List;

public class WebDriverWaitExamples {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalVars.getImplicitWait()));
        driver.manage().window().setSize(new Dimension(1440, 900));
        driver.get("https://automationteststore.com/");
    }

    @Test
    public void WebdriverWait_TextToBePresentInElement() {
        WebElement loginOrRegisterLink = driver.findElement(By.cssSelector("ul#customer_menu_top>li>a"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait));
        wait.until(ExpectedConditions.textToBePresentInElement(loginOrRegisterLink, "Login or register"));

    }

    @Test
    public void WebdriverWait_Visibility() {
        WebElement loginOrRegisterLink = driver.findElement(By.cssSelector("ul#customer_menu_top>li>a"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait));
        wait.until(ExpectedConditions.visibilityOf(loginOrRegisterLink));
    }

    @Test
    public void WebdriverWait_ElementToBeClickable() {
        WebElement loginOrRegisterLink = driver.findElement(By.cssSelector("ul#customer_menu_top>li>a"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait));
        wait.until(ExpectedConditions.elementToBeClickable(loginOrRegisterLink));
    }
/*    @Test
    public void WebdriverWait_ElementToBeSelected() {
        WebElement loginOrRegisterLink = driver.findElement(By.cssSelector("ul#customer_menu_top>li>a"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait));
        wait.until(ExpectedConditions.elementToBeSelected(loginOrRegisterLink));
    }*/
    @Test
    public void WebdriverWait_Presence() {
        WebElement loginOrRegisterLink = driver.findElement(By.cssSelector("ul#customer_menu_top>li>a"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul#customer_menu_top>li>a")));
    }
/*    @Test
    public void WebdriverWait_Invisibility() {
        WebElement loginOrRegisterLink = driver.findElement(By.cssSelector("ul#customer_menu_top>li>a"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait));
        wait.until(ExpectedConditions.invisibilityOf(loginOrRegisterLink));
    }*/
/*    @Test
    public void WebdriverWait_Staleness() {
        WebElement loginOrRegisterLink = driver.findElement(By.cssSelector("ul#customer_menu_top>li>a"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait));
        wait.until(ExpectedConditions.stalenessOf(loginOrRegisterLink));
    }*/

    @Test
    public void WebdriverWait_VisibilityOfElementLocated() {
    WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));
    WebElement visibleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/header/div[1]/div/div[2]/div/div[3]/div/ul/li/a")));
    String elementText = visibleElement.getText();
    System.out.println(elementText);
    }

    @Test
    public void WebdriverWait_VisibilityOfAllElementsLocatedBy() {
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));
        List<WebElement> allVisibleElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div/header/div[1]/div/div[2]/div/div[3]/div/ul/li/a")));
        for (WebElement element : allVisibleElements) {
            System.out.println(element.getText());
        }
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
        System.out.println("Test Completed");
    }


}
