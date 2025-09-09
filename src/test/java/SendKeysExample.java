import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class SendKeysExample extends BaseTest {
    @Test
    public void fillTextBoxes() {
        driver.get("https://the-internet.herokuapp.com/login");
        WebElement username = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("username")));
        username.clear();
        username.sendKeys("tomsmith");
        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys("SuperSecretPassword!");
        password.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".flash.success")));
    }
}