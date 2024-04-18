package org.challenge.testUtils;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest {

    private AndroidDriver driver;
    private String ipAddress;
    private String port;
    private String deviceName;
    private String runTimeEnv;
    private static final String USER_DIR = "user.dir";

@BeforeClass
	public void setUp() throws MalformedURLException
	{
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("deviceName", "Samsung API 30");
        dc.setCapability("app", "C:\\com.fivemobile.thescore-22.16.0-APK4Fun.com.apk");
        dc.setCapability("platformVersion", "11.0");
     
        
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, dc);
        
    }

    @AfterClass
    public void tearDown() {
        System.out.println("In tear down");
        driver.quit();
        //  service.stop();
    }
 
    public String getScreenshotPath(String testCaseName, AndroidDriver driver) throws IOException {
        File source = driver.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty(USER_DIR) + "/reports//" + testCaseName + ".png";
        System.out.println("path: :" + path);
        String destinationFile = System.getProperty(USER_DIR) + "//reports//" + testCaseName + ".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }
}
