package org.selenium_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v109.network.Network;
import org.openqa.selenium.devtools.v109.network.model.ConnectionType;

import java.net.URI;
import java.util.Optional;
import java.util.function.Predicate;

public class Exercise21_BasicAuth {
    public static void main(String[] args) throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/home/edwinchp/Documents/drivers/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        /*
            We have to resort to this approach due to the pop-up displayed in httpbin.org is not a web pop-up.
            For that, first we assign the value of a lambda expression into a Predicate object.
         */
        Predicate<URI> uriPredicate = uri -> uri.getHost().contains("httpbin.org");

        /*
            We pass the Predicate to the register() method which is asking for it as parameter.
         */
        ((HasAuthentication) driver).register(uriPredicate, () -> UsernameAndPassword.of("foo", "bar").get());

        /*
            If logged in successfully, it should print a json showing the credentials.
            You won't see any pop-up, it will just log in.
            If not logged correctly, nothing is printed due to there is nothing in page when asking for credentials.
         */
        driver.get("http://httpbin.org/basic-auth/foo/bar");
        System.out.println(driver.findElement(By.tagName("html")).getText());

        driver.quit();
    }
}
