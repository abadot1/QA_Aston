import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PayPage {
    private By titlePay = By.xpath("//div[@class='pay__wrapper']/h2");
    private By cookie = By.className("show");
    private By cookieAgree = By.id("cookie-agree");
    private By logo = By.xpath("//div[@class='pay__partners']/ul/li/img");
    private By elemAboutService = By.linkText("Подробнее о сервисе");
    private By buttonServicesClass = By.className("select");
    private By servicesClass = By.className("select__option");
    private By number = By.id("connection-phone");
    private By summa = By.id("connection-sum");
    private By butSumbit = By.xpath("//button[text() = 'Продолжить']");
    private By numberInternet = By.id("internet-phone");
    private By summaInternet = By.id("internet-sum");
    private By numberCredit = By.id("score-instalment");
    private By summaCredit = By.id("instalment-sum");
    private By numberDebt = By.id("score-arrears");
    private By summaDebt = By.id("arrears-sum");

    private WebDriver driver;

    public PayPage(WebDriver driver) {
        this.driver = driver;
    }

    public PayPage isCookie() {
        if (!driver.findElements(cookie).isEmpty()) {
            driver.findElement(cookieAgree).click();
        }
        return this;
    }

    public String tittle() {
        return driver.findElement(titlePay).getText();
    }

    public boolean compareLogoPay(String expectedLogoPay) {
        List<WebElement> logoPay = driver.findElements(logo);
        for (WebElement element : logoPay) {
            if (element.getDomAttribute("alt").equals(expectedLogoPay)) {
                return true;
            }
        }
        return false;
    }

    public AboutServicePage aboutService() {
        WebElement aboutService = driver.findElement(elemAboutService);
        aboutService.click();
        return new AboutServicePage(driver);
    }

    public PayPage openServices() {
        WebElement buttonServices = driver.findElement(buttonServicesClass);
        buttonServices.click();
        return this;
    }

    public PayPage selectService(String nameService) {
        List<WebElement> services = driver.findElements(servicesClass);
        for (WebElement elem : services) {
            if (elem.getText().equals(nameService)) {
                elem.click();
            }
        }
        return this;
    }

    public PayPage inputNumber(String num) {
        driver.findElement(number).sendKeys(num);
        return this;
    }

    public PayPage inputSum(String sum) {
        driver.findElement(summa).sendKeys(sum);
        return this;
    }

    public FormPayPage buttonSubmit() {
        driver.findElement(butSumbit).submit();
        return new FormPayPage(driver);
    }

    public FormPayPage communicationSubmit(String nameService, String num, String sum) {
        openServices();
        selectService(nameService);
        inputNumber(num);
        inputSum(sum);
        return buttonSubmit();
    }

    public String inputNumberCommunication() {
        return driver.findElement(number).getDomAttribute("placeholder");
    }

    public String inputSumCommunication() {
        return driver.findElement(summa).getDomAttribute("placeholder");
    }

    public String inputNumberInternet() {
        return driver.findElement(numberInternet).getDomAttribute("placeholder");
    }

    public String inputSumInternet() {
        return driver.findElement(summaInternet).getDomAttribute("placeholder");
    }

    public String inputNumberCredit() {
        return driver.findElement(numberCredit).getDomAttribute("placeholder");
    }

    public String inputSumCredit() {
        return driver.findElement(summaCredit).getDomAttribute("placeholder");
    }

    public String inputNumberDebt() {
        return driver.findElement(numberDebt).getDomAttribute("placeholder");
    }

    public String inputSumDebt() {
        return driver.findElement(summaDebt).getDomAttribute("placeholder");
    }
}


