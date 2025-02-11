package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HeaderPage extends BasePage{
    public static final By CART_BUTTON = By.cssSelector(".shopping_cart_link");
    public static final By PRODUCT_QUANTITY_ON_THE_CART_ICON = By.cssSelector(".shopping_cart_badge");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public String getTextFromIcon(){
        return driver.findElement(PRODUCT_QUANTITY_ON_THE_CART_ICON).getText();
    }

    public void clickCartButton(){
        driver.findElement(CART_BUTTON).click();
    }

}
