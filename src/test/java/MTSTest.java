import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class MTSTest {
    private WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void openSite() {
        driver.get("https://www.mts.by/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PayPage payPage = new PayPage(driver);
        payPage.isCookie();
    }

    @Test
    public void payPageTest() {
        PayPage payPage = new PayPage(driver);
        assertAll(
                () -> assertTrue(payPage.tittle().replaceAll("\\r\\n|\\r|\\n|\\s+", " ")
                        .toLowerCase()
                        .equals("Онлайн пополнение без комиссии".toLowerCase())),
                () -> assertTrue(payPage.compareLogoPay("Visa")),
                () -> assertTrue(payPage.compareLogoPay("Verified By Visa")),
                () -> assertTrue(payPage.compareLogoPay("MasterCard")),
                () -> assertTrue(payPage.compareLogoPay("MasterCard Secure Code")),
                () -> assertTrue(payPage.compareLogoPay("Белкарт")),
                () -> assertEquals(5, payPage.qtLogoPay()),
                () -> assertEquals("Номер телефона", payPage
                        .openServices().selectService("Услуги связи")
                        .inputNumberCommunication()),
                () -> assertEquals("Сумма", payPage
                        .inputSumCommunication()),
                () -> assertEquals("Номер абонента", payPage
                        .openServices()
                        .selectService("Домашний интернет")
                        .inputNumberInternet()),
                () -> assertEquals("Сумма", payPage.inputSumInternet()),
                () -> assertEquals("Номер счета на 44", payPage
                        .openServices()
                        .selectService("Рассрочка")
                        .inputNumberCredit()),
                () -> assertEquals("Сумма", payPage.inputSumCredit()),
                () -> assertEquals("Номер счета на 2073", payPage
                        .openServices()
                        .selectService("Задолженность")
                        .inputNumberDebt()),
                () -> assertEquals("Сумма", payPage.inputSumDebt())
        );
    }

    @Test
    public void aboutServiceTest() {
        AboutServicePage payPage = new PayPage(driver).aboutService();
        assertAll(
                () -> assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                        driver.getCurrentUrl()),
                () -> assertTrue(payPage.displayedAbout())
        );

    }

    @Test
    public void formPayPageTest() throws InterruptedException {
        FormPayPage payPage = new PayPage(driver).communicationSubmit("Услуги связи",
                "297777777", "25");
        assertAll(
                () -> assertFalse(payPage.bepaid()),
                () -> assertTrue(payPage.summaHeader("25.00 BYN")),
                () -> assertTrue(payPage.summaButton("Оплатить 25.00 BYN")),
                () -> assertTrue(payPage.numPhone("Оплата: Услуги связи Номер:375297777777")),
                () -> assertTrue(payPage.numCard("Номер карты")),
                () -> assertTrue(payPage.numCVC("CVC")),
                () -> assertTrue(payPage.nameCard("Имя держателя (как на карте)")),
                () -> assertTrue(payPage.validityPeriod("Срок действия")),
                () -> assertTrue(payPage.compareLogoFormPay(
                        "assets/images/payment-icons/card-types/visa-system.svg")),
                () -> assertTrue(payPage.compareLogoFormPay(
                        "assets/images/payment-icons/card-types/mastercard-system.svg")),
                () -> assertTrue(payPage.compareLogoFormPay(
                        "assets/images/payment-icons/card-types/belkart-system.svg")),
                () -> assertTrue(payPage.compareLogoFormPay(
                        "assets/images/payment-icons/card-types/maestro-system.svg")),
                () -> assertTrue(payPage.compareLogoFormPay(
                        "assets/images/payment-icons/card-types/mir-system-ru.svg")),
                () -> assertEquals(5, payPage.qt())
        );
    }

    @AfterEach
    public void closeSite() {
        driver.quit();
    }
}
