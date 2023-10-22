package stepdef;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class logout {
    WebDriver driver;
    env env = new env();
    public logout() { this.driver = webdriversetting.getDriver(); }

    @Given("User on dashboard page")
    public void userOnDashboardPage() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys(env.getValidUsername());
        driver.findElement(By.id("password")).sendKeys(env.getValidPassword());
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath("//*[starts-with(@id,\"add-to-cart\")]")).isDisplayed();
        Thread.sleep(1000);
    }

    @When("User click burger menu")
    public void userClickBurgerMenu() {
        driver.findElement(By.xpath("//*[@id='react-burger-menu-btn']")).click();
    }

    @And("User click Logout button")
    public void userClickLogoutButton() {
        driver.findElement(By.xpath("//*[@id='logout_sidebar_link']")).click();
    }

    @Then("User success logout")
    public void userSuccessLogout() {
        driver.findElement(By.xpath("//*[@id='login_credentials']")).click();
    }

    @After("@logout")
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        webdriversetting.closeDriver();
    }

}
