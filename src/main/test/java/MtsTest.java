import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MtsTest {
    WebDriver driver = new ChromeDriver();


    @BeforeEach
    public void openSite() {
        driver.get("https://www.mts.by/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Boolean isCookie = driver.findElements(By.className("show")).isEmpty();
        if (!isCookie) {
            WebElement agreeCookie = driver.findElement(By.id("cookie-agree"));
            agreeCookie.click();
        }
    }

    @Test
    public void titleTest() {
        WebElement tittle = driver.findElement(By.xpath("//div[@class='pay__wrapper']/h2"));
        assertEquals("Онлайн пополнение без комиссии".toLowerCase(), tittle.getText().replaceAll
                ("\\r\\n|\\r|\\n|\\s+", " ").toLowerCase());
    }

    public boolean compareLogoPay(String expectedLogoPay, List<WebElement> actualLogoPay) {
        for (WebElement element : actualLogoPay) {
            if (element.getDomAttribute("alt").equals(expectedLogoPay)) {
                return true;
            }
        }
        return false;
    }

    @ParameterizedTest
    @ValueSource(strings = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"})
    public void logoPayTest(String logo) {
        List<WebElement> logoPay = driver.findElements(By.xpath("//div[@class='pay__partners']/ul/li/img"));
        assertEquals(true, compareLogoPay(logo, logoPay));
    }

    @Test
    public void aboutServiceTest() {
        WebElement aboutService = driver.findElement(By.linkText("Подробнее о сервисе"));
        aboutService.click();

        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
    }

    @Test
    public void formTest() {
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

        assertTrue(!driver.findElements(By.className("bepaid-iframe")).isEmpty());
    }

    @AfterEach
    public void closeSite() {
        driver.quit();
    }
}
