package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import setup.Base;
import data.DataProviderClass;

public class HomePageTest extends Base {
    HomePage homePage;

    @BeforeMethod(alwaysRun=true)
    public void initialize() {
        homePage = new HomePage();
    }

    @Test(priority = 1, dataProvider = "titleProvider", dataProviderClass = DataProviderClass.class, description = "Verify HomePage Title")
    public void assertTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(priority = 2, description = "Verify Menu Items")
    public void assertMenuList() {
        Assert.assertEquals(homePage.getMenuListText(), homePage.MENU_ITEMS);
    }

    @Test(priority = 3, dataProvider = "shopPhoneProvider", dataProviderClass = DataProviderClass.class, description = "Verify Shop Phone")
    public void assertShopPhone(String shopPhone) {
        Assert.assertTrue(homePage.shopPhone.getText().contains(shopPhone),"Wrong Shop Phone");
    }

    @Test(priority = 4, dataProvider = "storeAddressProvider", dataProviderClass = DataProviderClass.class, description = "Verify Store Address")
    public void assertStoreAddress(String storeAddress) {
        Assert.assertTrue(homePage.getStoreAddress().contains(storeAddress),"Wrong Store Address");
    }

    @Test(priority = 5, dataProvider = "storePhoneProvider", dataProviderClass = DataProviderClass.class, description = "Verify Store Phone")
    public void assertStorePhone(String storePhone) {
        Assert.assertTrue(homePage.getStorePhone().contains(storePhone),"Wrong Store Phone");
    }

    @Test(priority = 6, dataProvider = "storeEmailProvider", dataProviderClass = DataProviderClass.class, description = "Verify Store Email")
    public void assertStoreEmail(String storeEmail) {
        Assert.assertTrue(homePage.getStoreEmail().contains(storeEmail),"Wrong Store Email");
    }
}
