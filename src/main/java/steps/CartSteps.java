package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CartSteps extends BaseSteps {
    public CartSteps(WebDriver driver) {
        super(driver);
    }

    @Step
    public CartSteps verifyProductIsNotInCart(String productName){
        List<String> productsListInCart = cartPage.getNamesProductsInShoppingCart();
        for (String item : productsListInCart){
            Assert.assertFalse(item.contains(productName));
        }
        return this;
    }

    @Step
    public CartSteps checkSiteOpen(WebDriver driver, String url) {
        Assert.assertEquals(driver.getCurrentUrl(), url);
        return this;
    }

    @Step
    public CartSteps checkDisplayTheNumberOfGoodsOnCartIcon(String cartQuantity) {
        Assert.assertEquals(headerPage.getTextFromIcon(), cartQuantity);
        return this;
    }

    @Step
    public CartSteps checkThatTheNameIsDisplayedForEachAddedItem() {
        List<String> allGoodsNamesList = productsPage.getNamesProducts();
        headerPage.clickCartButton();
        Assert.assertTrue(allGoodsNamesList.containsAll(cartPage.getNamesProductsInShoppingCart()));
        return this;
    }

    @Step
    public CartSteps checkThatItemsDisplayedInTheCart(int allQuantityProducts) {
        Assert.assertEquals(cartPage.getProductQuantity(), allQuantityProducts);
        return this;
    }

    @Step
    public CartSteps continueShopping() {
        cartPage.continueShoppingButton();
        return this;
    }

    @Step
    public CartSteps checkThatThePriceDisplayedForItem(String productName, double price) {
        Assert.assertEquals(cartPage.getPrice(productName), price);
        return this;
    }

    @Step
    public CartSteps postalInformationCompletion(String firstName, String lastName, String zipCode) {
        cartPage.checkoutButton();
        checkoutPage.postalInformationCompletion(firstName, lastName, zipCode);
        return this;
    }

    @Step
    public CartSteps checkThatPriceMatchesTotalPrice() {
        double priceOfGoods = 0;
        for (WebElement item : checkoutPage.getAllPrice()){
            priceOfGoods += Double.parseDouble(item.getText().replace("$",""));
        }
        double itemTotal = checkoutPage.getItemTotal();
        Assert.assertEquals(priceOfGoods, itemTotal);
        return this;
    }

    @Step
    public CartSteps checkPrice(String productName, String price){
        Assert.assertEquals(cartPage.getProductPriceText(productName),price);
        return this;
    }

    @Step
    public CartSteps checkQuantity( int expectedQuantity){
        Assert.assertEquals(cartPage.getProductQuantity(), expectedQuantity);
        return this;
    }

    @Step
    public CartSteps removeProductFromCart(String... productName){
        headerPage.clickCartButton();
        cartPage.removeProductFromCart(productName);
        return this;
    }
}
