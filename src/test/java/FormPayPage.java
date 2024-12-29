import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class FormPayPage {
    private WebDriver driver;

    private By sumHeader = By.xpath("//div[@class = 'pay-description__cost']/span");
    private By sumButton = By.xpath("//button[@class = 'colored disabled']");
    private By number = By.xpath("//div[@class = 'pay-description__text']/span");
    private By iframe = By.className("bepaid-iframe");
    private By numberCard = By.xpath("//label[@class = 'ng-tns-c46-1 ng-star-inserted']");
    private By numberCVC = By.xpath("//label[@class = 'ng-tns-c46-5 ng-star-inserted']");
    private By name = By.xpath("//label[@class = 'ng-tns-c46-3 ng-star-inserted']");
    private By logoForm = By.xpath("//div[@class = 'cards-brands ng-tns-c46-1']//img");

    public FormPayPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean bepaid() {
        return driver.findElements(iframe).isEmpty();
    }

    public String summaHeader() throws InterruptedException {
        driver.switchTo().frame(driver.findElement(iframe));
        Thread.sleep(5000);
        return driver.findElement(sumHeader).getText();
    }

    public String summaButton() throws InterruptedException {
        driver.switchTo().frame(driver.findElement(iframe));
        Thread.sleep(5000);
        return driver.findElement(sumButton).getText();
    }

    public String numPhone() throws InterruptedException {
        driver.switchTo().frame(driver.findElement(iframe));
        Thread.sleep(5000);
        return driver.findElement(number).getText();
    }

    public String numCard() throws InterruptedException {
        driver.switchTo().frame(driver.findElement(iframe));
        Thread.sleep(5000);
        return driver.findElement(numberCard).getText();
    }

    public String numCVC() throws InterruptedException {
        driver.switchTo().frame(driver.findElement(iframe));
        Thread.sleep(5000);
        return driver.findElement(numberCVC).getText();
    }

    public String nameCard() throws InterruptedException {
        driver.switchTo().frame(driver.findElement(iframe));
        Thread.sleep(5000);
        return driver.findElement(name).getText();
    }

    public boolean compareLogoFormPay(String expectedFormLogoPay) throws InterruptedException {
        driver.switchTo().frame(driver.findElement(iframe));
        Thread.sleep(5000);
        List<WebElement> logoFormPay = driver.findElements(logoForm);
        for (WebElement element : logoFormPay) {
            if (element.getDomAttribute("src").equals(expectedFormLogoPay)) {
                return true;
            }
        }
        return false;
    }
}
