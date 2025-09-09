import org.testng.annotations.Test;

public class BaseTestTest extends BaseTest {

    @Test
    public void openGoogleTest() {
        driver.get("https://www.google.com");
        System.out.println("Page title: " + driver.getTitle());
    }
}
