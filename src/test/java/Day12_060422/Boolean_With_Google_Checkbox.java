package Day12_060422;

import ReuseableClasses.Reuseable_Actions_Loggers;
import ReuseableClasses.Reuseable_Annotations_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Boolean_With_Google_Checkbox extends Reuseable_Annotations_Class {
    @Test(priority = 1)
    public void Yahoo_Stay_Signed_In_Checkbox_Verification() throws InterruptedException {
        //navigaite to yahoo
        driver.navigate().to("https://www.yahoo.com");
        Reuseable_Actions_Loggers.clickAction(driver, "//*[text() = 'Sign in']", logger, "Sign in");
        //verify the stay signed in checkbox is selected or not
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type = 'checkbox']"))).isSelected();
        if (elementState = true){
            logger.log(LogStatus.PASS, "Checkbox is selected as expected");
        } else {
            logger.log(LogStatus.FAIL, "Checkbox is not selected");
        }
    }//end of test
    @Test(priority = 2)
    public void NavigaiteToYahooHome(){
        //navigate to yahoo
        logger.log(LogStatus.INFO,"navigating to home page");
        driver.navigate().to("https://www.yahoo.com");
    } //end of test
}//end of class
