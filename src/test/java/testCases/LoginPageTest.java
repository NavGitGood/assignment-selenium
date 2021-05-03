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
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.URL);
    }

    @Test(priority = 2, description = "Verify Value in Email Field")
    public void assertValueInEmailField() {
        loginPage.emailTxt.sendKeys("nagp@gmail.com");
        System.out.println(loginPage.emailTxt.getAttribute("value"));
        loginPage.passwordTxt.sendKeys("somepassword");
        System.out.println(loginPage.passwordTxt.getAttribute("value"));
//        Assert.assertEquals(driver.getCurrentUrl(), loginPage.URL);
    }
}
