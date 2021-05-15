package helper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.Base;

public class Wrappers extends Base {

    public Integer timeout = 2000;

    public Wrappers() { }

    public void delayedClick(WebElement element) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

}
