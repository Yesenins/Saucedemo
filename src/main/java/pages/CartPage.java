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
    public static final String REMOVE_BUTTON = CART_ITEM + "//button[text()='Remove']";
    public static final String PRODUCT_PRICE = CART_ITEM + "//*[@data-test='inventory-item-price']";
    public static final String PRODUCT_QUANTITY = CART_ITEM + "//*[data-test=\"item-quantity\"]";
    public static final String CART_ITEM_CONTAINER ="//*[@class=\"cart_item\"]";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openPage(String url){
        driver.get(url);
    }

    public String getProductPriceText(String productName){
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE,productName))).getText();
    }

    public Integer getProductQuantity(){
        return driver.findElements(By.xpath(CART_ITEM_CONTAINER)).size();
    }

    public List<WebElement> getAllProductsInShoppingCart(){
        return driver.findElements(CART_PRODUCT);
    }

    public void removeProductFromCart(String... productNames){
        for (String productsName : productNames){
            driver.findElement(By.xpath(String.format(REMOVE_BUTTON, productsName))).click();
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

    public void checkoutButton(){
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public void continueShoppingButton(){
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }
    public boolean isProductDisplayed(String productName){
        return !driver.findElements(By.xpath(String.format(CART_ITEM, productName))).isEmpty();
    }
}
