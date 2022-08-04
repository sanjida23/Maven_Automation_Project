package Day5_050822;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Forloop_Arraylist_Google_Search {
    public static void main(String[] args) throws InterruptedException {
        // capture search number and print for the following citiess using arraylist and foor loop
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Brooklyn");
        cities.add("Car");
        cities.add("Bronx");

        //set up your chrome driver with webdriver manager
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
       // options.addArguments("incognito");
        //set the condition to maximize/fullscreen
        options.addArguments("start-fullscreen");
        //for windows use
        //options.addArguments("start-maximized");
        //setting your driver as headless(running on background)
        //options.addArguments("headless");

        // define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);

        for(int i= 0; i< cities.size(); i++) {
        //go to Google homepage
        driver.navigate().to("https://www.google.com");
        Thread.sleep(3000);
        //maxamize the driver
       // driver.manage().window().fullscreen();
        //locate element for search field and type keyword 'cities'
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys(cities.get(i));
        // submit on google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();
        Thread.sleep(2500);
        // capture the google search and print it
        String searchResult = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        //  System.out.println("Result is " + searchResult);
        //extract out the number and print the search number only
        String[] arrayResult = searchResult.split(" ");
        System.out.println("For the city " + cities.get(i) + " size of search is " + arrayResult[1]);

        //get seconds
        // String replaceParanth = arrayResult[3].replace("(", "").replace(")", "");
        //System.out.println("My search number is " + arrayResult[1] + " and it took " + replaceParanth);
    }   //close for loop
        //quit the driver
        driver.quit();

    } //end main
} // end of class
