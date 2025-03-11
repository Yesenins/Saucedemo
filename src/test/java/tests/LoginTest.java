package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTest extends Preconditions {
    public static final String EMPTY_FIELD_USERNAME_ERROR = "Epic sadface: Username is required";
    public static final String EMPTY_FIELD_PASSWORD_ERROR = "Epic sadface: Password is required";
    public static final String INCORRECT_DATA_IN_FIELDS = "Epic sadface: Username and password do not match any user in this service";

    @Test(description = "check if an error message is displayed when an empty user name is entered")
    public void loginWithEmptyUsernameTest(){
        loginSteps
                .loginAndWaitForPageOpened(userWithEmptyUserName)
                .checkErrorMessageOutput(EMPTY_FIELD_USERNAME_ERROR);
    }

    @Test(description = "QA-1 This test login on site with empty password")
    public void loginWithEmptyPasswordTest(){
        loginSteps
                .loginAndWaitForPageOpened(userWithEmptyPassword)
                .checkErrorMessageOutput(EMPTY_FIELD_PASSWORD_ERROR);
    }

    @Test(description = "check for error message output when input fields are empty")
    public void loginWithEmptyFieldsTest(){
        loginSteps
                .loginAndWaitForPageOpened(userWithEmptyFields)
                .checkErrorMessageOutput(EMPTY_FIELD_USERNAME_ERROR);
    }

    @Test(description = "checking for error message output in case of incorrect data")
    public void loginWithIncorrectFieldsTest(){
        loginSteps
                .loginAndWaitForPageOpened(userWithIncorrectFields)
                .checkErrorMessageOutput(INCORRECT_DATA_IN_FIELDS);
    }

    @Test
    public void loginWithoutPageFactory() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButton = loginPageFactory.getAddButton();
        addButton.click();
        WebElement deleteButton = loginPageFactory.getDeleteButton();
        deleteButton.click();

        addButton.click();
        deleteButton.click();
    }

    //    @Parameters({"username", "password"})
//    @Test()
//    public void loginTest(String user, String pass){
//        loginPage.openPage(LOGIN_PAGE_URL);
//        loginPage.login(user,pass);
//        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
//    }
//    @Test
//    public void listTest(){
//        List<String> list = Arrays.asList("1", "2", "3");
//    }
}