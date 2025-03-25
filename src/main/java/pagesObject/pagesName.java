package pagesObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class pagesName {
    WebDriver driver;
    public pagesName(WebDriver driver) { this.driver = driver; }
    By firstnameField = By.id("firstname");
    By lastnameField = By.name("lastname");
    public void inputData(String firstname, String lastname) {
    driver.findElement(firstnameField).sendKeys("veil");
    driver.findElement(lastnameField).sendKeys("armstrong");

    }
}
