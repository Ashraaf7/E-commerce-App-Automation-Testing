package step_definition;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MailTmPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Login
{
    HomePage homePage=new HomePage();
    LoginPage loginPage=new LoginPage();

    @And("user fill his or her email")
    public void userFillHisOrHerEmail()
    {
        if(Hook.isLogin==false) {
            loginPage.email().sendKeys(Hook.validEmail);
        }
    }
    @And("user fill his or her password")
    public void userFillHisOrHerPassword()
    {
        if(Hook.isLogin==false) {
            loginPage.password().sendKeys(Hook.validPassword);
        }
    }
    @And("user click on log in button")
    public void userClickOnLogInButton()
    {
        if(Hook.isLogin==false) {
            loginPage.loginButton().click();
        }
    }
    @And("user should to be able to logged in")
    public void userShouldToBeAbleToLoggedIn()
    {
        loginPage.loginButton().click();
    }
}
