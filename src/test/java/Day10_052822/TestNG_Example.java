package Day10_052822;

import ReuseableLibraries.Reuseable_Actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNG_Example {

    //declare the local driver outside so that it can be reuseable with other anotation methods
    WebDriver driver;

    //before suite will set the driver you are using
    @BeforeSuite
    public void SetChromeDriver() {
        driver = Reuseable_Actions.setDriver();
    } // end of before suite anotation

    //test case 1: navigaite to google and enter a keyword on search field
    @Test(priority = 1)
    public void SearchForKeyword(){
        driver.navigate().to("https://www.google.com");
        //enter a keyword on searcg field
        Reuseable_Actions.sendKeysAction(driver, "//*[@name ='q']", "BMW", "Search Field");
   //submit the go button
        Reuseable_Actions.submitAction(driver,"//*[@name= 'btnK']", "Google Search Button" );
    }// end of test 1

    /*dependsOnMethods used when following @Test is dependent on previous @Test method.
     If the first test fails, the depenent test will get skipped
    */
    @Test(dependsOnMethods = "SearchForKeyWord")
    public void CaptureSearchNumber(){
        //capture search result
        String result = Reuseable_Actions.getTextAction(driver, "//*[@id= 'result-stats']", "Search Result Text" );
        //Split the result by single space and print out the search number
        String[] arrayResult = result.split(" ");
        System.out.println("Search number is " + arrayResult[1]);
    } // end of test 2

    @AfterSuite
    public void quitSession() {
        driver.quit();
    } //end of after suite
}
