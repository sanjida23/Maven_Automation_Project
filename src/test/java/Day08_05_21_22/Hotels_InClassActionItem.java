package Day08_05_21_22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hotels_InClassActionItem {
    public static void main(String[] args) throws InterruptedException {
        //set up chrome driver with webdriver manager
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-fullscreen");
        // define the webdriver
        WebDriver driver = new ChromeDriver(options);
        //navigaite to hotels.com
        driver.navigate().to("https://www.hotels.com");
        Thread.sleep(2000);
        //choose destination
        try {
            WebElement destination = driver.findElement(By.xpath("//*[tex() = 'Miami Beach']"));
            destination.click();
            Thread.sleep(2000);
        } catch(Exception e) {
            System.out.println("Can not enter destination");
        } // end of exception for destination choice

        //pick dates
        driver.findElement(By.xpath("//*[@aria-label = 'Dates July 14, 2022 - July 18, 2022']")).click();
        Thread.sleep(1000);
        //apply dates picked
        driver.findElement(By.xpath("//*[@data-stid = 'apply-date-picker']")).click();
        Thread.sleep(1000);
        //enter number of people traveling
        driver.findElement(By.xpath("//*[@class = 'uitk-fake-input uitk-form-field-trigger']"));
        Thread.sleep(1000);
        //done picking number of travelers
        driver.findElement(By.xpath("//*[@id = 'traveler_selector_done_button']")).click();
        Thread.sleep(1000);
        //submit search
        driver.findElement(By.xpath("//*[@id = 'submit_button']")).click();
        Thread.sleep(2000);
        driver.quit();

    }//end of main
}// end of class
