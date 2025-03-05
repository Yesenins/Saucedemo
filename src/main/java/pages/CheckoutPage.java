package pages;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

@Log4j2
@Getter
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

    @FindBys(@FindBy(css = ".inventory_item_price"))
    List<WebElement> allPrice;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Get item total double.
     *
     * @return the double
     */
    public double getItemTotal(){
        double totalPrice = Double.parseDouble(itemTotal.getText()
                .replace("Item total: $",""));
        log.info("Get Item total: {}", totalPrice);
        return totalPrice;
    }

    /**
     * Postal information completion.
     *
     * @param firstName the first name
     * @param lastName  the last name
     */
    public void postalInformationCompletion(String firstName, String lastName, String code){
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        zipCode.sendKeys(code);
        log.info("Form filling: First name {}, Last name {}, ZipCode {}", firstName, lastName, code);
        continueButton.click();
    }
}