package Day5_050822;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class ActionItem3 {
    public static void main(String[] args) throws InterruptedException {
        
        // capture search number and print for the following hobbies using arraylist and for loop
        ArrayList<String> hobbies = new ArrayList<>();
        hobbies.add("Swimming");
        //hobbies.add("Drawing");
        //hobbies.add("Gardening");
        //hobbies.add("Writing");
        //hobbies.add("Baking");

        //set up your chrome driver with webdriver manager
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");

        // define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);

            for(int i= 0; i< hobbies.size(); i++) {

                //go to Bing homepage
                driver.navigate().to("https://www.bing.com");

                //wait a few seconds
                Thread.sleep(3000);

                //locate element for search field and type keyword 'hobbies'
                driver.findElement(By.xpath("//*[@name='q']")).sendKeys(hobbies.get(i));

                // submit on bing search button
                driver.findElement(By.xpath("//*[@name='q']")).submit();
                Thread.sleep(2500);

                // capture the bing search and print it
                String searchResult = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();

                //extract out the number and print the search number only
                //String[] arrayResult = searchResult.split(" ");
                //Print search results using substring method 
                System.out.println("For the hobby " + hobbies.get(i) + " there are " + searchResult.substring(0,searchResult.length()-8)+ " search results.");
            }   //close for loop
                //quit the driver
                driver.quit();

        } //end main
    } // end of class



