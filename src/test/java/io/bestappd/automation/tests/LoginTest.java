package io.bestappd.automation.tests;

import io.bestappd.automation.pages.HomePage;
import io.bestappd.automation.pages.LoginPage;
import io.bestappd.automation.utils.DriverFactory;
import io.bestappd.automation.utils.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    public static void main(String[] args) throws InterruptedException {
        testLoginWithValidUserName();
        testLoginWithInValidUserName();
    }

    public static void testLoginWithValidUserName() throws InterruptedException {
        DriverFactory driverFactory = new DriverFactory();
        WebDriver driver = driverFactory.getDriver();
        driver.get("https://wordpress.com");

        //Test 1
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("dilbeste_saglam@hotmail.com");
        loginPage.clickContinueButton();
        Thread.sleep(3000);
        loginPage.setPassword("Life_1996");
        loginPage.clickLonInButton();

        WebElement profileIcon = driver.findElement(By.xpath("//img[@alt='Profilim']"));
        boolean displayed = profileIcon.isDisplayed();

        if (displayed) {
            System.out.println("Test is Pass");
        } else {
            System.out.println("Test is Fail");
        }
        driver.close();
    }

    public static void testLoginWithInValidUserName() throws InterruptedException {
        DriverFactory driverFactory = new DriverFactory();
        WebDriver driver = driverFactory.getDriver();
        driver.get("https://wordpress.com");

        //Test 2
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("tolga.tuna@hotmail.com");
        loginPage.clickContinueButton();

        Thread.sleep(3000);

        String text = loginPage.getFailText();

        if (text.equalsIgnoreCase("User Does Not Exist.")) {
            System.out.println("Test is Pass");
        } else {
            System.out.println("Test is fail");
        }

        driver.close();


    }

}
