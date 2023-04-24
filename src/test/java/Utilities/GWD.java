package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GWD {
    public static WebDriver driver;
    protected static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static ThreadLocal<String> threadBrowserName = new ThreadLocal<>();

    public static WebDriver getDriver() {
        // Extent türkce rapor için kondu
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        Logger.getLogger("").setLevel(Level.SEVERE);
        System.setProperty(org.slf4j.simple.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");

        if (threadBrowserName.get() == null) // -> paralel çalışmayan yani XML den parametreyle çalıştırılmayan testler
            threadBrowserName.set("chrome");                                                            // için yapıldı

        if (threadDriver.get() == null) {

            String browserName = threadBrowserName.get();
            switch (browserName) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    threadDriver.set(new ChromeDriver());
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    threadDriver.set(new FirefoxDriver());
                    break;

                case "safari":
                    WebDriverManager.safaridriver().setup();
                    threadDriver.set(new SafariDriver());
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    threadDriver.set(new EdgeDriver());
                    break;

            }
        }

        return threadDriver.get();
    }

    public static void quitDriver() {
        Bekle();

        if (threadDriver.get() != null)
            threadDriver.get().quit();

        WebDriver driver = threadDriver.get();
        driver = null;

        threadDriver.set(driver);
    }

    public static void Bekle(){
        try {
            Thread.sleep(2500);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

}