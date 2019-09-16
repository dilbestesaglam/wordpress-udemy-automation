package io.bestappd.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String userName) {
        WebElement usernameOrEmail = driver.findElement(By.id("usernameOrEmail"));
        usernameOrEmail.clear();
        usernameOrEmail.sendKeys (userName);
    }

    public void clickContinueButton(){
        WebElement continueButton = driver.findElement(By.xpath("//button[text()='Continue']"));
        continueButton.click();
    }

    public void setPassword (String password) {
        WebElement passwordArea = driver.findElement(By.id("password"));
        passwordArea.clear();
        passwordArea.sendKeys (password);
    }

    public void clickLonInButton(){

        WebElement logInButton = driver.findElement(By.xpath("//button[text()='Log In']"));
        logInButton.click();
    }

    public String getFailText() {
        WebElement userDoesNotExist = driver.findElement(By.xpath("//*[@id=\"primary\"]/div/main/div/div[1]/div/form/div[1]/div[1]/div[1]/span"));
        String text = userDoesNotExist.getText();
        return text;
    }
}


