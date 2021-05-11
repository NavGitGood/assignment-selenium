package setup;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import helper.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ExtentReportSetup extends Base
{
    public static ExtentReports extent;
    public static ExtentTest extentTest;
    public static ExtentHtmlReporter htmlReporter;
    public static String pathToBeCreated = "";

    public static ExtentReports extentReportSetup() {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        String baseDirectory = System.getProperty("user.dir") + File.separator + ConfigurationLoader.getPropertyValue("outputBaseDirectory");
        String partialFolderName = ConfigurationLoader.getPropertyValue("latestReportDirectory");
        String archiveDirectoryName = ConfigurationLoader.getPropertyValue("archiveDirectory");

        String matchingName = Utils.matchPath(baseDirectory, partialFolderName);

        String pathToBeDeleted = baseDirectory + File.separator + matchingName;
        try {
            String archivePathToBeCreated = baseDirectory + File.separator + archiveDirectoryName + File.separator + matchingName.replace(partialFolderName, "report_");
            Files.move(new File(pathToBeDeleted).toPath(), new File(archivePathToBeCreated + File.separator).toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Utils.emptyDirectory(pathToBeDeleted);
        pathToBeCreated = baseDirectory + File.separator + partialFolderName + "_" + timeStamp;
        Utils.createDirectory(pathToBeCreated);

        htmlReporter = new ExtentHtmlReporter(pathToBeCreated + File.separator + "ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Extent Report V4" + TimeUnit.SECONDS);
        htmlReporter.config().setTheme(Theme.DARK);

        return extent;
    }


}