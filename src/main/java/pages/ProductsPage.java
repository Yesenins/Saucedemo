package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends HeaderPage{
    public static final By ADD_TO_CART_BUTTON = By.xpath("//*[contains(text(),'Add to cart')]");
    public static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class" +
            "='inventory_item']";
    public static final String ADD_PRODUCT_TO_CART_BUTTON = PRODUCT_ITEM + "//button[contains" +
            "(text(), 'Add')]";
    public static final By NAMES_PRODUCTS = By.cssSelector(".inventory_item_name ");
    public static final By PRODUCT = By.cssSelector(".inventory_item");


    public void addProductToCart(String... productName) {
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
    }

    public List<String> getNamesProducts(){
        List<String> list = new ArrayList<>();
        for (WebElement item : driver.findElements(NAMES_PRODUCTS)){
            list.add(item.getText());
        }
        return list;
    }

    public void addToCartAllProducts(){
        List<WebElement> allProductsList = getAllProducts();
        for (WebElement button :allProductsList){
            button.findElement(ADD_TO_CART_BUTTON).click();
        }
    }

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getAllProducts(){
        return driver.findElements(PRODUCT);
    }

}
