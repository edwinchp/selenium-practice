package org.selenium_practice;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Exercise8 {
    public static void main(String[] args) throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/Users/edwin.chi/Downloads/chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String expectedCountry = "India";
        String lowerCaseCountry = expectedCountry.split("i")[0].toLowerCase();

        // 1. Enter text
        driver.findElement(By.id("autocomplete")).sendKeys(lowerCaseCountry);

        // 2. Select second options
        driver.findElement(By.xpath("//ul[@id='ui-id-1']//li[2]")).click();

        // 3. Grab text from input
        String inputText = driver.findElement(By.id("autocomplete")).getAttribute("value").trim();

        // 4. Validate
        Assert.assertEquals(expectedCountry, inputText);

        driver.quit();
    }
}
