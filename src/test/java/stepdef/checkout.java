package stepdef;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class checkout {

    WebDriver driver;

    public checkout(){
        this.driver = webdriversetting.getDriver();
    }
    @Given("User move to checkout your information page")
    public void userMoveToCheckoutYourInformationPage() {
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).isDisplayed();
    }

    @When("User input first name")
    public void userInputFirstName() {
        driver.findElement(By.id("first-name")).sendKeys("Eko");
    }

    @And("User input last name")
    public void userInputLastName() {
        driver.findElement(By.id("last-name")).sendKeys("Yulianto");
    }

    @And("User input postal code")
    public void userInputPostalCode() {
        driver.findElement(By.id("postal-code")).sendKeys("10340");
    }

    @And("User click continue button")
    public void userClickContinueButton() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("User on checkout overview page")
    public void userOnCheckoutOverviewPage() {
        driver.findElement(By.id("finish")).isDisplayed();
    }

    @After("@checkout")
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        webdriversetting.closeDriver();
    }
}