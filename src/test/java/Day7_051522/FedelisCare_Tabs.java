package Day7_051522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class FedelisCare_Tabs {
    public static void main(String[] args) throws InterruptedException {
        //set up your chrome driver with webdriver manager
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-fullscreen");

        // define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);
        //go to morgage calc website homepage
        driver.navigate().to("https://www.fideliscare.org");
        //wait a 3 seconds for the web page to load
        Thread.sleep(3000);
        //click on shop for a plan
        //we are clicking on index 0 because there are two elements for this xpath
        driver.findElements(By.xpath("//*[text() = 'Shop For a Plan']")).get(0).click();
        //wait a bit for the page to load
        Thread.sleep(1000);
        //click on Medicaid managed care
        driver.findElements(By.xpath("//*[text() = 'Medicaid Managed Care']")).get(0).click();
        //wait a bit for page to load
        Thread.sleep(1000);
        //click on search under find a dcotor card
        driver.findElement(By.xpath("//*[@href = '/findadoctor']")).click();
        //wait a bit for new tab to open
        Thread.sleep(1000);
        //store new tabs in an array list, we use getWindowHandles method to get list of tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //switch to new tab, it should be at index 1
        driver.switchTo().window(tabs.get(1));
        //click on new search button
        driver.findElement(By.xpath("//*[@class = 'fal fa-search-plus']")).click();
        // wait a bit for the click
        Thread.sleep(1000);
        //close the new tab
        driver.close();
        //switch back to the default tab
        driver.switchTo().window(tabs.get(0));
        //then click on providers card
        driver.findElement(By.xpath("//*[@class = 'fal fa-stethoscope fa-fw']")).click();
        //wait until provider card is clicked on


    }//end of main
}// end of class
