
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CalendarExample extends BaseTest {
    @Test
    public void handleCalender() throws Exception {
        driver.get("https://jqueryui.com/datepicker/");
        driver.switchTo().frame(0);
        driver.findElement(By.id("datepicker")).click();

        String expectedMonth = "September";
        String expectedYear = "2025";
        String expectedDay = "15";

        while (true) {
            String currentMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
            String currentYear = driver.findElement(By.className("ui-datepicker-year")).getText();

            if (currentMonth.equals(expectedMonth) && currentYear.equals(expectedYear)) {
                break;
            } else {
                // Click Next button
                driver.findElement(By.xpath("//a[@title='Next']")).click();
            }
        }

        // Select the day
        driver.findElement(By.xpath("//a[text()='" + expectedDay + "']")).click();

        Thread.sleep(2000);
        driver.quit();
    }
}
