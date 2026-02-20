package com.anurag.automation.base;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.anurag.automation.utils.ExtentManager;
import com.anurag.automation.utils.ScreenshotUtils;
import com.anurag.automation.utils.configReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class BaseTest {
    
    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void beforeSuite(){
        extent = ExtentManager.getInstance();
    }


    @BeforeMethod
    public void setup(Method method){
        test = extent.createTest(method.getName());

        String browser = configReader.getProperty("browser");
        String url = configReader.getProperty("url");

        driver = DriverFactory.getDriver(browser);
        driver.get(url);
    }

    @AfterMethod
    public void tearDown(ITestResult result){

        if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        }else if (result.getStatus() == ITestResult.FAILURE) {

            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, result.getName());
            test.fail(result.getThrowable(),MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }else{
            test.skip("Test Skipped");
        }
        if(driver!=null){
            driver.quit();
        }
    }

    @AfterSuite
    public void flushreport(){
        if(extent!=null){
            extent.flush();
        }
    }
}
