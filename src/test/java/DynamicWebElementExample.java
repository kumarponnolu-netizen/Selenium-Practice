import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DynamicWebElementExample extends BaseTest{
    @Test
    public void findDynamicWebElement() throws Exception{
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/buttons");
        WebElement dynamicBtn=driver.findElement(By.xpath("//button[contains(text(),'Click Me')]"));
        dynamicBtn.click();
        System.out.println("Dynamic button clicked successfully");
        driver.quit();
    }
}