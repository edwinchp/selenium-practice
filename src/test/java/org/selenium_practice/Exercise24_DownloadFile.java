package org.selenium_practice;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;

public class Exercise24_DownloadFile {
    public static void main(String[] args) throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/home/edwinchp/Documents/drivers/chromedriver");
        String downloadPath = System.getProperty("user.dir") + "/target";

        /*
            Tell Chrome to change the default download path to the target folder
         */
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        System.out.println("downloadPath = " + downloadPath);

        /*
            Driver is created and Selenium actions are performed
         */
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("http://the-internet.herokuapp.com/download");
        driver.findElement(By.linkText("test.pdf")).click();
        Thread.sleep(3000);

        /*
           Find the file stored in target file.
         */

        File f = new File(downloadPath + "/test.pdf");
        Assert.assertTrue("File exists!", f.exists());
        Assert.assertTrue("File deleted.", f.delete());

        driver.quit();
    }
}
