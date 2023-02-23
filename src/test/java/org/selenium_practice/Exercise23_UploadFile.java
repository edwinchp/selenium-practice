package org.selenium_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;

public class Exercise23_UploadFile {
    public static void main(String[] args) throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/home/edwinchp/Documents/drivers/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.adobe.com/in/acrobat/online/pdf-to-jpg.html");
        driver.findElement(By.id("lifecycle-nativebutton")).click();
        Thread.sleep(3000);

        /*
           Using AutoIT
           Do not move your mouse when this execution is in progress.
         */
        Runtime.getRuntime().exec("C:\\Users\\edwinchp\\Documents\\autoITscript.exe");

        driver.quit();
    }
}
