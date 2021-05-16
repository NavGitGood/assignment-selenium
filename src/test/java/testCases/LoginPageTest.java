package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import setup.Base;

public class LoginPageTest extends Base {
    LoginPage loginPage;

    @BeforeMethod(alwaysRun=true)
    public void initialize() {
        loginPage = new LoginPage();
    }

    @Test(priority = 1, description = "Verify Sign In Page URL")
    public void assertURLOfSignInPage() {
        loginPage.signInBtn.click();
        // unable to use driver.getCurrentUrl() directly because of an issue in IE,
        // causing it to return old url if there is no wait after click
        Assert.assertEquals(loginPage.getLoginPageURL(), loginPage.signInURL);
    }
}
