package step_definition;

import Pages.HomePage;
import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Hook
{
    static public WebDriver driver =null;
    static public String validEmail="";
    static public String validPassword="momo*123456";
    static public boolean isThisEmailRegistered=false;
    static public boolean isLogin=false;
    AfterRegistrationPage afterRegistrationPage=new AfterRegistrationPage();
    SoftAssert verifyRegistration=new SoftAssert();
    HomePage homePage=new HomePage();
    @BeforeAll
    public static void user_open_chrome_browser()
    {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromePath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @After //(order=1)
    public static void user_close_the_driver(Scenario scenario)
    {
        if(scenario.isFailed())
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            TakesScreenshot ts= (TakesScreenshot) driver;
            byte [] src=ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src,"image/png","screenshot");
        }
    }
    @AfterAll //(order = 0)
    public static void r()
    {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
    //common steps between features
    @Given("user navigate to home page")
    public void user_navigate_to_home_page()
    {
        if(!(Hook.driver.getCurrentUrl().equalsIgnoreCase("https://demo.nopcommerce.com/")))
        {
            Hook.driver.navigate().to("https://demo.nopcommerce.com/");
        }
    }
    @And("user should login successfully and see log out appears at the top right")
    public void userShouldLoginSuccessfullyAndSeeLogOutAppearsAtTheTopRight()
    {
        verifyRegistration.assertTrue(afterRegistrationPage.logout().isDisplayed(), "Registration Process Failed_2");
        verifyRegistration.assertAll();
        Hook.isThisEmailRegistered=true;
        Hook.isLogin=true;
    }
    @Given("user had a valid registered account")
    public void userHadAValidRegisteredAccount()
    {
        Assert.assertTrue(((!(Hook.validEmail.isEmpty()))&&(Hook.isThisEmailRegistered)),"There's no valid account registered yet");
    }
    @And("user click on log in")
    public void userClickOnLogIn()
    {
        if(Hook.isLogin==false) {
            homePage.login().click();
        }
    }
    @Then("user click on log out button")
    public void userClickOnLogOutButton()
    {
        if(Hook.isLogin==true) {
            afterRegistrationPage.logout().click();
            verifyRegistration.assertTrue(homePage.login().isDisplayed(), "Logout Process Failed");
            verifyRegistration.assertAll();
            Hook.isLogin = false;
        }
    }
}
