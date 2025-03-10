package com.automation.utils;

import com.automation.base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils extends BaseTest {

    // Method to capture screenshot
    public static void captureScreenshot(String testName) {
        try {
            // Generate timestamp for unique screenshot names
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            // Convert driver to TakesScreenshot
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Define screenshot file path
            String filePath = "screenshots/" + testName + "_" + timestamp + ".png";

            // Save the screenshot
            FileUtils.copyFile(srcFile, new File(filePath));

            System.out.println("Screenshot saved: " + filePath);
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
}
