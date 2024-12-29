import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormPayPage {
    private WebDriver driver;

    private By bepaidClass = By.className("bepaid-iframe");
    private By sumHeader = By.cssSelector("//div[@class = 'pay-description__cost']/span[1]");
    private By iframe = By.className("bepaid-iframe");

    public FormPayPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean bepaid(){
        return  driver.findElements(bepaidClass).isEmpty();
    }

    public String summaHeader(){
        driver.switchTo().frame(driver.findElement(iframe));
        return driver.findElement(sumHeader).getText();
//        JavascriptExecutor jsEx = (JavascriptExecutor) driver;
//        String s = (String) jsEx.executeScript("return arguments[0].value", driver.findElement(sumHeader));
//        return s;
    }
}
