package Day5_050822;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptions_GoogleSearch {
    public static void main(String[] args) throws InterruptedException {
        //set up your chrome driver with webdriver manager
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen
        options.addArguments("start-fullscreen");
        //for windows use
        //options.addArguments("start-maximized");
        //setting your driver as headless(running on background)
        //options.addArguments("headless");

        // define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);
        //go to Google homepage
        driver.navigate().to("https://www.google.com");
        Thread.sleep(3000);
        //maxamize the driver
        driver.manage().window().fullscreen();
        //locate element for search field and type keyword 'cars'
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");
        // submit on google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();
        Thread.sleep(2500);
        // capture the google search and print it
        String searchResult = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        //  System.out.println("Result is " + searchResult);
        //extract out the number and print the search number only
        String[] arrayResult = searchResult.split(" ");
        System.out.println("My search number is " + arrayResult[1]);

        //get seconds
        // String replaceParanth = arrayResult[3].replace("(", "").replace(")", "");
        //System.out.println("My search number is " + arrayResult[1] + " and it took " + replaceParanth);
        //quit the driver
        driver.quit();





    }//end of main
}
