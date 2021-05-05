package setup;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import setup.ExtentReportSetup;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

public class TestListener extends ExtentReportSetup implements ITestListener
{
    String filePath = ""; //System.getProperty("user.dir")+"/output/current/";
    public void onTestStart(ITestResult result)
    {
        extentTest = extent.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result)
    {
        extentTest.log(Status.PASS, "Test Case Passed is ::: " +result.getMethod().getMethodName());
    }

    public void onTestFailure(ITestResult result)
    {
        Set<String> attributeNames = result.getAttributeNames();
//        attributeNames.forEach(System.out::println);
        extentTest.log(Status.FAIL, "Test Case Failed is ::: " +result.getMethod().getMethodName());
        extentTest.log(Status.FAIL, result.getThrowable());

        try
        {
            String description = result.getMethod().getDescription();
            extentTest.addScreenCaptureFromPath(takeScreenShot(result.getMethod().getDescription(), driver));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result)
    {
        extentTest.log(Status.SKIP, "Test Case Skipped is ::: " +result.getMethod().getMethodName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result)
    {

    }

    public void onStart(ITestContext context)
    {
        extent = ExtentReportSetup.extentReportSetup();
    }

    public void onFinish(ITestContext context)
    {
        extent.flush();
    }

    public String takeScreenShot(String methodName, WebDriver driver) {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Path destFile = (new File(ExtentReportSetup.pathToBeCreated + "/" +methodName+".png")).toPath();
        try {
            Files.copy(scrFile.toPath(), destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return methodName+".png";
    }
}
