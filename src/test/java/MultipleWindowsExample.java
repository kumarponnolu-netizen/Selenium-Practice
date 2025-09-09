import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindowsExample extends BaseTest {
    @Test
    public void switchWindows() {
        driver.get("https://the-internet.herokuapp.com/windows");
        String original = driver.getWindowHandle();
        driver.findElement(By.linkText("Click Here")).click();
        // Switch to the new window
        wait.until(d -> driver.getWindowHandles().size() > 1);
        Set<String> handles = driver.getWindowHandles();
        for (String h : handles) {
            if (!h.equals(original)) {
                driver.switchTo().window(h);
                break;
            }
        }

        wait.until(ExpectedConditions.titleContains("New Window"));
        driver.close();
        driver.switchTo().window(original);
    }
}