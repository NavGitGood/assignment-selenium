package helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.Base;

public class ActionHelper extends Base {

    Actions ac;

    public ActionHelper() {
        ac = new Actions(driver);
    }

    public void mouseOverAndClickSubElement(WebElement toHover, WebElement toClick) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", toHover);
        new WebDriverWait(driver, explicitTimeout).until(ExpectedConditions.visibilityOf(toHover));
        this.ac.moveToElement(toHover).moveToElement(toClick).click(toClick).build().perform();
    }
}
