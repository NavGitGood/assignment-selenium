package helper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import setup.Base;

public class ActionHelper extends Base {

    Actions ac;

    public ActionHelper() {
        ac = new Actions(driver);
    }

    public void mouseOverAndClickSubElement(WebElement toHover, WebElement toClick) {
        this.ac.moveToElement(toHover).moveToElement(toClick).click(toClick).build().perform();
    }
}
