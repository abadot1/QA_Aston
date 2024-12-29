package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        boolean isCookie = driver.findElements(By.className("show")).isEmpty();
        if (!isCookie) {
            WebElement agreeCookie = driver.findElement(By.id("cookie-agree"));
            agreeCookie.click();
        }



        driver.quit();
    }
}