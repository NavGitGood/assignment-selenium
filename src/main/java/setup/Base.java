package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;

    static {
//        System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/drivers/IEDriverServer_new.exe");
//        InternetExplorerOptions options = new InternetExplorerOptions();
//        options.withInitialBrowserUrl("");
//        options.ignoreZoomSettings();

//        driver = new InternetExplorerDriver(options);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(ConfigurationLoader.getPropertyValue("url"));
    }

    public void navigateToHomePage() {
        driver.get(ConfigurationLoader.getPropertyValue("url"));
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDownDriver() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (WebDriverException e) {
                System.out.println("***** CAUGHT EXCEPTION IN DRIVER TEARDOWN *****");
                System.out.println(e);
            }
        }
    }
}
