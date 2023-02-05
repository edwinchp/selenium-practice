package org.selenium_practice;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class Exercise10 {
    public static void main(String[] args) throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/Users/edwin.chi/Downloads/chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");


        WebElement footer = driver.findElement(By.id("gf-BIG"));
        List<WebElement> links = footer.findElements(By.tagName("a"));

        //SoftAssert softAssert = new SoftAssert();

        for (WebElement link: links) {
            String href = link.getAttribute("href");
            URL url = new URL(href);
            HttpURLConnection connection = ((HttpURLConnection) url.openConnection());
            connection.setRequestMethod("HEAD");
            connection.connect();
            int code = connection.getResponseCode();
            //softAssert.assertTrue(code < 400, "Link is broken: " + href);
        }

        //softAssert.assertAll();
        driver.quit();
    }

}
