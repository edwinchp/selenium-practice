package org.selenium_practice;

import com.google.common.collect.ImmutableList;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v109.fetch.Fetch;
import org.openqa.selenium.devtools.v109.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v109.network.Network;
import org.openqa.selenium.devtools.v109.network.model.ErrorReason;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Exercise19_BlockNetworkRequest {
    public static void main(String[] args) throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/home/edwinchp/Documents/drivers/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.send(Network.setBlockedURLs(ImmutableList.of("*jpg", "*.png")));


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://phptravels.com/demo/");
    }
}
