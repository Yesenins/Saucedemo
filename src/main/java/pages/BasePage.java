package pages;

import constants.IConstants;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import waiters.Waiters;

@Log4j2
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
