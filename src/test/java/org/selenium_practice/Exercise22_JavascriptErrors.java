package org.selenium_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.net.URI;
import java.util.List;
import java.util.function.Predicate;

public class Exercise22_JavascriptErrors {
    public static void main(String[] args) throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/home/edwinchp/Documents/drivers/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://phptravels.com/pricing");

        /*
           Logs all the errors related to JS files when the page is loaded
           or some activity triggers the error.
         */

        LogEntries entry = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = entry.getAll();

        logs.forEach(s-> System.out.println("s = " + s.getMessage()));

        driver.quit();
    }
}
