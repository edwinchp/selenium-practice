package org.selenium_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v109.network.Network;
import org.openqa.selenium.devtools.v109.network.model.Response;
import org.openqa.selenium.devtools.v85.fetch.Fetch;

import java.time.Duration;
import java.util.Optional;

public class Exercise17_MockAPIResponses {
    public static void main(String[] args) throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/Users/edwin.chi/Downloads/chrome/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
        devTools.addListener(Fetch.requestPaused(), request -> {
            if(request.getRequest().getUrl().contains("shetty")){
                String newURL = request.getRequest().getUrl().replace("=shetty", "=BadGuy");
                devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(newURL), Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty()));
            }else {
                devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.empty(), Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty()));
            }
        });


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://rahulshettyacademy.com/angularAppDemo/");
        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
    }
}
