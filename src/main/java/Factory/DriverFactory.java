package Factory;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.util.concurrent.TimeUnit;
import java.util.UUID;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
    public WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
    public WebDriver init_driver(String browser) {
        System.out.println("browser value is: " + browser);
        if (tlDriver.get() == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-popup-blocking");
                    options.addArguments("--disable-notifications");
                    options.addArguments("--blink-settings=imagesEnabled=false"); // optional
                    options.addArguments("--remote-allow-origins=*");
                    options.addArguments("--disable-dev-shm-usage");
                    options.addArguments("--no-sandbox");

                    // unique profile dir per run to avoid "user-data-dir already in use" error
                    String userDataDir = "/tmp/chrome-profile-" + UUID.randomUUID();
                    options.addArguments("--user-data-dir=" + userDataDir);

                    // Optional: enable this if running on CI/CD without display
                    options.addArguments("--headless=new");

                    tlDriver.set(new ChromeDriver(options));
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    tlDriver.set(new FirefoxDriver());
                    break;

                case "safari":
                    tlDriver.set(new SafariDriver());
                    break;

                default:
                    throw new IllegalArgumentException("Invalid browser name: " + browser);
            }
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        return getDriver();
    }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}
