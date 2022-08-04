package Day08_05_21_22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class getTitle_Example {
    public static void main(String[] args) throws InterruptedException {
        //set up chrome driver with webdriver manager
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-fullscreen");
        // define the webdriver
        WebDriver driver = new ChromeDriver(options);

        //navigaite to google
        driver.navigate().to("https://www.google.com");
        //capture the title of the page and compare it with your expected title "Google"
        String actualTitle = driver.getTitle();
        if(actualTitle.equals("Google")) {
            System.out.println("My title matches");
        } else {
            System.out.println("Title dosen't match, actual title is " + actualTitle);
        }
        driver.quit();

    }// end of main
} // end of class
