package org.selenium_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise12 {
    public static void main(String[] args) throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/Users/edwin.chi/Downloads/chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");



        driver.findElement(By.xpath("//table//th[1]")).click();

        List<String> fruitNames = new ArrayList<>();



        WebElement nextButton = driver.findElement(By.xpath("//a[@aria-label='Next']"));

        do {
            getData(driver, fruitNames);
            nextButton.click();
        }
        while (nextButton.getAttribute("aria-disabled").equalsIgnoreCase("false"));

        getData(driver, fruitNames);

        List<String> orderedFruitNames = fruitNames.stream().sorted().collect(Collectors.toList());


        System.out.println("fruitNames = " + fruitNames);
        System.out.println("orderedFruitNames = " + orderedFruitNames);

        driver.quit();
    }

    public static void getData(WebDriver driver, List<String> fruitNames){
        List<WebElement> fruits = driver.findElements(By.xpath("//table//td[1]"));
        List<String> fruitsPerPage = fruits.stream().map(WebElement::getText).collect(Collectors.toList());
        fruitNames.addAll(fruitsPerPage);
    }

}
