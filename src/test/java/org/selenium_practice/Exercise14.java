package org.selenium_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Exercise14 {
    public static void main(String[] args) throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/Users/edwin.chi/Downloads/chrome/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        Map parameters = new HashMap();
        parameters.put("width", 600);
        parameters.put("height", 1000);
        parameters.put("deviceScaleFactor", .50);
        parameters.put("mobile", true);
        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", parameters);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://google.com.mx");

    }
}
