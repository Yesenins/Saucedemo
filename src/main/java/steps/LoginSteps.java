package steps;

import constants.IConstants;
import entity.User;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps  extends BaseSteps{
    public LoginSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Login and wait for page loaded")
    public LoginSteps loginAndWaitForPageOpened(String username, String password) {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.waitForPageOpened()
                .login(username, password);
        return this;
    }

    @Step("Login and wait for page loaded")
    public LoginSteps loginAndWaitForPageOpened(User user) {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.waitForPageOpened()
                .login(user);
        return this;
    }

    @Step("error message output check")
    public LoginSteps checkErrorMessageOutput(String errorMessage) {
        Assert.assertEquals(loginPage.getErrorMessageText(), errorMessage);
        return this;
    }
}