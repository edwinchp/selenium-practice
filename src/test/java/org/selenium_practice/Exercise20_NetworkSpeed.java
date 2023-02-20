package org.selenium_practice;

import com.google.common.collect.ImmutableList;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v109.network.Network;
import org.openqa.selenium.devtools.v109.network.model.ConnectionType;

import java.time.Duration;
import java.util.Optional;

public class Exercise20_NetworkSpeed {
    public static void main(String[] args) throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/home/edwinchp/Documents/drivers/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.send(Network.emulateNetworkConditions(false, 3000, 20000, 3000, Optional.of(ConnectionType.ETHERNET)));

        long startTime = System.currentTimeMillis();

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://phptravels.com/demo/");

        long endTime = System.currentTimeMillis();

        System.out.println(endTime-startTime);

        driver.quit();
    }
}
