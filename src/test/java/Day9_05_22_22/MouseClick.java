package Day9_05_22_22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MouseClick {
    public static void main(String[] args) throws InterruptedException {
        //set up chrome driver with webdriver manager
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-fullscreen");
        // define the webdriver
        WebDriver driver = new ChromeDriver(options);
        //navigaite to home page
        driver.navigate().to("https://www.usps.com");
        Thread.sleep(3000);

        //declare and define mouse actions
        Actions mouseActions = new Actions(driver);

        //hover to send tab
        WebElement sendTab = driver.findElement(By.xpath("//*[@id = 'mail-ship-width']"));
        mouseActions.moveToElement(sendTab).perform();

        //click on tracking using mouse action
        WebElement tracking= driver.findElement(By.xpath("//*[text() = 'Tracking']"));
        mouseActions.moveToElement(tracking).click().perform();
        Thread.sleep(3000);

        //type invalid tracking number using sendkeys with mouse actions
        WebElement trackingField = driver.findElement(By.xpath("//*[@id = 'tracking-input']"));
        mouseActions.moveToElement(trackingField).click().perform();
        mouseActions.moveToElement(trackingField).sendKeys("12345678910").perform();
        Thread.sleep(1000);

        driver.quit();



    }// end of main
} //end of class
