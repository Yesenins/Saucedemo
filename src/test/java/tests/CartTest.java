package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class CartTest extends BaseTest{

    @Test(description = "smoke test: Check that the shopping cart link is active")
    public void shoppingCartLinkTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        headerPage.clickCartButton();
        Assert.assertEquals(driver.getCurrentUrl(),CART_PAGE_URL);
    }

    @Test(description = "Check that all added items are displayed in the cart ")
    public void displayAllAddGoodsTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        List<WebElement> ALL_GOODS = productsPage.getAllGoods();
        for (WebElement button :ALL_GOODS){
            button.findElement(By.xpath("//*[contains(text(),'Add to cart')]")).click();
        }
        headerPage.clickCartButton();
        int quantityOfAllGoods = cartPage.getAllGoodsInShoppingCart().size();
        Assert.assertEquals(6,quantityOfAllGoods);
//        Assert.assertEquals(driver.findElement(By.cssSelector(".shopping_cart_badge")).getText(),String.valueOf(quantityOfAllGoods));
    }

    @Test(description = "Check that the cart icon shows the added quantity of goods")
    public void displayTheNumberOfGoodsOnCartIconAddTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".shopping_cart_badge")).getText(),"2");
    }

    @Test(description = "Check that the cart icon displays the correct number of items after adding and removing items")
    public void displayTheNumberOfGoodsOnCartIconRemoveTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        headerPage.clickCartButton();
        cartPage.continueShoppingButton();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        headerPage.clickCartButton();
        cartPage.removeButton();
        cartPage.removeButton();
        Assert.assertEquals(driver.findElement(By.cssSelector(".shopping_cart_badge")).getText(),"1");
    }

    @Test(description = "Check that the item can be removed from the cart and it disappears after removal")
    public void displayRemoveGoodsTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
        headerPage.clickCartButton();
        driver.findElement(By.id("remove-sauce-labs-bike-light")).click();
        List<WebElement> ALL_GOODS_IN_CART = cartPage.getAllGoodsInShoppingCart();
        for (WebElement item : ALL_GOODS_IN_CART){
            Assert.assertFalse(item.findElement(By.cssSelector(".inventory_item_name")).getText().contains(SAUCE_LABS_BIKE_LIGHT));
        }
    }

    @Test(description = "Check that the name is displayed for each added item")
    public void displayNameOfGoodsTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        List<WebElement> ALL_GOODS = productsPage.getAllGoods();
        List<String> ALL_GOODS_NAMES = new ArrayList<>();
        for (WebElement button :ALL_GOODS){
            button.findElement(By.xpath("//*[contains(text(),'Add to cart')]")).click();
            ALL_GOODS_NAMES.add(driver.findElement(By.cssSelector(".inventory_item_name ")).getText());
        }
        headerPage.clickCartButton();
        List<WebElement> ALL_GOODS_IN_CART = cartPage.getAllGoodsInShoppingCart();
        List<String> ALL_GOODS_NAMES_IN_CART = new ArrayList<>();
        for (WebElement item : ALL_GOODS_IN_CART){
            ALL_GOODS_NAMES_IN_CART.add(driver.findElement(By.cssSelector(".inventory_item_name")).getText());
        }
        Assert.assertTrue(ALL_GOODS_NAMES.containsAll(ALL_GOODS_NAMES_IN_CART));
    }

    @Test(description = "Check that the price is displayed for each added item")
    public void displayPriceOfGoodsTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        headerPage.clickCartButton();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='7.99']")).getText().contains("7.99"));
    }

    @Test(description = "Check that the price without tax matches the total cost of goods")
    public void checkoutTotalPriceTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        String PRICE_OF_ONESIE = driver.findElement(By.xpath("//*[text()=\"9.99\"]")).getText();
        String PRICE_OF_BIKE_LIGHT = driver.findElement(By.xpath("//*[text()=\"7.99\"]")).getText();
        double priceOfGoods = Double.parseDouble(PRICE_OF_ONESIE.replace("$","")) + Double.parseDouble(PRICE_OF_BIKE_LIGHT.replace("$",""));
        headerPage.clickCartButton();
        cartPage.checkoutButton();
        checkoutPage.checkoutInformation("Serega","Super");
        double itemTotal = Double.parseDouble(driver.findElement(By.xpath("//*[text()=\"17.98\"]")).getText().replace("Item total: $", ""));
        Assert.assertEquals(priceOfGoods,itemTotal);
    }
}
