import org.openqa.selenium.WebElement;

import java.util.List;

public class CompareLogo {
    public static boolean compareLogoPay(String expectedLogoPay, List<WebElement> actualLogoPay) {
        for (WebElement element : actualLogoPay) {
            if (element.getDomAttribute("alt").equals(expectedLogoPay)) {
                return true;
            }
        }
        return false;
    }
}
