package pages;

import helper.ActionHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.Base;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends Base {

    ActionHelper actionHelper;

    public String TITLE = "My Store";
    public List<String> MENU_ITEMS = Arrays.asList("WOMEN", "DRESSES", "T-SHIRTS");

    @FindBy(css = "#block_top_menu > ul > li > a")
    List<WebElement> menuList;

    @FindBy(css = "span.shop-phone")
    public WebElement shopPhone;

    @FindBy(css = "#block_contact_infos ul li")
    List<WebElement> storeInfo;

    @FindBy(css = "#homefeatured > li")
    List<WebElement> featuredItems;

    @FindBy(id = "layer_cart")
    WebElement onAddBanner;

    public HomePage() {
        PageFactory.initElements(driver, this);
        actionHelper = new ActionHelper();
    }

    public List<String> getMenuListText() {
         return this.menuList.stream()
                .map(item -> item.getText())
         .collect(Collectors.toList());
    }

    public String getStoreAddress() {
        return this.storeInfo.get(0).getText().trim();
    }

    public String getStorePhone() {
        return this.storeInfo.get(1).getText().trim();
    }

    public String getStoreEmail() {
        return this.storeInfo.get(2).getText().trim();
    }

    public void addItemToCartAndClose(Integer index) {
        actionHelper.mouseOverAndClickSubElement(this.featuredItems.get(index), this.featuredItems.get(index).findElement(By.cssSelector(".ajax_add_to_cart_button")));
        this.onAddBanner.findElement(By.cssSelector("[title='Close window']")).click();
    }

}
