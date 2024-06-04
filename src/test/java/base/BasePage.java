package base;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.google.common.util.concurrent.Uninterruptibles;
import helper.alert.AlertHelper;
import helper.assertion.VerificationHelper;
import helper.frame.FrameHelper;
import helper.javaScript.JavaScriptHelper;
import helper.javaScript.ScrollPageHelper;
import helper.select.DropDownHelper;
import helper.wait.WaitHelper;
import helper.window.WindowHelper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.GlobalVars;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BasePage {

    final static Logger log = LogManager.getLogger(BasePage.class);
    WebDriver driver;
    protected WebDriverWait wait;
    protected VerificationHelper verificationHelper;
    protected JavaScriptHelper javaScriptHelper;
    protected WaitHelper waitHelper;
    protected WindowHelper windowHelper;
    protected AlertHelper alertHelper;
    protected DropDownHelper dropDownHelper;
    protected ScrollPageHelper scrollPageHelper;
    protected FrameHelper frameHelper;



    public BasePage(WebDriver driver) {
        this.driver = driver;
        waitHelper = new WaitHelper(driver);
        javaScriptHelper = new JavaScriptHelper(driver);
        verificationHelper = new VerificationHelper(driver);
        windowHelper = new WindowHelper(driver);
        alertHelper = new AlertHelper(driver);
        dropDownHelper = new DropDownHelper(driver);
        scrollPageHelper = new ScrollPageHelper(driver);
        frameHelper = new FrameHelper(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "/html/body/div[2]/div/aside/div/a")
    List<WebElement> sideWidgetLinks;
    @FindBy(css = ".//*")
    private List<WebElement> allPageElements;

    @FindBy(css = "a.logo")
    private WebElement logo;


    @FindBy(css = "a")
    private WebElement aTag;

    @FindBy(css = "///span[@innertext=' Home']")
    private WebElement homeIcon;

    @FindBy(css = "span.maintext")
    private WebElement pageHeader;

    @FindBy(css = "//span[@class='maintext']")
    private WebElement pageHeading;

    @FindBy(css = "div[id='content'] h2")
    private WebElement pageHeader_h2;


    @FindBy(xpath = "/html/body/div/div[1]/div[2]/section/ul/li/a")
    private List<WebElement> allPageBreadCrumbList;

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/section/ul/li/a")
    private List<WebElement> breadCrumbList;


    @FindBy(xpath = "//*[@id='wishlist-total']/span")
    private WebElement wishlist;

    @FindBy(css = "a[id='wishlist-total'] i[class='fa fa-heart']")
    private WebElement wishlistIcon;

    @FindBy(css = "ul:nth-of-type(2)  h2")
    private WebElement productPrice;
    @FindBy(css = "a:nth-of-type(1) > strong")
    private WebElement viewCartBtn;
    @FindBy(css = "a:nth-of-type(2) > strong")
    private WebElement checkoutBtn;
    @FindBy(css = "td[class='text-left'] a")
    private WebElement productDisplayed;
    @FindBy(css = "td[class='text-left'] small")
    private WebElement deliverDate;
    @FindBy(css = ".dropdown-menu.pull-right")
    private WebElement priceSummaryTable;
    @FindBy(css = ".fa.fa-times")
    private WebElement removeButton;

    @FindBy(css = "//*[contains(text(),'$')]")
    private List<WebElement> dollarSigns;


    public boolean assertCurrentPageBreadCrumbMenuIsDisplayedCorrectly(String MenuName) {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(1));
        log.info(breadCrumbList.stream().parallel().anyMatch(s -> s.getText().contains(MenuName)));
        return breadCrumbList.stream().parallel().anyMatch(s -> s.getText().contains(MenuName));
    }


    public void checkPageIsReady(int loopCount) throws Exception {
        ExpectedCondition<Boolean> pageLoadCondition = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(pageLoadCondition);
    }

    public static String randomEmailAddress() {
        return (RandomStringUtils.randomNumeric(8)) + "@gmail.com";

    }

    public static boolean selectByVisibleText(String visibleText, WebElement ele) {
        boolean flag = false;
        try {
            Select s = new Select(ele);
            s.selectByVisibleText(visibleText);
            flag = true;
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (flag) {
                log.info("Option selected by VisibleText ::" + "<" + visibleText + ">");
            } else {
                log.info("Option not selected by VisibleText");
            }
        }
    }


    public boolean assertListOfDisplayedTextInItemCartIsDisplayed() {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
        return viewCartBtn.isDisplayed() && checkoutBtn.isDisplayed() && productDisplayed.isDisplayed() && priceSummaryTable.isDisplayed() && removeButton.isDisplayed();
    }


    public String generateRandomEmail() {
        return (RandomStringUtils.randomNumeric(10)) + "@gmail.com";

    }

    public List<WebElement> getAllElements() {
        return allPageElements;

    }

    public void clickLinkByText(String linkName) throws IOException {
        waitElementToAppearFor(2);
        driver.findElement(By.xpath("//*[contains(text(),'" + linkName + "')]")).click();
        waitElementToAppearFor(1);
        log.info("Successfully clicked on the link");
    }

    public List<String> assertHeaderAndLabelsTxt(String headerOrText) {
        log.info(headerOrText);
        return allPageElements
                .stream()
                .map(WebElement::getText)
                .filter(text -> text.equalsIgnoreCase(headerOrText))
                .collect(Collectors.toList());
    }


    public String getPageHeaderText() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(pageHeader));
        return new VerificationHelper(driver).getText(pageHeader);

    }

    public String getPageHeadingText() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(pageHeader));
        return new VerificationHelper(driver).getText(pageHeading);

    }



    public boolean assertPageHeaderIsDisplayed() {
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        return new VerificationHelper(driver).isDisplayed(pageHeader);
    }

    public boolean assertProductIdHeaderIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(pageHeader);

    }

    public String getProductIdHeaderText() {
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        return new VerificationHelper(driver).getText(pageHeader);
    }

    public void waitAndSendKeys(WebElement element, String keysToSend) {
        element.clear();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(keysToSend);
    }

    public void waitAndClick(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        log.info("Clicked on :: " + findBy.getText());
        wait.until(ExpectedConditions.elementToBeClickable(findBy)).click();
    }

    public void waitForWebElementToAppear(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(findBy));

    }

    public void waitFor(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        log.info("Waited for element visibility :: " + element.getText());

    }

    public void waitForElementToAppear(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait));
        wait.until((d) -> element.isDisplayed());
        log.info("Waited for element visibility :: " + element);
        };

    public void waitForElementToAppearAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait));
        wait.until(d->{
            log.info("search to find element");
            d.navigate().refresh();
            return element;

        });
        log.info("Waited for element visibility :: " + element);
        element.click();
        log.info("Clicked on the element");
    }

    public void waitForElementToAppearAndSendKeys(WebElement element, String keyToSend) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait));
        wait.until(d->{
            log.info("search to find element");
            d.navigate().refresh();
            return element;

        }).sendKeys(keyToSend);
        log.info(keyToSend + " sent to the element");
    }

    public void waitElementToAppearFor(int timeout) {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(timeout));

    }

    public void assertTextShouldNotBeDisplayedInHeadingText(String headingText) {
        WebElement newHeading = driver.findElement(By.id("heading"));
        Assert.assertNotEquals(headingText, newHeading.getText());
    }

    public void waitForAlertAndValidateText(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent());
        String alert_Message_Text = driver.switchTo().alert().getText();
        Assert.assertEquals(alert_Message_Text, text);
    }

    public void clickMatchingElementByText(List<WebElement> elements, String meniItem) {
        WebElement element = elements
                .stream()
                .parallel()
                .filter(s -> s.getText().equalsIgnoreCase(meniItem))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Element with text" + meniItem + "not present"));
        element.click();

    }

    public void clickAMatchingElementByText(List<WebElement> elements, String ItemName) {
        WebElement element = elements
                .stream()
                .parallel()
                .filter(s -> s.getText().equalsIgnoreCase(ItemName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Element with text" + ItemName + "not present"));
        log.info(element.getText());
        element.click();

    }

    public void sendKeysToWebElement(WebElement element, String textToSend) {
        element.clear();
        element.sendKeys(textToSend);
        log.info("sent data to the element :: " + textToSend);
    }


    public void sendKeys(By by, String textToType) {
        log.info("Entered text :: " + textToType);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToType);
    }

    public void sendKeys(WebElement element, String textToType) {
        element.clear();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
        log.info("Keys successfully sent to field :: " + textToType);
    }

    public void waitForElementToBeClickableAndClick(WebElement element) {
        log.info("Waited and Successfully clicked on the element :: " + element.getText());
        waitForWebElementAndClick(element);

    }

    public void waitForElementToBeClickable(WebElement element) {
        log.info("Waiting for element to be visible");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        log.info("Element now visible Clickable");
    }

    public void waitForWebElementAndClick(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public void waitForWebElementAndClick(WebElement element) {
        log.info("Waiting for element to be visible");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        log.info("Successfully clicked on the element");

    }

    public List<String> getAccountsSectionsList(List<WebElement> products) {
        List<String> accountsList = new ArrayList<>();
        List<WebElement> accountsHeaderList = driver.findElements((By) products);
        for (WebElement e : accountsHeaderList) {
            String text = e.getText();
            log.info(text);
            accountsList.add(text);
        }
        return accountsList;
    }

    public Iterator<String> getAllWindows() {
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> itr = windows.iterator();
        return itr;
    }

    public void getUrl(String url) {
        log.info("navigating to :-" + url);
        driver.get(url);
    }

    public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", ele);

    }

    public boolean JSClick(WebDriver driver, WebElement ele) {
        boolean flag = false;
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", ele);
            flag = true;
        } catch (Exception e) {
            throw e;
        } finally {
            if (flag) {
                log.info("Click Action is performed: " + ele.getText());
            } else if (!flag) {
                log.info("Click Action is not performed: " + ele.getText());
            }
        }
        return flag;
    }

    public boolean assertHeaderTextIsDisplayed(WebElement element) {
        return new VerificationHelper(driver).isDisplayed(element);
    }

    public ArrayList<Integer> getPriceMassagedData(Iterator<WebElement> itr) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        while (itr.hasNext()) {
            String p = itr.next().getText();
            if (p.contains("$")) {
                String actualData = p.substring(1);
                //log.info(actualData);
                double p1 = Double.parseDouble(actualData);
                int productPrice = (int) (p1);
                array.add(productPrice);
            }
        }
        return array;
    }

    public boolean verifyArrayHasAscendingData(ArrayList<Integer> array) {
        for (int i = 0; i < array.size() - 1; i++) {
            // this condition will check all next price should be smaller than previous one.
            // next price can be grater and equal
            if (array.get(i) <= array.get(i + 1)) {
                log.info("obj.get(i).." + array.get(i));
                log.info("obj.get(i+1).." + array.get(i + 1));
            } else {
                log.info("price filter is not working");
                return false;
            }
        }
        return true;
    }

    public void waitForElementInvisible(WebElement element, int timer) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void clickAnItemFromListByText(List<WebElement> elements, String itemText) {
        WebElement element = elements
                .stream()
                .parallel()
                .filter(e -> e.getText().equalsIgnoreCase(itemText))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Element with text" + itemText + " not present"));
        element.click();
    }

    public void clickAnElementMatchingText(List<WebElement> elements, String itemText) {
        WebElement element = elements
                .stream()
                .parallel()
                .filter(e -> e.getText().equalsIgnoreCase(itemText))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Element with text" + itemText + " not present"));
        element.click();
    }

    public boolean assertElementIsDisplayedAndEnabled(WebElement element) {
        return element.isDisplayed() && element.isEnabled();
    }

    public void assertOnSubHeadingText(String subHeadingText) {
        WebElement subHeading = driver.findElement(By.id("sub_heading"));
        Assert.assertEquals(subHeadingText, subHeading.getText());
    }

    public List<WebElement> getBreadCrumbList() {
        return allPageBreadCrumbList;

    }


    public String getThisPageHeader() {
        return new VerificationHelper(driver).getText(pageHeader);

    }

    public String getThisPageUrl() {
        return new VerificationHelper(driver).getCurrentPageUrl();

    }

    public String getThisPageTitle() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.titleIs(driver.getTitle()));
        return new VerificationHelper(driver).getCurrentPageTitle();

    }

    public void assertWebElementNotDisplayedInCurrentPage(By locator) {
        try {
            driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            Assert.assertTrue(e.getMessage().contains("no such element: Unable to locate element:"));
        }
    }

    public void clickOnBrowserForwardButton() {
        driver.navigate().forward();

    }
    public void clickOnBrowserBackButton() {
        driver.navigate().back();

    }

    public void navigateTo(String url) {
        driver.navigate().to(url);

    }


    public void mouseOver(String data) throws InterruptedException {
        log.info("doing mouse over on :" + data);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'" + data + "')]"))).build().perform();
    }

    public void mouseOverElement(WebDriver driver, WebElement element) {
        boolean flag = false;
        try {
            new Actions(driver).moveToElement(element).build().perform();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag) {
                log.info(" MouserOver Action is performed on");
            } else {
                log.info("MouseOver action is not performed on");
            }
        }
    }

    // Wait for element & click on element
    public void clickOnElement(WebElement element, long durationInSeconds) {
        WebElement webElement = waitForElement(element, durationInSeconds);
        webElement.click();
    }

    public void sendKeysElement(WebElement element, String textToType) {
        element.clear();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
        log.info("Keys successfully sent to field :: " + textToType);
    }

    // Type text into element
    public void typeTextIntoElement(WebElement element, String textToBeTyped, long durationInSeconds) {
        WebElement webElement = waitForElement(element, durationInSeconds);
        webElement.click();
        webElement.clear();
        webElement.sendKeys(textToBeTyped);
    }

    // Select option in dropdown
    public void selectOptionInDropdown(WebElement element, String dropDownOption, long durationInSeconds) {
        WebElement webElement = waitForElement(element, durationInSeconds);
        Select select = new Select(webElement);
        select.selectByVisibleText(dropDownOption);
    }

    // Alert accept & reject
    public void acceptAlert(long durationInSeconds) {
        Alert alert = waitForAlert(durationInSeconds);
        alert.accept();
    }

    public void dismissAlert(long durationInSeconds) {
        Alert alert = waitForAlert(durationInSeconds);
        alert.dismiss();
    }

    // Mouse hover & click
    public void mouseHoverAndClick(WebElement element, long durationInSeconds) {
        WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).click().build().perform();
    }

    public void moveToElement(WebElement element) {
        WebElement webElement = waitForVisibilityOfElement(element, GlobalVars.explicitWait);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();
    }

    public WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds) {
        WebElement webElement = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            webElement = wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return webElement;
    }

    public WebElement waitForElement(WebElement element, long durationInSeconds) {
        WebElement webElement = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return webElement;
    }

    public Alert waitForAlert(long durationInSeconds) {
        Alert alert = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            alert = wait.until(ExpectedConditions.alertIsPresent());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return alert;
    }

    // JavaScript Click
    public void javaScriptClick(WebElement element, long durationInSeconds) {
        WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("arguments[0].click();", webElement);
    }

    // JavaScript Type
    public void javaScriptType(WebElement element, long durationInSeconds, String textToBeTyped) {
        WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("arguments[0].value='" + textToBeTyped + "'", webElement);
    }

    // Get text from element
    public String getTextFromElement(WebElement element, long durationInSeconds) {
        WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
        return webElement.getText();
    }

    // Display status of element
    public boolean displayStatusOfElement(WebElement element, long durationInSeconds) {
        try {
            WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
            return webElement.isDisplayed();
        } catch (Throwable e) {
            return false;
        }

    }

    //===============Click Methods===================//

    public void submit(WebElement element) {
        element.submit();

    }

    public void clickUsingActions(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).click().build().perform();

    }

    public void JSClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

    }

    public boolean existsElement(WebElement element) {
        try {
            element.getText();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public void waitForLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wd) {
                return "complete".equals(((JavascriptExecutor) wd).executeScript("return document.readyState"));
            }
        };
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait));
        wait.until(pageLoadCondition);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalVars.DEFAULT_IMPLICIT_TIMEOUT));
    }

    public void clickUsingMouseAction(WebElement element) {
        element.sendKeys(Keys.RETURN);

    }

    public void WaitForElementAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void screenshotAnElement(WebElement element) throws IOException {
        File srcScreenShot = element.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(srcScreenShot, new File(System.getProperty("user.dir") + "//screenShots/screenShot.png"));
    }

    public void screenshotFullPage() throws IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "//screenShots/file1.png"));
    }

    public void getRectHeightAndWidthOfAnElement(WebElement element) throws IOException {
        Point p = element.getLocation();
        log.info(p.getX());
        log.info(p.getY());
        Rectangle r = element.getRect();
        log.info(r.getX());
        log.info(r.getY());
    }


    public void waitForElement(WebElement element, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.ignoring(NoSuchElementException.class);
        //wait.ignoring(ElementNotVisibleException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(ElementNotFoundException.class);
        wait.pollingEvery(Duration.ofSeconds(5));
        wait.until(elementLocated(element));
    }

    private Function<WebDriver, Boolean> elementLocated(final WebElement element) {
        return new Function<WebDriver, Boolean>() {

            @Override
            public Boolean apply(WebDriver driver) {
                return element.isDisplayed();

            }
        };
    }

    public boolean checkForTitle(String title) {
        log.info(title);
        if (title == null || title.isEmpty())
            throw new IllegalArgumentException(title);
        return driver.getTitle().trim().contains(title);
    }

    public boolean assertLogoIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(logo);

    }

    public String getLogoText() {
        return new VerificationHelper(driver).getText(logo);

    }

    public void clickLogoImage() {
        logo.click();

    }

    public WebElement getPageBreadcrumbMenuList(String breadCrumbMenuName) {
        for (int i = 0; i < allPageBreadCrumbList.size(); i++) {
           if(allPageBreadCrumbList.get(i).getText().contains(breadCrumbMenuName)){
               return allPageBreadCrumbList.get(i);

           }
        }


        return null;
    }

    public List<WebElement> getDollarSigns() {
        return dollarSigns;
    }

}
