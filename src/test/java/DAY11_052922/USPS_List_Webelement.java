package DAY11_052922;

import ReuseableLibraries.Reuseable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class USPS_List_Webelement {


    //declare the local driver outside so that it can be reuseable with other anotation methods
    WebDriver driver;

    //before suite will set the driver you are using
    @BeforeSuite
    public void SetChromeDriver() {

        driver = Reuseable_Actions.setDriver();
    } // end of before suite anotation

    //test case: navigaite to google and enter a keyword on search field
    @Test()
    public void USPS_Tabs_Count() throws InterruptedException {
        //navigaite to usps
        driver.navigate().to("https://www.usps.com");
        //declare explicit wait for the tabs
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //store the navigation tab as a list to get the count
        List<WebElement> tabsCount = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[contains(@class, 'menuheader')]")));
        //print the tab count
        System.out.println("Tabs count is " + tabsCount.size());

        for(int i =0; i< tabsCount.size(); i++){

            driver.navigate().to("https://www.usps.com");
            tabsCount = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[contains(@class, 'menuheader')]")));
            //click on each tab
            tabsCount.get(i).click();
            Thread.sleep(1000);
        }// end of loop
    }//end of test

    @AfterSuite
    public void quitSession() {
        driver.quit();
    } //end of after suite

}// end of class
