package Day9_05_22_22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class USPS_Implicit_Explicit_Wait {
    public static void main(String[] args) throws InterruptedException {
        //set up chrome driver with webdriver manager
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-fullscreen");
        // define the webdriver
        WebDriver driver = new ChromeDriver(options);

        //set your global implicit wait
       // driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        //navigaite to home page
        driver.navigate().to("https://www.usps.com");

        //call mouse actions
        Actions actions= new Actions(driver);

        //declare and define explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 8);

        //hover to quick tools
        WebElement quickTools = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Quick Tools']")));
        actions.moveToElement(quickTools).perform();

        // click on track a package
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Track a Package']"))).click();

        //click and then type on track a package field
        WebElement packageField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'tracking-input']")));
        packageField.click();
        packageField.sendKeys("1234567899");
    } //end of main
}// end of class

