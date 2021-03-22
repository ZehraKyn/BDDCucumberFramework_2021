package com.swaglabs.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BasePage {

    public static WebDriver driver;

    public static WebDriver initializeDriver;

    public static WebDriver initializeDriver(){
        // load the configuration.properties file with ConfigReader class
        ConfigReader.readProperties("./src/test/resources/configuration/config.properties");

        // choose the browser with ConfigReader class
        String browser = ConfigReader.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if (browser.equals("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        }else{
            throw new RuntimeException("Invalid browser name ");
        }


        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("url"));
        PageManager.initialize();
        return driver;
    }

    public static void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

}
