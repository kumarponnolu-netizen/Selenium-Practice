import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScrollToElementExample extends BaseTest {
    @Test
    public void scrollToFindElement() throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/");
        WebElement element = driver.findElement(By.xpath("//h2[text()='Selenium Level Sponsors']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(3000);
        System.out.println("Scrolled to Element Text: " + element.getText());
        driver.quit();
    }
}