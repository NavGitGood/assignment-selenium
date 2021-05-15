package helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import setup.Base;

public class ActionHelper extends Base {

    Actions ac;

    public ActionHelper() {
        ac = new Actions(driver);
    }

    public void mouseOverAndClickSubElement(WebElement toHover, WebElement toClick) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", toHover);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.ac.moveToElement(toHover).moveToElement(toClick).click(toClick).build().perform();
    }
}
