package org.selenium_practice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Exercise3 {
    public static WebDriver driver;

    public static void main(String[] args) throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/Users/edwin.chi/Downloads/chrome/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        // Username
        sendKeys(By.id("username"), "rahulshettyacademy");
        // Password
        sendKeys(By.id("password"), "learning");
        // User Type
        click(By.xpath("//label[@class='customradio'][2]"));
        // Pop Up
        click(By.id("okayBtn"));
        // Student
        select(By.xpath("//select"), "Student");
        // Terms and Conditions
        click(By.id("terms"));
        // Sign In
        click(By.id("signInBtn"));

        // Shop Name header
        isDisplayed(By.xpath("//h1[text()='Shop Name']"));

        List<WebElement> productList = driver.findElements(By.cssSelector("button.btn.btn-info"));

        for (WebElement product: productList) {
            product.click();
        }
        // Checkout
        click(By.xpath("//div[@id='navbarResponsive']//li"));

        // Total header
        isDisplayed(By.xpath("//h3[text()='Total']"));

        driver.quit();
    }

    public static void click(By by){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }

    public static boolean isDisplayed(By by){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by)).isDisplayed();
    }

    public static void sendKeys(By by, String string){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(string);
    }

    public static void select(By by, String option){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));

        WebElement ele = driver.findElement(by);
        Select dropdown = new Select(ele);
        dropdown.selectByVisibleText(option);
    }
}
