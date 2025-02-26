package pages;

import constants.IConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import waiters.Waiters;

public abstract class BasePage implements IConstants {
    WebDriver driver;
    Waiters waiters = new Waiters();

    BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage(String url){
        waiters.waitForPageLoaded();
        driver.get(url);
    }
}
