package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HeaderPage extends BasePage{

    public static final By CART_BUTTON = By.cssSelector(".shopping_cart_link");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public void clickCartButton(){
        driver.findElement(CART_BUTTON).click();
    }

}
