package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CartSteps extends BaseSteps {
    public CartSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Checking that a product is not in the cart")
    public CartSteps verifyProductIsNotInCart(String productName){
        List<String> productsListInCart = cartPage.getNamesProductsInShoppingCart();
        for (String item : productsListInCart){
            Assert.assertFalse(item.contains(productName));
        }
        return this;
    }

    @Step("Checking that the site is open")
    public CartSteps checkSiteOpen(WebDriver driver, String url) {
        Assert.assertEquals(driver.getCurrentUrl(), url);
        return this;
    }

    @Step("Check if the number of items in the cart corresponds to the number of items on the cart icon")
    public CartSteps checkDisplayTheNumberOfGoodsOnCartIcon(String cartQuantity) {
        Assert.assertEquals(headerPage.getTextFromIcon(), cartQuantity);
        return this;
    }

    @Step("Checking that product names are displayed for each added product")
    public CartSteps checkThatTheNameIsDisplayedForEachAddedItem() {
        List<String> allGoodsNamesList = productsPage.getNamesProducts();
        headerPage.clickCartButton();
        Assert.assertTrue(allGoodsNamesList.containsAll(cartPage.getNamesProductsInShoppingCart()));
        return this;
    }

    @Step("Checking that items are displayed in the cart")
    public CartSteps checkThatItemsDisplayedInTheCart(int allQuantityProducts) {
        Assert.assertEquals(cartPage.getProductQuantity(), allQuantityProducts);
        return this;
    }

    @Step("Click on the continue shopping button")
    public CartSteps continueShopping() {
        cartPage.continueShoppingButton();
        return this;
    }

    @Step("Checking the price display for each item")
    public CartSteps checkThatThePriceDisplayedForItem(String productName, double price) {
        Assert.assertEquals(cartPage.getPrice(productName), price);
        return this;
    }

    @Step("entering information into the card for order placement")
    public CartSteps postalInformationCompletion(String firstName, String lastName, String zipCode) {
        cartPage.checkoutButton();
        checkoutPage.postalInformationCompletion(firstName, lastName, zipCode);
        return this;
    }

    @Step("checking that the price corresponds to the final price")
    public CartSteps checkThatPriceMatchesTotalPrice() {
        double priceOfGoods = 0;
        for (WebElement item : checkoutPage.getAllPrice()){
            priceOfGoods += Double.parseDouble(item.getText().replace("$",""));
        }
        double itemTotal = checkoutPage.getItemTotal();
        Assert.assertEquals(priceOfGoods, itemTotal);
        return this;
    }

    @Step("price matching")
    public CartSteps checkPrice(String productName, String price){
        Assert.assertEquals(cartPage.getProductPriceText(productName),price);
        return this;
    }

    @Step("quantity matching")
    public CartSteps checkQuantity( int expectedQuantity){
        Assert.assertEquals(cartPage.getProductQuantity(), expectedQuantity);
        return this;
    }

    @Step("deleting an item from the cart")
    public CartSteps removeProductFromCart(String... productName){
        headerPage.clickCartButton();
        cartPage.removeProductFromCart(productName);
        return this;
    }
}