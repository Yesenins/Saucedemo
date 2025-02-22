package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends CartPage{

    @FindBy(id = "first-name")
    WebElement firstNameInput;

    @FindBy(id = "last-name")
    WebElement lastNameInput;

    @FindBy(id = "postal-code")
    WebElement zipCode;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(css = ".summary_subtotal_label")
    WebElement itemTotal;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Get item total double.
     *
     * @return the double
     */
    public double getItemTotal(){
        return Double.parseDouble(itemTotal.getText()
                .replace("Item total: $",""));
    }

    /**
     * Postal information completion.
     *
     * @param firstName the first name
     * @param lastName  the last name
     */
    public void postalInformationCompletion(String firstName, String lastName){
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        zipCode.sendKeys("12345");
        continueButton.click();
    }
}
