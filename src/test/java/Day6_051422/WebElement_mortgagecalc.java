package Day6_051422;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebElement_mortgagecalc {
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

        //click, clear and enter new value on Home value field
        WebElement homeValue = driver.findElement(By.xpath("//*[@id= 'homeval']"));
        homeValue.click();
        homeValue.clear();
        Thread.sleep(1500);
        homeValue.sendKeys("450000");

        //click on % radio button
        driver.findElement(By.xpath("//*[@value='percent']")).click();

        //click, clear and enter new value on down payment field
        WebElement downPayment = driver.findElement(By.xpath("//*[@id= 'downpayment']"));
        downPayment.click();
        downPayment.clear();
        Thread.sleep(1500);
        downPayment.sendKeys("5");

    } // end of main
} // end of class
