import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class AlertsExample extends BaseTest {
    @Test
    public void handleAlerts() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // Simple alert
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Alert a1 = wait.until(ExpectedConditions.alertIsPresent());
        a1.accept();
        // Confirm
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Alert a2 = wait.until(ExpectedConditions.alertIsPresent());
        a2.dismiss();
        // Prompt
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Alert a3 = wait.until(ExpectedConditions.alertIsPresent());
        a3.sendKeys("Hello!");
        a3.accept();
    }
}
