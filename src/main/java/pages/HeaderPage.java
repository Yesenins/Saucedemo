package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage{

    @FindBy(css = ".shopping_cart_link")
    WebElement cartButton;

    @FindBy(css = ".shopping_cart_badge")
    WebElement productQuantityOnTheCartIcon;

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Get text from icon string.
     *
     * @return the string
     */
    public String getTextFromIcon(){
        return productQuantityOnTheCartIcon.getText();
    }

    /**
     * Click cart button cart page.
     *
     * @return the cart page
     */
    public CartPage clickCartButton(){
        cartButton.click();
        waiters.waitForPageLoaded();
        return new CartPage(driver);
    }
}
