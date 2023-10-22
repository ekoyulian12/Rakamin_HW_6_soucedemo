package stepdef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class webdriversetting {
    private static WebDriver driver;

    private webdriversetting(){}

    public static WebDriver getDriver(){
        env env = new env();
        if(driver == null){
            final String dir = System.getProperty("user.dir");
            System.setProperty("webdriver.chrome.driver",dir+"/driver/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
            driver.get(env.getUrl());
        }

        return driver;
    }

    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
