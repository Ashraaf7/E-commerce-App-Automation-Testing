package step_definition;

import Pages.LoginPage;
import Pages.PasswordRecoveryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;

public class ForgotPassword
{
    LoginPage loginPage=new LoginPage();
    PasswordRecoveryPage passwordRecoveryPage=new PasswordRecoveryPage();
    SoftAssert verifyRecoveryMessage=new SoftAssert();
    @And("user click on forgot password?")
    public void userClickOnForgotPassword()
    {
        loginPage.forgotPassword().click();
    }

    @And("user fill email with valid email")
    public void userFillEmailWithValidEmail()
    {
        passwordRecoveryPage.Email().sendKeys(Hook.validEmail);
    }

    @And("user click on Recover button")
    public void userClickOnRecoverButton()
    {
        passwordRecoveryPage.RecoverButton().click();
    }

    @Then("user should see message {string}at the top")
    public void userShouldSeeMessageAtTheTop(String message)
    {
        verifyRecoveryMessage.assertEquals(passwordRecoveryPage.message().getText(),message,"Wrong Recovery Message 01");
        verifyRecoveryMessage.assertTrue(passwordRecoveryPage.message().isDisplayed(),"Wrong Recovery Message 02");
        verifyRecoveryMessage.assertAll();
    }
}
