import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDropExample extends BaseTest {
    @Test
    public void dragAndDroponeLocationToAnotherLocation() throws Exception {
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);

        // Perform drag and drop using clickAndHold + moveToElement + release
        actions.clickAndHold(source)
                .moveToElement(target)
                .release()
                .build()
                .perform();
        Thread.sleep(2000);
        // Verify text changed after drop
        String dropText = target.getText();
        if (dropText.equals("Dropped!")) {
            System.out.println("Drag and Drop successful!");
        } else {
            System.out.println("Drag and Drop failed!");
        }
        // Close browser
        driver.quit();
    }
}
