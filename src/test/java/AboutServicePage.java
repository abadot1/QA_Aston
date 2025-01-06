import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutServicePage {
    private WebDriver driver;

    private By bodyAboutService = By.className("main");

    public AboutServicePage (WebDriver driver){
        this.driver = driver;
    }

    public boolean displayedAbout () {
        return driver.findElement(bodyAboutService).isDisplayed();
    }


}
