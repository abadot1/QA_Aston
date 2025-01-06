import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class FormPayPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By sumHeader = By.xpath("//div[@class = 'pay-description__cost']/span");
    private By sumButton = By.xpath("//button[@class = 'colored disabled']");
    private By number = By.xpath("//div[@class = 'pay-description__text']/span");
    private By iframe = By.className("bepaid-iframe");
    private By numberCard = By.xpath("//label[@class = 'ng-tns-c46-1 ng-star-inserted']");
    private By numberCVC = By.xpath("//label[@class = 'ng-tns-c46-5 ng-star-inserted']");
    private By name = By.xpath("//label[@class = 'ng-tns-c46-3 ng-star-inserted']");
    private By logoForm = By.xpath("//div[@class = 'cards-brands ng-tns-c46-1']//img");
    private By validPeriod = By.xpath("//label[@class = 'ng-tns-c46-4 ng-star-inserted']");
    private By bodyFrame = By.className("app-wrapper");

    public FormPayPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.switchTo().frame(driver.findElement(iframe));
    }

    public boolean bepaid() {
        return driver.findElement(bodyFrame).isDisplayed();
    }

    public boolean summaHeader(String expSummHeader) {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(sumHeader, expSummHeader));
    }

    public boolean summaButton(String expSummButton) {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(sumButton, expSummButton));
    }

    public boolean numPhone(String expNumPhone) {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(number, expNumPhone));
    }

    public boolean numCard(String expNumCard) {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(numberCard, expNumCard));
    }

    public boolean numCVC(String expNumCVC) {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(numberCVC, expNumCVC));
    }

    public boolean nameCard(String expNameCard) {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(name, expNameCard));
    }

    public boolean validityPeriod(String expValidPeriod) {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(validPeriod, expValidPeriod));
    }

    public boolean compareLogoFormPay(String expectedFormLogoPay) {
        List<WebElement> logoFormPay = driver.findElements(logoForm);
        for (WebElement element : logoFormPay) {
            if (element.getDomAttribute("src").equals(expectedFormLogoPay)) {
                return element.isDisplayed();
            }
        }
        return false;
    }

    public int qt (){
        List<WebElement> logoFormPay = driver.findElements(logoForm);
        return logoFormPay.size();
    }
}
