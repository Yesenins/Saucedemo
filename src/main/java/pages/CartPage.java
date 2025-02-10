package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends HeaderPage{
    public static final By CHECKOUT_BUTTON = By.id("checkout");
    public static final By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");
    public static final By REMOVE_BUTTON = By.xpath("//*[contains(text(),'Remove')]");
    public static final By CART_ITEM = By.cssSelector(".cart_item");
    public static final By NAMES_PRODUCTS_IN_CART = By.cssSelector(".inventory_item_name");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getAllProductsInShoppingCart(){
        return driver.findElements(CART_ITEM);
    }

    public List<String> getNamesProductsInShoppingCart(){
        List<String> list = new ArrayList<>();
        for (WebElement item : driver.findElements(NAMES_PRODUCTS_IN_CART)){
            list.add(item.getText());
        }
        return list;
    }

    public String getPrice(){
//        return driver.findElement(By.xpath("//*[text()='7.99']")).getText();
    }

    public int getQuantityOfAllGoods(){
        return getAllProductsInShoppingCart().size();
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
