import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class DynamicCalendar extends BaseTest {
    @Test
    public  void handleDynamicCalender() throws Exception {
        // Example: Select 25th December 2025
        String dateToSelect = "25";
        String monthToSelect = "December";
        String yearToSelect = "2025";

        driver.get("https://www.globalsqa.com/demo-site/datepicker/");

        // Switch to iframe
        driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));

        // Open the date picker
        WebElement dateInput = driver.findElement(By.id("datepicker"));
        dateInput.click();

        // Wait for calendar to render
        Thread.sleep(1000);

        // Select a date, e.g., 15th
        List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td/a"));
        for (WebElement date : dates) {
            if (date.getText().equals("15")) {
                date.click();
                break;
            }
        }

        // Switch back from iframe
        driver.switchTo().defaultContent();

        Thread.sleep(2000);
        driver.quit();
    }
}
