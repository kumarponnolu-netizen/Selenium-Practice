import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotExample extends BaseTest {
    @Test
    public void takeFullPageAndElementScreenshot() throws Exception {
        driver.get("https://the-internet.herokuapp.com/login");
        // Full page
        File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        FileUtils.copyFile(scr, new File("screenshots/fullpage_" + ts + ".png"));

        // Element-only
        WebElement logo = driver.findElement(By.cssSelector("div.example h2"));
        File el = logo.getScreenshotAs(OutputType.FILE);
        Files.createDirectories(new File("screenshots").toPath());
        FileUtils.copyFile(el, new File("screenshots/element_" + ts + ".png"));
    }
}
