package io.bestappd.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogin(){
        WebElement logIn = driver.findElement(By.linkText("Log In"));
        logIn.click();
    }

}
