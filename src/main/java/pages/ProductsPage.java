package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends HeaderPage{

    @FindBys(@FindBy(css = ".inventory_item_name"))
    List<WebElement> namesProducts;

    @FindBy(css = ".inventory_item")
    List<WebElement> product;

    public static final By ADD_TO_CART_BUTTON = By.xpath("//*[contains(text(),'Add to cart')]");

    public static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class" +
            "='inventory_item']";

    public static final String ADD_PRODUCT_TO_CART_BUTTON = PRODUCT_ITEM + "//button[contains" +
            "(text(), 'Add')]";

    public static final String REMOVE_PRODUCT_BUTTON = PRODUCT_ITEM + "//button[text()='Remove']";

    public static final String PRODUCT_PRICE_IN_PR_PAGE = PRODUCT_ITEM + "//*[@data-test='inventory-item-price']";

    /**
     * Add product to cart products page.
     *
     * @param productNames the product names
     * @return the products page
     */
    public ProductsPage addProductToCart(String... productNames) {
        for (String productsName : productNames){
            driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productsName))).click();
        }
        return this;
    }

    /**
     * Remove product products page.
     *
     * @param productNames the product names
     * @return the products page
     */
    public ProductsPage removeProduct(String... productNames){
        for (String productsName : productNames){
            driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_BUTTON, productsName))).click();
        }
        return this;
    }

    /**
     * Get names products list.
     *
     * @return the list
     */
    public List<String> getNamesProducts(){
        List<String> list = new ArrayList<>();
        for (WebElement item : namesProducts){
            list.add(item.getText());
        }
        return list;
    }

    /**
     * Add to cart all products products page.
     *
     * @return the products page
     */
    public ProductsPage addToCartAllProducts(){
        List<WebElement> allProductsList = getAllProducts();
        for (WebElement button : allProductsList){
            button.findElement(ADD_TO_CART_BUTTON).click();
        }
        return this;
    }

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Get all products list.
     *
     * @return the list
     */
    public List<WebElement> getAllProducts(){
        return product;
    }

    /**
     * Is add to cart button displayed boolean.
     *
     * @param productName the product name
     * @return the boolean
     */
    public boolean isAddToCartButtonDisplayed(String productName){
        return driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON,productName))).isDisplayed();
    }

    /**
     * Is remove button displayed boolean.
     *
     * @param productName the product name
     * @return the boolean
     */
    public boolean isRemoveButtonDisplayed(String productName){
        return driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_BUTTON,productName))).isDisplayed();
    }

    /**
     * Get product price string.
     *
     * @param productName the product name
     * @return the string
     */
    public String getProductPrice(String productName){
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE_IN_PR_PAGE,productName))).getText();
    }
}
