package Day10_052822;

import ReuseableLibraries.Reuseable_Actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TESTNG_Example_ForLoop {
    //declare the local driver outside so that it can be reuseable with other anotation methods
    WebDriver driver;

    //before suite will set the driver you are using
    @BeforeSuite
    public void SetChromeDriver() {
        driver = Reuseable_Actions.setDriver();
    } // end of before suite anotation

    //test case 1: navigaite to google and enter a keyword on search field
    @Test
    public void SearchForKeyword(){
        ArrayList <String> cars = new ArrayList();
        cars.add("BMW");
        cars.add("Mercedes");
        cars.add("Tesla");
        for(int i=0; i< cars.size(); i++) {
            driver.navigate().to("https://www.google.com");
            //enter a keyword on search field
            Reuseable_Actions.sendKeysAction(driver, "//*[@name ='q']", cars.get(i), "Search Field");
            //submit the go button
            Reuseable_Actions.submitAction(driver, "//*[@name= 'btnK']", "Google Search Button");
                //capture search result
            String result = Reuseable_Actions.getTextAction(driver, "//*[@id= 'result-stats']", "Search Result Text");
                //Split the result by single space and print out the search number
            String[] arrayResult = result.split(" ");
            System.out.println("Search number for " +cars.get(i) + " is " + arrayResult[1]);
            }//end of for loop
    } // end of test

    @AfterSuite
    public void quitSession() {
        driver.quit();
    } //end of after suite
}//end of class

