package helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.Base;
import setup.ConfigurationLoader;

public class ActionHelper extends Base {

    Actions ac;

    public ActionHelper() {
        ac = new Actions(driver);
    }

    public void mouseOverAndClickSubElement(WebElement toHover, WebElement toClick) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", toHover);
        new WebDriverWait(driver, explicitTimeout).until(ExpectedConditions.visibilityOf(toHover));

        // this custom solution has to be used for IE as actions are not working in desired way there
        if (ConfigurationLoader.getPropertyValue("browser").equals("ie")) {
            try {
                String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
                ((JavascriptExecutor) driver).executeScript(mouseOverScript,toHover);
                Thread.sleep(1000);
                ((JavascriptExecutor) driver).executeScript(mouseOverScript,toClick);
                Thread.sleep(1000);
                ((JavascriptExecutor)driver).executeScript("arguments[0].click();",toClick);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else {
            this.ac.moveToElement(toHover).moveToElement(toClick).click(toClick).build().perform();
        }


    }
}
