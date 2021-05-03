package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.Base;

public class LoginPage extends Base {

    public String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    @FindBy(css = ".login")
    public WebElement signInBtn;

    @FindBy(css = "#email")
    public WebElement emailTxt;

    @FindBy(css = "#passwd")
    public WebElement passwordTxt;

    @FindBy(css = "#SubmitLogin")
    public WebElement submitBtn;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }


}
