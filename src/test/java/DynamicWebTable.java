import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class DynamicWebTable extends BaseTest {
    @Test
    public void handleWebTable() throws Exception {
        driver.get("https://demo.guru99.com/test/web-table-element.php");
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
        System.out.println("Row count: " + rows.size());
        for (int i = 1; i <= rows.size(); i++) {
            List<WebElement> cols = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[" + i + "]/td"));
            for (int j = 1; j <= cols.size(); j++) {
                String cell = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[" + i + "]/td[" + j + "]")).getText();
                System.out.print(cell + " | ");
            }
            System.out.println();
        }
        driver.quit();
    }
}
