package testingCase;

import config.envTarget;
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
        driver.findElement(By.id("firstname")).sendKeys("veil");
        driver.findElement(By.name("lastname")).sendKeys("armstrong");
        driver.findElement(By.name("email")).sendKeys("veilarms@areamail.com");
        Random rand = new Random();
        int userRand = rand.nextInt(1000);
        driver.findElement(By.name("password")).sendKeys("user" + userRand);
        driver.findElement(By.id("password")).sendKeys("1234567");
        driver.findElement(By.name("password_confirmation")).sendKeys("1234567");
        driver.findElement(By.xpath("//*[@type='submit'][@class='action submit primary']"));
        wait.until(
                ExpectedConditions.visibilityOfElementLocated()
        )
        driver.quit();
    }
}
