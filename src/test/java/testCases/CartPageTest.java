package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import setup.Base;

public class CartPageTest extends Base {

    CartPage cartPage;
    HomePage homePage;

    @BeforeMethod(alwaysRun=true)
    public void initialize() {
        cartPage = new CartPage();
        homePage = new HomePage();
//        homePage.navigateToHomePage();
    }

    @Test(priority = 1, description = "Verify Cart To Be Empty")
    public void assertCartEmpty() {
        Assert.assertEquals(cartPage.getItemCountInCart(), "0");
    }

    @Test(priority = 1, description = "Verify Cart To Be Have 1 Item When 1 Item Is Added")
    public void assertCartHasItem() {
        homePage.addItemToCartAndClose(0);
        Assert.assertEquals(cartPage.getItemCountInCart(), "1");
    }

}
