package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.Base;

public class LoginPage extends Base {

    public String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    @FindBy(css = ".login")
    public WebElement signInBtn;

    @FindBy(id = "email")
    public WebElement emailTxt;

    @FindBy(id = "passwd")
    public WebElement passwordTxt;

    @FindBy(id = "SubmitLogin")
    public WebElement submitBtn;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }


}
