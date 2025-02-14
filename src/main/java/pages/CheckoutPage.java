package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends CartPage{
    public static final By FIRSTNAME_INPUT = By.id("first-name");
    public static final By LASTNAME_INPUT = By.id("last-name");
    public static final By ZIP_CODE = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.id("continue");
    public static final By ITEM_TOTAL = By.cssSelector(".summary_subtotal_label");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public double getItemTotal(){
        return Double.parseDouble(driver.findElement(ITEM_TOTAL).getText()
                .replace("Item total: $",""));
    }

    public void postalInformationCompletion(String firstName, String lastName){
        driver.findElement(FIRSTNAME_INPUT).sendKeys(firstName);
        driver.findElement(LASTNAME_INPUT).sendKeys(lastName);
        driver.findElement(ZIP_CODE).sendKeys("12345");
        driver.findElement(CONTINUE_BUTTON).click();
    }
}
