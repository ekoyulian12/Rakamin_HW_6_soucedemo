package stepdef;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class inventory {
    WebDriver driver;
    env env = new env();

    public inventory(){
        this.driver = webdriversetting.getDriver();
    }

    @Given("User on inventory page")
    public void userOnInventoryPage() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys(env.getValidUsername());
        driver.findElement(By.id("password")).sendKeys(env.getValidPassword());
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath("//*[starts-with(@id,\"add-to-cart\")]")).isDisplayed();
        Thread.sleep(1000);
    }

    @When("User click add to cart button")
    public void userClickAddToCartButton() {
        driver.findElement(By.xpath("//*[@name=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")).click();
    }

    @Then("Item cart will increase")
    public void itemCartWillIncrease() {
        String itemCart = driver.findElement(By.xpath("//*[@class='shopping_cart_badge']")).getText();
        Assert.assertEquals("1", itemCart);
        webdriversetting.closeDriver();
    }

    @After("@inventory")
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        webdriversetting.closeDriver();
    }
}
