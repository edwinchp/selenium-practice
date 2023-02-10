package org.selenium_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v109.network.Network;
import org.openqa.selenium.devtools.v109.network.model.Response;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Exercise16_NetworkResponses {
    public static void main(String[] args) throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/Users/edwin.chi/Downloads/chrome/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        
        // Listen events
        devTools.addListener(Network.responseReceived(), response -> {
           Response resp =  response.getResponse();
            System.out.println("resp.getUrl() = " + resp.getUrl());
            System.out.println("resp.getStatus() = " + resp.getStatus());
        });


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://rahulshettyacademy.com/angularAppDemo/");
        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
    }
}
