package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.Base;

public class CartPage extends Base {

    @FindBy(css = ".shopping_cart")
    public WebElement shoppingCart;

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    public String getItemCountInCart() {
        // not using getText as it'll not return the innerText if element is hidden by css
        return this.shoppingCart.findElement(By.cssSelector(".ajax_cart_quantity")).getAttribute("innerText");
    }


}
