package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends HeaderPage{
    public static final By CHECKOUT_BUTTON = By.id("checkout");
    public static final By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");
    public static final By REMOVE_BUTTON = By.xpath("//*[contains(text(),'Remove')]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getAllGoodsInShoppingCart(){
        return driver.findElements(By.cssSelector(".cart_item"));
    }

    public void removeButton(){
        driver.findElement(REMOVE_BUTTON).click();
    }

    public void checkoutButton(){
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public void continueShoppingButton(){
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }
}
