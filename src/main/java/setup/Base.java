package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;
    public static Integer explicitTimeout = Integer.parseInt(ConfigurationLoader.getPropertyValue("explicitTimeout"));
    public static Integer implicitTimeout = Integer.parseInt(ConfigurationLoader.getPropertyValue("implicitTimeout"));

    @BeforeSuite(alwaysRun = true)
    public static void setup() {

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
        driver.manage().timeouts().implicitlyWait(implicitTimeout, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(ConfigurationLoader.getPropertyValue("url"));
    }

    public static void setChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver.exe");
        driver = new ChromeDriver(options);
    }

    public static void setIE() {
        System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "IEDriverServer.exe");
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
        options.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
        options.withInitialBrowserUrl("");
        options.ignoreZoomSettings();
        driver = new InternetExplorerDriver(options);
    }

    public static void setEdge() {
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "msedgedriver.exe");
        driver = new EdgeDriver();
    }

    public static void setFirefox() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "geckodriver.exe");
        File pathBinary = new File(ConfigurationLoader.getPropertyValue("firefoxBinary"));
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
                System.out.println(e);
            }
        }
    }
}
