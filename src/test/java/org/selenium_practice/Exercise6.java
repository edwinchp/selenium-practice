package org.selenium_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Exercise6 {
    public static void main(String[] args) throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/Users/edwin.chi/Downloads/chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // 1. Select a checkbox
        int option = 2;
        List<WebElement> checkboxList = driver.findElements(By.xpath("//div[@id='checkbox-example']//input"));
        checkboxList.get(--option).click();

        // 2. Grab the label
        List<WebElement> labelList = driver.findElements(By.xpath("//div[@id='checkbox-example']//label"));
        String labelText = labelList.get(option).getText().trim();

        // 3. Select dropdown
        Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
        dropdown.selectByVisibleText(labelText);

        // 4. Enter text
        driver.findElement(By.id("name")).sendKeys(labelText);

        // 5. Click alert and validate
        driver.findElement(By.id("alertbtn")).click();
        String alertText = driver.switchTo().alert().getText();
        if(alertText.contains(labelText)) {
            System.out.println("labelText = " + labelText);
            System.out.println("alertText = " + alertText);
            System.out.println("Success");
        }

        driver.quit();
    }
}
