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

public class Boolean_WIth_CheckBox {
    //declare the local driver outside so that it can be reuseable with other anotation methods
    WebDriver driver;

    //before suite will set the driver you are using
    @BeforeSuite
    public void SetChromeDriver() {

        driver = Reuseable_Actions.setDriver();
    } // end of before suite anotation

    //test case: navigaite to google and enter a keyword on search field
    @Test()
    public void Yahoo_Stay_Signed_In_Checkbox_Verification() throws InterruptedException {
        //navigaite to yahoo
        driver.navigate().to("https://www.yahoo.com");
        Reuseable_Actions.clickAction(driver, "//*[text() = 'Sign in']", "Sign in");
        //verify the stay signed in checkbox is selected or not
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type = 'checkbox']"))).isSelected();
        System.out.println("Is element checked? " + elementState);

    }//end of test

    @AfterSuite
    public void quitSession() {
        driver.quit();
    } //end of after suite

}// end of class

