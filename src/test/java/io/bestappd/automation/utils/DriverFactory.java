package io.bestappd.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory implements Constants {

    private WebDriver driver;

    private String browser;

    private ReadProperties configProperties = new ReadProperties (CONFIG_PROPERTIES_PATH);

    public DriverFactory() {
        browser = configProperties.getValue(GET_BROWSER_KEY);
        if (browser.equals(CHROME)) {
            System.setProperty(CHROME_WEB_DRIVER, CHROME_DRIVER_PATH);
        } else if (browser.equals(SAFARI)) {
            System.setProperty(SAFARI_WEB_DRIVER, SAFARI_DRIVER_PATH);
        } else {
            System.out.println("Yanlıs driver set ettin ama ben chromeda acıcam");
            System.setProperty(CHROME_WEB_DRIVER, CHROME_DRIVER_PATH);
        }

        configureWebDriver();
    }

    private void configureWebDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
