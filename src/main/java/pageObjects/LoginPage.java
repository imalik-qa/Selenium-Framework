package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By loginLink = By.linkText("Login");
    By userEmailField = By.id("user_email");
    By pswdField = By.id("user_password");
    By submitBtn = By.cssSelector("[value='Log In']");
    By invalidAlert = By.xpath("//div[contains(text(),'Invalid email or password.')]");

    public WebElement getUserEmailField(){
        return driver.findElement(userEmailField);
    }

    public WebElement getpswdField(){
        return driver.findElement(pswdField);
    }

    public WebElement getSubmitBtn() {
        return driver.findElement(submitBtn);
    }

    public WebElement getLoginLink() { return driver.findElement(loginLink); }

    public WebElement getInvalidAlert() { return driver.findElement(invalidAlert); }
}
