package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {
    private static WebDriver driver;
    private static String baseUrl = "https://demo.automationtesting.in/";

    public BaseTest() {
        setupDriver();
    }

    private void setupDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            new BaseTest();
        }
        return driver;
    }

    public static void tearDown() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void navigateTo(String endpoint) {
        getDriver().get(baseUrl + endpoint);
    }

    public static String getBaseUrl(){
        return baseUrl;
    }
}
