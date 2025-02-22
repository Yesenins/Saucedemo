package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * The type Login page factory.
 */
public class LoginPageFactory extends BasePage{

    @FindBy(xpath = "//*[@data-test='username']")
    WebElement usernameInput;

    @FindBy(xpath = "//*[@data-test='password']")
    WebElement passwordInput;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(xpath = "//*[@data-test=\"error\"]")
    WebElement errorMessage;

    @Getter
    @FindBy(xpath = "//button[contains(.,'Add')]")
    WebElement addButton;

    @Getter
    @FindBy(xpath = "//button[contains(.,'Delete')]")
    WebElement deleteButton;

    public LoginPageFactory(WebDriver driver) {
        super(driver);
    }

    /**
     * Login.
     *
     * @param username the username
     * @param password the password
     */
    public void login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    /**
     * Get error message text string.
     *
     * @return the string
     */
    public String getErrorMessageText(){
        return errorMessage.getText();
    }

    /**
     * Wait for page opened login page factory.
     *
     * @return the login page factory
     */
    public LoginPageFactory waitForPageOpened(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return this;
    }
}
