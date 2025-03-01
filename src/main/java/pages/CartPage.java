package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class CartPage extends HeaderPage{

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    @FindBy(id = "continue-shopping")
    WebElement continueShoppingButton;

    @FindBys(@FindBy(css = ".inventory_item_name"))
    public List<WebElement> namesProductsInCart;

    @FindBys(@FindBy(css = ".cart_item"))
    public List<WebElement> cartProduct;

    @FindBys(@FindBy(xpath= "//*[@class=\"cart_item\"]"))
    public List<WebElement> cartItemContainer;

    public static final String CART_ITEM = "//*[text()='%s']/ancestor::*[@class='cart_item']";

    public static final String REMOVE_BUTTON = CART_ITEM + "//button[text()='Remove']";

    public static final String PRODUCT_PRICE = CART_ITEM + "//*[@data-test='inventory-item-price']";

    public static final String PRODUCT_QUANTITY = CART_ITEM + "//*[data-test=\"item-quantity\"]";

    /**
     * Instantiates a new Cart page.
     *
     * @param driver the driver
     */
    public CartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Open cart page cart page.
     *
     * @param url the url
     * @return the cart page
     */
    public CartPage openCartPage(String url){
        log.info("Open Cart Page Url {}", url);
        driver.get(url);
        return this;
    }

    /**
     * Get product price text string.
     *
     * @param productName the product name
     * @return the string
     */
    public String getProductPriceText(String productName){
        String priceText = driver.findElement(By.xpath(String.format(PRODUCT_PRICE,productName))).getText();
        log.info("Get product price: {}", priceText);
        return priceText;
    }

    /**
     * Get product quantity integer.
     *
     * @return the integer
     */
    public int getProductQuantity(){
        int productQuantity = cartItemContainer.size();
        log.info("Get product quantity: {}", productQuantity);
        return productQuantity;
    }

    /**
     * Get all products in shopping cart list.
     *
     * @return the list
     */
    public List<WebElement> getAllProductsInShoppingCart(){
        return cartProduct;
    }

    /**
     * Remove product from cart cart page.
     *
     * @param productNames the product names
     * @return the cart page
     */
    public CartPage removeProductFromCart(String... productNames){
        for (String productsName : productNames){
            log.info("Remove product {} from cart", productsName);
            driver.findElement(By.xpath(String.format(REMOVE_BUTTON, productsName))).click();
        }
        return this;
    }

    /**
     * Get names products in shopping cart list.
     *
     * @return the list
     */
    public List<String> getNamesProductsInShoppingCart(){
        List<String> list = new ArrayList<>();
        for (WebElement item : namesProductsInCart){
            list.add(item.getText());
        }
        return list;
    }

    /**
     * Get price double.
     *
     * @param productName the product name
     * @return the double
     */
    public double getPrice(String productName){
        String productPrice = driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
        log.info("Get price for product: {}. Price is:{}", productName, productPrice);
        return Double.parseDouble(productPrice.replace("$",""));
    }

    /**
     * Checkout button checkout page.
     *
     * @return the checkout page
     */
    public CheckoutPage checkoutButton(){
        checkoutButton.click();
        waiters.waitForPageLoaded();
        return new CheckoutPage(driver);
    }

    /**
     * Continue shopping button products page.
     *
     * @return the products page
     */
    public ProductsPage continueShoppingButton(){
        continueShoppingButton.click();
        waiters.waitForPageLoaded();
        return new ProductsPage(driver);
    }

    /**
     * Is product displayed boolean.
     *
     * @param productName the product name
     * @return the boolean
     */
    public boolean isProductDisplayed(String productName){
        return !driver.findElements(By.xpath(String.format(CART_ITEM, productName))).isEmpty();
    }
}