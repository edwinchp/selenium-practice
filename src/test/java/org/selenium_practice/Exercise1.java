package org.selenium_practice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Exercise1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/edwin.chi/Downloads/chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        /**
         * 1. Check the first  Checkbox and verify if it is successfully checked
         * and Uncheck it again to verify if it is successfully Unchecked
         */
        driver.findElement(By.id("checkBoxOption1")).click();
        System.out.println("Is first checkbox selected? " + driver.findElement(By.id("checkBoxOption1")).isSelected());
        driver.findElement(By.id("checkBoxOption1")).click();
        System.out.println("Is first checkbox selected? " + driver.findElement(By.id("checkBoxOption1")).isSelected());

        /**
         * 2. How to get the Count of number of check boxes present in the page
         */
        List<WebElement> checkboxesList = driver.findElements(By.xpath("//input[@id='checkBoxOption1']//parent::label//parent::fieldset//input"));
        System.out.println("Checkboxes found: " + checkboxesList.size());

        driver.quit();
    }
}
