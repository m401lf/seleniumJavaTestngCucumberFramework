package helper.frame;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHelper {

    private Logger log = LogManager.getLogger(this.getClass());
    WebDriver driver;

    public FrameHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToFrame(int frameIndex) {
        driver.switchTo().frame(frameIndex);
        log.info("switched to :" + frameIndex + " frame");

    }

    public void switchToFrame(String frameName) {
        driver.switchTo().frame(frameName);
        log.info("switched to :" + frameName + " frame");

    }

    public void switchToFrame(WebElement element) {
        driver.switchTo().frame(element);
        log.info("switched to frame " + element.toString());
    }
}
