package Day7_051522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class ActionItem4 {
    public static void main(String[] args) throws InterruptedException {
        //set up chrome driver with webdriver manager
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-fullscreen");
        // define the webdriver
        WebDriver driver = new ChromeDriver(options);

        //arraylist of zipcodes
        ArrayList<String> zipCodes = new ArrayList<>();
        zipCodes.add("11218");
        zipCodes.add("11215");
        zipCodes.add("10010");

        for(int i= 0; i< zipCodes.size(); i++) {
            //go to weight watchers  homepage
            driver.navigate().to("https://www.weightwatchers.com");
            //wait 3 seconds for the web page to load
            Thread.sleep(3000);
            // handle exception for find a workshop
            try {
                driver.findElement(By.xpath("//*[@class = 'MenuItem_menu-item__inner-wrapper__+m6dY MenuItem_menu-item__inner-wrapper--with-icon__f6SeF']")).click();
            } catch (Exception e) {
                //print out the exception
                System.out.println("unable to locate find a workshop" + e);
            } // end of find a workshop exception
            Thread.sleep(3000);
            // handle exception for in person class
            try {
                driver.findElement(By.xpath("//*[@class='iconWrapper-1dvW4']")).click();
            } catch (Exception e) {
                //print out the exception
                System.out.println("unable to locate find a workshop in person" + e);
            } // end of find a workshop in person exception
            //entering zipcode and searching
            try {
                WebElement inPerson = driver.findElement(By.xpath("//*[@id='location-search']"));
                inPerson.clear();
                inPerson.sendKeys(zipCodes.get(i));
                driver.findElement(By.xpath("//*[@class='rightArrow-daPRP']")).click();
                Thread.sleep(3000);
            } catch (Exception e) {
                //print out the exception
                System.out.println("unable to enter zipcode" + e);
            }
            // handle exception for finding clicking studio link
            try {
                ArrayList<WebElement> searchResults = new ArrayList<>(driver.findElements(By.xpath("//*[@class='heading-3yCF-']")));
                if(i ==0) {
                   searchResults.get(1).click();
                }
                else if(i ==1) {
                    searchResults.get(2).click();
                }
                if(i ==2) {
                    searchResults.get(0).click();
                }
            } catch (Exception e) {
                //print out the exception
                System.out.println("unable to click studio " + e);
                Thread.sleep(3000);
            } // end of click studio link exception
            //getting studio address
            try {
                String address = driver.findElement(By.xpath("//*[@class='infoContainer-12kv1']")).getText();
                Thread.sleep(3000);
                System.out.println("Studio addres is " + address);
            } catch (Exception e) {
                //print out the exception
                System.out.println("unable to get address" + e);
            }
            //scroll to schedule
            try {
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                Thread.sleep(1000);
                //scroll to pixel 400
                jse.executeScript("scroll(0, 400)");
                Thread.sleep(2000);
            } catch (Exception e) {
                //print out the exception
                System.out.println("unable to scroll" + e);
            }
            //getting the schedule
            try {
                String schedule = driver.findElement(By.xpath("//*[@id='studioWorkshopSchedule']")).getText();
                Thread.sleep(3000);
                System.out.println("Studio workshop schedule is  " + schedule);
            } catch (Exception e) {
                //print out the exception
                System.out.println("unable to get schedule " + e);
            }
        }// end of for loop
        //quit the driver
        driver.quit();
    }// end of main
}// end of class
