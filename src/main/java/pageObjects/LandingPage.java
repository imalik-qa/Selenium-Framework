package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {
    public WebDriver driver;

    //@FindBy(css = ".pull-right ul li:nth-child(4)")
    By loginLink = By.cssSelector(".pull-right ul li:nth-child(4)");

    By navBar = By.className("navbar-right");
    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLoginLink() {
        return driver.findElement(loginLink);
    }

    public WebElement getnavBar() {
        return driver.findElement(navBar);
    }
}
