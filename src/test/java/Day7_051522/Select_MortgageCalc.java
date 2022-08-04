package Day7_051522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Select_MortgageCalc {
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
        //select start month from the dropdown
        WebElement startMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));
        //define select command
        //Select dropDown = new Select(startMonth);
        //select by visible text
        //dropDown.selectByVisibleText("Jun");
        //clicking on the dropdown and its value if the dropdown tag is not under select
        startMonth.click();
        //click on the value of the start month
        driver.findElement(By.xpath("//*[text()= 'Jun']")).click();

        //select Loan type from the drop down
        WebElement loanType = driver.findElement(By.xpath("//*[@name='param[milserve]']"));
        //define select command
        Select loanTypeDropdown = new Select(loanType);
        //select by vislbe text
        loanTypeDropdown.selectByVisibleText("FHA");
    }//end of main
}//end of classs
