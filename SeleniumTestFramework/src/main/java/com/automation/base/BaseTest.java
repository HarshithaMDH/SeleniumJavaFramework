package com.automation.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Properties prop;

    public static void setup() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            prop.load(fis);

            WebDriverManager.chromedriver().setup();

            // Chrome Options
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*"); // Fix for latest Chrome versions

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.get(prop.getProperty("url"));

            // Explicit wait setup (50 seconds default wait time)
            wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null; // Optionally, set driver to null after quitting
        }
    }
}
