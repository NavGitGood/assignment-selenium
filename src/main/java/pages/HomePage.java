package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.Base;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends Base {

    public String TITLE = "My Store";
    public List<String> MENU_ITEMS = Arrays.asList("WOMEN", "DRESSES", "T-SHIRTS");

    @FindBy(css = "#nav-logo .nav-logo-locale")
    WebElement logoLocale;

    @FindBy(css = "#navFooter .navFooterCopyright span")
    WebElement copyright;

    @FindBy(css = "#block_top_menu > ul > li > a")
    List<WebElement> menuList;

    @FindBy(css = "span.shop-phone")
    public WebElement shopPhone;

    @FindBy(css = "#block_contact_infos ul li")
    List<WebElement> storeInfo;

    public HomePage() {
        PageFactory.initElements(driver, this);
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

}
