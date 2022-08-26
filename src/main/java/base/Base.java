package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base {
    public WebDriver driver;
    public Properties prop;
    public static Logger log = LogManager.getLogger(Base.class.getName());

    public SoftAssert sa = new SoftAssert();
    public WebDriver initDriver() throws IOException {
        //invoke driver based on browser to be used
        prop = new Properties();
        FileInputStream fis = new FileInputStream("./resources/data.properties");
        prop.load(fis);

        log.info("Successfully loaded data.properties file.");

        String browserName = prop.getProperty("browser");
        switch (browserName) {
            case "chrome" -> {
                //load chrome driver
                System.setProperty("webdriver.chrome.driver", "./resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                log.info("Using Chrome Browser.");
            }
            case "firefox" -> {
                //load firefox driver
                System.setProperty("webdriver.gecko.driver", "./resources/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                log.info("Using Chrome Browser.");
            }
            case "edge" -> {
                //load edge driver
                System.setProperty("webdriver.edge.driver", "./resources/drivers/msedgedriver.exe");
                driver = new EdgeDriver();
                log.info("Using Chrome Browser.");
            }
            default -> {
                log.error("Invalid browser!");
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        log.info("Successfully loaded " + browserName + " driver.");

        return driver;
    }
}
