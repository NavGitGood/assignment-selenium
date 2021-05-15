package helper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.Base;

public class Wrappers extends Base {

    public void delayedClick(WebElement element) {
        new WebDriverWait(driver, explicitTimeout).until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

}
