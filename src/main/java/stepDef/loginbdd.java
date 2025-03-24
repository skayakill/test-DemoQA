package stepDef;

import config.envTarget;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class loginbdd extends envTarget {
    @Given("user is on login page")
    public void user_is_on_login_page() {
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li[3]/a"))
        );
    }

    @When("user click button register")
    public void user_click_button_register() {
        driver.findElement(By.xpath("//ul/li[3]/a")).click();
    }

    @Then("user input name")
    public void user_input_name() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='base'][contains(text(), 'Create New Customer Account')]"))
        );
        driver.findElement(By.id("firstname")).sendKeys("veil");
        driver.findElement(By.name("lastname")).sendKeys("armstrong");
    }

    @And("user fill email and password")
    public void user_fill_email_and_password() {
        driver.findElement(By.name("email")).sendKeys("veilarms@areamail.com");
        Random rand = new Random();
        int userRand = rand.nextInt(1000);
        driver.findElement(By.name("password")).sendKeys("user" + userRand);
        driver.findElement(By.id("password")).sendKeys("1234567");
    }

    @And("user input confirmation password")
    public void user_input_confirmation_password() {
        driver.findElement(By.name("password_confirmation")).sendKeys("1234567");
    }

    @When("user input click button register")
    public void user_input_click_button_register() {
        driver.findElement(By.xpath("//*[@type='submit'][@class='action submit primary']"));
    }

    @Then("user register successfully")
    public void user_register_successfully() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div[2]/a"))
        );
        driver.findElement(By.xpath("//header/div[2]/a")).click();
    }

    @When("user go to homepage")
    public void user_go_to_homepage() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='action more button'][contains(text(),'Shop New Yoga')]"))
        );
        driver.findElement(By.xpath("//span[@class='base'][contains(text(),'Home Page')]"));

    }

    @When("user go to Shop Yoga")
    public void user_go_to_shop_yoga() {
        driver.findElement(By.xpath("//span[@class='action more button'][contains(text(),'Shop New Yoga')]")).click();
    }

    @Then("user will show detail products")
    public void user_will_show_detail_products() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"page-title-heading\"]"))
        );
        driver.quit();
    }

}
