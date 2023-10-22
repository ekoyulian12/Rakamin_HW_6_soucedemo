package stepdef;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class login {
    WebDriver driver;
    env env = new env();

    public login(){
        this.driver = webdriversetting.getDriver();
    }
    @Given("User on saucedemo login page")
    public void userInTheSauceDemoLoginPage(){
        driver.findElement(By.id("user-name")).isDisplayed();
    }

    @When("User input valid username")
    public void userInputValidUsername() {
        driver.findElement(By.id("user-name")).sendKeys(env.getValidUsername());
    }
    @When("User input invalid username")
    public void userInputInvalidUsername() {
        driver.findElement(By.id("user-name")).sendKeys(env.getInvalidUsername());
    }
    @And("User input valid password")
    public void userInputValidPassword() {
        driver.findElement(By.id("password")).sendKeys(env.getValidPassword());
    }
    @And("User click login button")
    public void userClickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }
    @Then("User success login")
    public void userSuccessLogin() throws InterruptedException {
        driver.findElement(By.xpath("//*[@class='shopping_cart_link']")).isDisplayed();
        Thread.sleep(3000);
    }

    @Then("User will see error invalid username password message")
    public void userWillSeeErrorInvalidUsernamePasswordMessage() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Epic sadface: Username and password do not match any user in this service']")).isDisplayed();
    }
    @After("@login")
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        webdriversetting.closeDriver();
    }
}
