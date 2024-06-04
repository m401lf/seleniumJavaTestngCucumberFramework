package testScripts.SeleniumBasicCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Video_14_ClearCommand {

    @Test(enabled = true)
    public void f1() throws Exception {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://omayo.blogspot.com/");

        // The purpose clear command to clear the value from the textbox
        driver.findElement(By.id("textbox1")).clear();

        Thread.sleep(2000);
        driver.quit();

    }

}
