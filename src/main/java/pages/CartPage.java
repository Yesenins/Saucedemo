package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends HeaderPage{
    public static final By CHECKOUT_BUTTON = By.id("checkout");
    public static final By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");
    public static final By NAMES_PRODUCTS_IN_CART = By.cssSelector(".inventory_item_name");
    public static final By CART_PRODUCT = By.cssSelector(".cart_item");
    public static final String CART_ITEM = "//*[text()='%s']/ancestor::*[@class='cart_item']";
    public static final String REMOVE_PRODUCT_FROM_CART_BUTTON = CART_ITEM + "//button[text()='Remove']";
    public static final String PRODUCT_PRICE = CART_ITEM + "//*[@data-test='inventory-item-price']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getAllProductsInShoppingCart(){
        return driver.findElements(CART_PRODUCT);
    }

    public void removeProductFromCart(String... productName){
        for (String productsNames : productName){
            driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productsNames))).click();
        }
    }

    public List<String> getNamesProductsInShoppingCart(){
        List<String> list = new ArrayList<>();
        for (WebElement item : driver.findElements(NAMES_PRODUCTS_IN_CART)){
            list.add(item.getText());
        }
        return list;
    }

    public double getPrice(String productName){
        return Double.parseDouble(driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName)))
                .getText()
                .replace("$",""));
    }

    public int getQuantityOfAllGoods(){
        return getAllProductsInShoppingCart().size();
    }

    public void checkoutButton(){
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public void continueShoppingButton(){
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }
}
