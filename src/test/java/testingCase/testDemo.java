package testingCase;

import config.envTarget;
import pagesObject.pagesName;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class testDemo extends envTarget {
    @Test
    public void main () {
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li[3]/a"))
        );
        driver.findElement(By.xpath("//ul/li[3]/a")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='base'][contains(text(), 'Create New Customer Account')]"))
        );
        pagesName inputName =new pagesName(driver);
        inputName.inputData("veil", "armstrong");
        driver.findElement(By.name("email")).sendKeys("veilarms@areamail.com");
        Random rand = new Random();
        int userRand = rand.nextInt(1000);
        driver.findElement(By.name("password")).sendKeys("user" + userRand);
        driver.findElement(By.id("password")).sendKeys("1234567");
        driver.findElement(By.name("password_confirmation")).sendKeys("1234567");
        driver.findElement(By.xpath("//*[@type='submit'][@class='action submit primary']"));
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div[2]/a"))
        );
        driver.findElement(By.xpath("//header/div[2]/a")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='action more button'][contains(text(),'Shop New Yoga')]"))
        );
        driver.findElement(By.xpath("//span[@class='base'][contains(text(),'Home Page')]"));
        driver.findElement(By.xpath("//span[@class='action more button'][contains(text(),'Shop New Yoga')]")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"page-title-heading\"]"))
        );
        driver.quit();
    }
}
