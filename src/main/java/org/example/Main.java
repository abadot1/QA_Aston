package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.mts.by/");
        boolean isCookie = driver.findElements(By.className("show")).isEmpty();
        if (!isCookie){
            WebElement agreeCookie = driver.findElement(By.id("cookie-agree"));
            agreeCookie.click();
        }

        WebElement select = driver.findElement(By.className("select__header"));
        select.click();

        WebElement selectOption = driver.findElement(By.xpath("//li/p[text() = 'Услуги связи']"));
        selectOption.click();

        WebElement phone = driver.findElement(By.id("connection-phone"));
        phone.click();
        phone.sendKeys("297777777");

        WebElement sum = driver.findElement(By.id("connection-sum"));
        sum.click();
        sum.sendKeys("10");

        WebElement buttonNext = driver.findElement(By.xpath("//button[text() = 'Продолжить']"));
        buttonNext.click();

        boolean isIframe = driver.findElements(By.className("bepaid-iframe")).isEmpty();
        System.out.println(!isIframe);
        driver.quit();
    }
}