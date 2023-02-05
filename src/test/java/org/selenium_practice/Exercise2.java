package org.selenium_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Exercise2 {
    public static void main(String[] args) throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/Users/edwin.chi/Downloads/chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        // Name
        driver.findElement(By.name("name")).sendKeys("Edwin");
        // Email
        driver.findElement(By.name("email")).sendKeys("edwin@gmail.com");
        // Password
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("sk@31S_Sirrn332");
        // Checkbox
        driver.findElement(By.id("exampleCheck1")).click();
        // Gender
        WebElement element = driver.findElement(By.id("exampleFormControlSelect1"));
        Select dropdown = new Select(element);
        dropdown.selectByIndex(0);
        // Employment status
        driver.findElement(By.id("inlineRadio1")).click();
        // Date of Birth
        driver.findElement(By.name("bday")).sendKeys("04/10/1995");
        // Submit
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(2000);

        // Success alert
        String successText = driver.findElement(By.xpath("//div[contains(@class, 'alert')]")).getText();
        System.out.println(successText);

        driver.quit();

    }
}
