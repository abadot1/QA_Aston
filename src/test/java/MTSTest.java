import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MTSTest {
    private WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void openSite() {
        driver.get("https://www.mts.by/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PayPage payPage = new PayPage(driver);
        PayPage cookie = payPage.isCookie();
    }

    @Test
    public void titleTest() {
        assertTrue(new PayPage(driver).tittle().replaceAll("\\r\\n|\\r|\\n|\\s+", " ")
                .toLowerCase()
                .equals("Онлайн пополнение без комиссии".toLowerCase()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"})
    public void logoPayTest(String logo) {
        assertTrue(new PayPage(driver).compareLogoPay(logo));
    }

    @Test
    public void aboutServiceTest() {
        new PayPage(driver).aboutService();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/",
                driver.getCurrentUrl());
    }

    @Test
    public void communicationServiceTest() {
        assertTrue(!new PayPage(driver)
                .communicationSubmit("Услуги связи", "297777777", "25")
                .bepaid());
    }

    @Test
    public void placeholderNumberCommunicationTest() {
        PayPage payPage = PageFactory.initElements(driver, PayPage.class);
        payPage.openServices();
        payPage.selectService("Услуги связи");
        assertEquals("Номер телефона", payPage.inputNumberCommunication());
    }

    @Test
    public void placeholderSumCommunicationTest() {
        PayPage payPage = PageFactory.initElements(driver, PayPage.class);
        payPage.openServices();
        payPage.selectService("Услуги связи");
        assertEquals("Сумма", payPage.inputSumCommunication());
    }

    @Test
    public void placeholderNumberInternetTest() {
        PayPage payPage = PageFactory.initElements(driver, PayPage.class);
        payPage.openServices();
        payPage.selectService("Домашний интернет");
        assertEquals("Номер абонента", payPage.inputNumberInternet());
    }

    @Test
    public void placeholderSumInternetTest() {
        PayPage payPage = PageFactory.initElements(driver, PayPage.class);
        payPage.openServices();
        payPage.selectService("Домашний интернет");
        assertEquals("Сумма", payPage.inputSumInternet());
    }

    @Test
    public void placeholderNumberCreditTest() {
        PayPage payPage = PageFactory.initElements(driver, PayPage.class);
        payPage.openServices();
        payPage.selectService("Рассрочка");
        assertEquals("Номер счета на 44", payPage.inputNumberCredit());
    }

    @Test
    public void placeholderSumCreditTest() {
        PayPage payPage = PageFactory.initElements(driver, PayPage.class);
        payPage.openServices();
        payPage.selectService("Рассрочка");
        assertEquals("Сумма", payPage.inputSumCredit());
    }

    @Test
    public void placeholderNumberDebtTest() {
        PayPage payPage = PageFactory.initElements(driver, PayPage.class);
        payPage.openServices();
        payPage.selectService("Задолженность");
        assertEquals("Номер счета на 2073", payPage.inputNumberDebt());
    }

    @Test
    public void placeholderSumDebtTest() {
        PayPage payPage = PageFactory.initElements(driver, PayPage.class);
        payPage.openServices();
        payPage.selectService("Задолженность");
        assertEquals("Сумма", payPage.inputSumDebt());
    }

    @Test
    public void sumHeaderTest() throws InterruptedException {
        assertEquals("25.00 BYN", new PayPage(driver)
                .communicationSubmit("Услуги связи", "297777777", "25")
                .summaHeader());
    }

    @Test
    public void sumButtonTest() throws InterruptedException {
        assertEquals("Оплатить 25.00 BYN", new PayPage(driver)
                .communicationSubmit("Услуги связи", "297777777", "25")
                .summaButton());
    }

    @Test
    public void numberFormPayTest() throws InterruptedException {
        assertEquals("Оплата: Услуги связи Номер:375297777777", new PayPage(driver)
                .communicationSubmit("Услуги связи", "297777777", "25")
                .numPhone());
    }

    @Test
    public void numberCardFormPayTest() throws InterruptedException {
        assertEquals("Номер карты", new PayPage(driver)
                .communicationSubmit("Услуги связи", "297777777", "25")
                .numCard());
    }

    @Test
    public void numberCVCFormPayTest() throws InterruptedException {
        assertEquals("CVC", new PayPage(driver)
                .communicationSubmit("Услуги связи", "297777777", "25")
                .numCVC());
    }

    @Test
    public void nameFormPayTest() throws InterruptedException {
        assertEquals("Имя держателя (как на карте)", new PayPage(driver)
                .communicationSubmit("Услуги связи", "297777777", "25")
                .nameCard());
    }

    @ParameterizedTest
    @ValueSource(strings = {"assets/images/payment-icons/card-types/visa-system.svg",
            "assets/images/payment-icons/card-types/mastercard-system.svg",
            "assets/images/payment-icons/card-types/belkart-system.svg",
            "assets/images/payment-icons/card-types/maestro-system.svg",
            "assets/images/payment-icons/card-types/mir-system-ru.svg"})
    public void logoFormPayTest(String logoPay) throws InterruptedException {
        assertTrue(new PayPage(driver)
                .communicationSubmit("Услуги связи", "297777777", "25")
                .compareLogoFormPay(logoPay));
    }


    @AfterEach
    public void closeSite() {
        driver.quit();
    }
}
