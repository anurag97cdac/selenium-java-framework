package com.anurag.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    
    
    public static WebDriver getDriver(String browser){

        WebDriver driver = null;

        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();

                if(System.getProperty("headless") != null && 
                System.getProperty("headless").equals("true")){
                    options.addArguments("--headless=new");
                }
                driver = new ChromeDriver(options);
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;
        
            default:
                throw new RuntimeException("Browser not supported");
        }
        driver.manage().window().maximize();
        return driver;
    }
}
