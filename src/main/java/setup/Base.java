package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;

import java.io.File;
import java.lang.invoke.SwitchPoint;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;

    static {

        switch(ConfigurationLoader.getPropertyValue("browser")) {
            case "chrome":
                setChrome();
                break;
            case "ie":
                setIE();
                break;
            case "edge":
                setEdge();
                break;
            case "firefox":
                setFirefox();
                break;
            default:
                System.out.println("No browser provided");
                System.exit(1);
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(ConfigurationLoader.getPropertyValue("url"));
    }

    public static void setChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        driver = new ChromeDriver(options);
    }

    public static void setIE() {
        System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/drivers/IEDriverServer_new.exe");
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.withInitialBrowserUrl("");
        options.ignoreZoomSettings();
        driver = new InternetExplorerDriver(options);
    }

    public static void setEdge() {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/drivers/msedgedriver.exe");
        driver = new EdgeDriver();
    }

    public static void setFirefox() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
        File pathBinary = new File("C:\\Users\\navneetgupta01\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
        FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
        DesiredCapabilities desired = DesiredCapabilities.firefox();
        FirefoxOptions options = new FirefoxOptions();
        desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
        driver = new FirefoxDriver(options);
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
