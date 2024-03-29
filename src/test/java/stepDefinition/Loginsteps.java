package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Commonfunctions;

import java.util.concurrent.TimeUnit;

public class Loginsteps {
    WebDriver driver;
@Before
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    }

    @Given("i am on the home page")
    public void i_am_on_the_home_page() throws InterruptedException {
        driver.get("https://www.next.co.uk/secure/account/Login");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[contains(text(),'Accept All Cookies')]")).click();

    }
    @When("i enter {string} and {string}")
    public void i_enter_and(String uid, String passwd) {
        driver.findElement(By.name("EmailOrAccountNumber")).sendKeys(uid);
        driver.findElement(By.xpath("//input[@name='Password']")).sendKeys(passwd);
          }
    @When("i click on login button")
    public void i_click_on_login_button() {
        driver.findElement(By.xpath("//input[@name='SignInNow']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Continue Shopping')]")).click();
         }
    @Then("i redirected to home page")
    public void i_redirected_to_home_page() {
        String actTitle= driver.getTitle();
        System.out.println(actTitle);
       Assert.assertEquals("Next Official Site: Online Fashion, Kids Clothes & Homeware",actTitle);
    }
    @After
    public void closeBrowser(){
    driver.quit();
    }


}
