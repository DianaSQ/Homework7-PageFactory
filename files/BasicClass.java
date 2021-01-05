package com.automation;

/*import org.junit.BeforeClass;*/
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.Config;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasicClass {

    protected static WebDriver chrome;
   private final Properties config = Config.loadProperties("test.properties");

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setup(@Optional("chrome") String browser) {
        if (browser.toLowerCase().equals("chrome")) {
            WebDriverManager
                    .chromedriver()
                    .version(config.getProperty("chromedriver.version"))
                    .setup();
            chrome = new ChromeDriver();
        } else if (browser.toLowerCase().equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            chrome = new FirefoxDriver();
        }
        chrome.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chrome.manage().window().maximize();
        chrome.get(config.getProperty("baseurl"));
    }
/*
    @BeforeClass(alwaysRun = true)
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\TOOLS\\chromedriver_win32\\chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.manage().window().maximize();
        chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }*/

}
