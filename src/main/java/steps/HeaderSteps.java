package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class HeaderSteps extends BaseSteps{
    public HeaderSteps(WebDriver driver) {
        super(driver);
    }

    @Step
    public HeaderSteps goToCart(){
        headerPage.clickCartButton();
        return this;
    }
}
