package com.kodilla.testing2.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverConfig {
    public final static String CHROME = "CHROME_DRIVER";

    public static WebDriver getDriver(final String driver) {
        System.setProperty("webdriver.chrome.driver", "/home/piotr/Documents/Development/Projects/Kodilla/chromedriver");

        if (driver.equals(CHROME)) {
            return new ChromeDriver();
        }
        return null;
    }
}
