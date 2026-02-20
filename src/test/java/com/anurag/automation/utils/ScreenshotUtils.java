package com.anurag.automation.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
    
    public static String captureScreenshot(WebDriver driver, String testname){

        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String screenShotPath = "test-output/screesnhots/" + testname + "_" + timestamp + ".png";

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(screenShotPath);

        try {
            FileUtils.copyFile(src, dest);
        }catch(Exception e){
            e.printStackTrace();
        }
        return screenShotPath;

    }
}
