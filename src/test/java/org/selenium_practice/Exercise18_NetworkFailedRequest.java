package org.selenium_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v109.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v109.fetch.Fetch;
import org.openqa.selenium.devtools.v109.network.model.ErrorReason;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

public class Exercise18_NetworkFailedRequest {
    public static void main(String[] args) throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/Users/edwin.chi/Downloads/chrome/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        Optional<List<RequestPattern>> patterns = Optional.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook*"), Optional.empty(), Optional.empty())));

        devTools.send(Fetch.enable(patterns, Optional.empty()));
        devTools.addListener(Fetch.requestPaused(), request -> {
           devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
        });

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://rahulshettyacademy.com/angularAppDemo/");
        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
    }
}
