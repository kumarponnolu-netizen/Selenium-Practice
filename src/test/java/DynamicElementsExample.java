import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class DynamicElementsExample extends BaseTest {
    @Test
    public void dynamicLoading() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.cssSelector("#start button")).click();
        // Wait for element to become visible
        WebElement hello = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        assert hello.getText().contains("Hello World!");
    }

    @Test
    public void retryOnStaleElement() {
        driver.get("https://the-internet.herokuapp.com/tables");
        Wait<WebDriver> fluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(StaleElementReferenceException.class);

        WebElement cell = fluent.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver d) {
                return d.findElement(By.cssSelector("#table1 tr:nth-child(2) td:nth-child(3)"));
            }
        });

        System.out.println("Cell text: " + cell.getText());
    }
}