package testingCase;

import config.envTarget;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class testDemo extends envTarget {
    @Test
    public void main () {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div/div/div[2]/div/div[1]"))
        );
        // Interact with the element (for example, clicking it)
        driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div/div[1]")).click();
        wait.until(
          ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"item-0\"]"))
        ).click();
        driver.findElement(By.id("item-0"));
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='submit'][@type='button']"))
        );
        driver.findElement(By.id("userName")).sendKeys("Kevin");
        driver.findElement(By.id("userEmail")).sendKeys("kevin012@area.com");
        driver.findElement(By.xpath("//*[@id='currentAddress'][@class='form-control']")).sendKeys("Jl. Bpk kau no.12 RT.22/RW.05");
        driver.findElement(By.id("permanentAddress")).sendKeys("Jl. Bpk kau no.12 RT.22/RW.05");
        driver.findElement(By.xpath("//button[@id='submit'][@type='button']")).click();
        driver.quit();
    }

}
