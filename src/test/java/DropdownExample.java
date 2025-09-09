import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;

public class DropdownExample extends BaseTest {
    @Test
    public void selectFromNativeSelect() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText("Option 2");
    }

    @Test
    public void selectFromCustomDropdown() {
        driver.get("https://demoqa.com/select-menu");
        // Click to open custom dropdown
        WebElement dd = wait.until(ExpectedConditions.elementToBeClickable(By.id("withOptGroup")));
        dd.click();
        // Type-to-filter then press Enter (common pattern in custom components)
        WebElement input = driver.switchTo().activeElement();
        input.sendKeys("Group 1, option 2");
        input.sendKeys(Keys.ENTER);
    }
}
