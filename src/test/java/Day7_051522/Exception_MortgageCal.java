package Day7_051522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Exception_MortgageCal {
    public static void main(String[] args) throws InterruptedException {
        //set up your chrome driver with webdriver manager
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-fullscreen");
        // define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);
        //go to mortgage calc website homepage
        driver.navigate().to("https://www.mlcalc.com");
        //wait 3 seconds for the web page to load
        Thread.sleep(3000);
        // handle exception for purchase price
        try {
            WebElement pPrice = driver.findElement(By.xpath("//*[@id='ma']"));
            pPrice.clear();
            pPrice.sendKeys("450000");
        } catch (Exception e) {
            //print out the exception
            System.out.println("unable to locate purchase price " + e);
        } // end of purchase price exception
        // handle exception for show advance option button
        try {
            driver.findElement(By.xpath("//*[text() = 'Show advanced options']")).click();
        } catch (Exception e) {
            //print out the exception
            System.out.println("unable to locate Show Advance Options button " + e);
        } // end of show advance option exception

        //handle exception for start month drop down
        try {
            WebElement startMonth = driver.findElement(By.xpath("//*[@name='sm']"));
            Select dropdown = new Select(startMonth);
            dropdown.selectByVisibleText("Jun");
        } catch (Exception e) {
            //print out the exception
            System.out.println("unable to locate Start Month dropdown " + e);
        } // end of start month exception

        //handle exception for calculate button
        try {
            driver.findElement(By.xpath("//*[@value = 'Calculate']")).click();
        } catch (Exception e) {
            //print out the exception
            System.out.println("unable to locate Calculate button " + e);
        } // end of calculate exception
        Thread.sleep(3000);

        // handle exception for monthly payment
        try {
            String mntPayment = driver.findElements(By.xpath("//div[@style = 'font-size: 32px']")).get(0).getText();
            System.out.println("Monthly payment is " + mntPayment);
        } catch (Exception e) {
            //print out the exception
            System.out.println("unable to locate monthly payment text " + e);
        } // end of monthly payment exception
        //quit the driver
        driver.quit();

    }// end of main
}// end of class
