package org.selenium_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Exercise4 {
    public static void main(String[] args) throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/Users/edwin.chi/Downloads/chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://the-internet.herokuapp.com/windows");


        driver.findElement(By.linkText("Click Here")).click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parent = it.next();
        String child = it.next();

        System.out.println("windows = " + windows);
        System.out.println("parent = " + parent);
        System.out.println("child = " + child);

        driver.switchTo().window(child);

        // Print child windows text
        String childText = driver.findElement(By.tagName("h3")).getText();
        System.out.println(childText);

        driver.switchTo().window(parent);

        // Print parent windows text
        String parentText = driver.findElement(By.tagName("h3")).getText();
        System.out.println(parentText);

        driver.quit();

    }
}
