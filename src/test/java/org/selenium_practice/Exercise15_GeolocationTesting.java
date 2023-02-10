package org.selenium_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Exercise15_GeolocationTesting {
    public static void main(String[] args) throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/Users/edwin.chi/Downloads/chrome/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("latitude", 46.227638);
        parameters.put("longitude", 2.213749);
        parameters.put("accuracy", 1);

        driver.executeCdpCommand("Emulation.setGeolocationOverride", parameters);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://my-location.org/");

    }
}
