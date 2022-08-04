package Day9_05_22_22;

import ReuseableLibraries.Reuseable_Actions;
import org.openqa.selenium.WebDriver;

public class USPS_Reuseable_Concepts {
    public static void main(String[] args) throws InterruptedException {

        //setting the  local driver to reuseable setDriver method
        WebDriver driver = Reuseable_Actions.setDriver();

        //navigaite to USPS
        driver.navigate().to("https://www.usps.com");

        //hovering to the qucik tools
        Reuseable_Actions.mouseHover(driver, "//*[text() = 'Quick Tools']", "Quick Tools");
        //hovering to send tab
        Reuseable_Actions.mouseHover(driver, "//*[@id = 'mail-ship-width']", "Send Tab");
        //click on calc price
        Reuseable_Actions.clickAction(driver, "//li[@class = 'tool-calc']", "Calculate a price " );
        //enter zipcode
        Reuseable_Actions.sendKeysAction(driver, "//*[@id = 'Origin']", "11218", "Zip code" );
        //print out header text info
        String result = Reuseable_Actions.getTextAction(driver, "//*[@class = 'header-usps row']", "header info ");
        System.out.println(" My header info is " + result);
    }

}
