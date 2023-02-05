package org.selenium_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Exercise7 {
    public static void main(String[] args) throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/Users/edwin.chi/Downloads/chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // 1. Print number of rows
        WebElement table = driver.findElement(By.id("product"));
        int rows = table.findElements(By.tagName("tr")).size();
        System.out.println("rows = " + rows);

        // 2. Print number of columns
        int columns = table.findElements(By.tagName("th")).size();
        System.out.println("columns = " + columns);

        // 3. Print second row
        String secondRow = table.findElements(By.tagName("tr")).get(2).getText();
        System.out.println("secondRow = " + secondRow);

        driver.quit();
    }
}
