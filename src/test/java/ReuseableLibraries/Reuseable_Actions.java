package ReuseableLibraries;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reuseable_Actions {

    //set a static timeout variable so it can cover all explicit for all methods
    static int timeout = 20;

    //reuseable function for webdriver as a return method
    public static WebDriver setDriver() {
        //set up chrome driver with webdriver manager
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-fullscreen");
        // define the webdriver
        WebDriver driver = new ChromeDriver(options);

        return driver;
    } // end of set driver method

    //create mouse hover method
    public static void mouseHover(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Could not hover mouse element " + elementName + " " + e);
        }
    }// end of mouse hover

    public static void clickAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
        } catch (Exception e) {
            System.out.println("Could not click element " + elementName + " " + e);
        }
    }// end of click action
    public static void submitAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.submit();
        } catch (Exception e) {
            System.out.println("Unable to submit " + elementName + " " + e);
        }
    }// end of click action

    //create sendkeys method
    public static void sendKeysAction(WebDriver driver, String xpath, String userValue,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.sendKeys(userValue);
        } catch (Exception e) {
            System.out.println("Could not click element " + elementName + " " + e);
        }
    }// end of send Keys

    //create getText method
    public static String getTextAction (WebDriver driver, String xpath,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver,  timeout);
        String result = "";
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            result = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to get Text " + elementName + " " + e);
        }
        return result;
    }// end of get text method
    public static void clickByIndex (WebDriver driver, String xpath, int indexNumber,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            element.click();
        } catch (Exception e) {
            System.out.println("Could not click element " + elementName + " " + e);
        }
    }// end of getText Method
}

