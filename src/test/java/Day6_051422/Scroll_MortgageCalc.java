package Day6_051422;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scroll_MortgageCalc {
    public static void main(String[] args) throws InterruptedException {


        //set up your chrome driver with webdriver manager
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-fullscreen");

        // define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);
        //go to morgage calc website homepage
        driver.navigate().to("https://www.mortgagecalculator.org");

        //wait a few seconds
        Thread.sleep(3000);

        //declare javascriptexecutor variable
        JavascriptExecutor jse = (JavascriptExecutor)  driver;
        //scroll to pixel 400 on morgage calc website
        Thread.sleep(3000);
        //declare a webelement variable that we want to scroll into
        WebElement shareButton = driver.findElement(By.xpath("//*[@id ='share_button']"));
        //scroll into share this calculation button
        jse.executeScript("arguments[0].scrollIntoView(true);", shareButton);
        Thread.sleep(2000);
        //click on the share this calculation button
        shareButton.click();
        Thread.sleep(2000);
        //scroll back up
        jse.executeScript("scroll(0,-400)");
        Thread.sleep(2000);
        //quit the chrome driver
        driver.quit();

    } //end of main
} // end of class
