package org.selenium_practice;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class Exercise9 {
    public static void main(String[] args) throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/Users/edwin.chi/Downloads/chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String expectedCountry = "India";
        String lowerCaseCountry = expectedCountry.split("i")[0].toLowerCase();

        takeScreenshot(driver);

        // 1. Select a checkbox
        int option = 2;
        List<WebElement> checkboxList = driver.findElements(By.xpath("//div[@id='checkbox-example']//input"));
        checkboxList.get(--option).click();

        takeScreenshot(driver);

        // 2. Grab the label
        List<WebElement> labelList = driver.findElements(By.xpath("//div[@id='checkbox-example']//label"));
        String labelText = labelList.get(option).getText().trim();

        // 3. Select dropdown
        Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
        dropdown.selectByVisibleText(labelText);

        takeScreenshot(driver);

        // 4. Enter text
        driver.findElement(By.id("name")).sendKeys(labelText);

        takeScreenshot(driver);

        // 5. Click alert and validate
        driver.findElement(By.id("alertbtn")).click();
        String alertText = driver.switchTo().alert().getText();
        if(alertText.contains(labelText)) {
            System.out.println("labelText = " + labelText);
            System.out.println("alertText = " + alertText);
            System.out.println("Success");
        }

        takeScreenshot(driver);

        driver.quit();
    }

    public static void takeScreenshot(WebDriver driver) throws Throwable {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        long timestamp = date.getTime();
        FileUtils.copyFile(file, new File("C:\\users\\edwin.chi\\Documents\\Selenium\\screenshots\\screen-"+timestamp+".png"));
    }
}
