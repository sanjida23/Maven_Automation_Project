package Day6_051422;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FindElementsExample {
    public static void main(String[] args) throws InterruptedException {


        //set up your chrome driver with webdriver manager
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-fullscreen");

        // define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);
        //go to Bing homepage
        driver.navigate().to("https://www.bing.com");

        //wait a few seconds
        Thread.sleep(3000);

        //click on Images using class property with an index of 1
        //to ignore white space in the property value we can use contains command in x path
        driver.findElements(By.xpath("//li[contains(@class, 'scope')]")).get(0).click();
    } // end of main
} // end of class