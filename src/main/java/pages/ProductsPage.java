package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends HeaderPage{

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getAllGoods(){
        return driver.findElements(By.cssSelector(".inventory_item"));
    }

}
