package step_definition;

import Pages.HomePage;
import Pages.MailTmPage;
import Pages.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

public class Registration {
    HomePage homePage = new HomePage();
    RegistrationPage registerPage=new RegistrationPage();
    AfterRegistrationPage afterRegistrationPage=new AfterRegistrationPage();
    SoftAssert verifyRegistration=new SoftAssert();
    MailTmPage mailTmPage=new MailTmPage();
    @Given("user has a valid email")
    public void user_has_a_valid_email()
    {
        if(Hook.validEmail.isEmpty())
        {
            Hook.driver.navigate().to("https://mail.tm/en/");
            do
            {
                Hook.validEmail = mailTmPage.emailAddressValue();
            }while(!(Hook.validEmail.contains("@")));
            System.out.println("Email: "+ Hook.validEmail);
            System.out.println("Password: "+ Hook.validPassword);
        }
    }
    @When("user clicks on Register link in upper right")
    public void user_clicks_on_Register_link_in_upper_right()
    {
            homePage.register().click();
    }
    @And("^user select gender \"(.*?)\"")
    public void user_select_gender(String Gender)
    {
            if (Gender.equalsIgnoreCase("male")) {
                registerPage.genderMale().click();
            }
            if (Gender.equalsIgnoreCase("female")) {
                registerPage.genderFemale().click();
            }
    }
    @And("^user enter first name \"(.*?)\"")
    public void user_enter_first_name(String firstname)
    {
            registerPage.firstName().sendKeys(firstname);
    }
    @And("^user enter last name \"(.*?)\"")
    public void user_enter_last_name(String lastname)
    {
            registerPage.lastName().sendKeys(lastname);
    }
    @And ("^user enter his or her date of birth \"(.*?)\"")
    public void user_enter_his_her_date_of_birth(String date)
    {
            String[] dateFields = date.split("/");
            registerPage.DateOfBirthDay().selectByValue(dateFields[0]);
            registerPage.DateOfBirthMonth().selectByValue(dateFields[1]);
            registerPage.DateOfBirthYear().selectByValue(dateFields[2]);
    }
    @And ("user enter his or her email")
    public void user_enter_his_her_email() throws Exception
    {
            if (Hook.validEmail.isEmpty()) {
                throw new Exception("Please Provide a Valid Email");
            } else {
                registerPage.Email().sendKeys(Hook.validEmail);
            }
    }
    @And ("^user enter his or her company \"(.*?)\"")
    public void user_enter_his_or_her_company(String company)
    {
            registerPage.Company().sendKeys(company);
    }
    @And ("^user select Newsletter option \"(.*?)\"")
    public void user_select_Newsletter_option(String state)
    {
            if (state.equalsIgnoreCase("true")) {
                while (!(registerPage.NewsletterState().isSelected()))
                    registerPage.NewsletterState().click();
                while ((registerPage.NewsletterState().isSelected()))
                    registerPage.NewsletterState().click();
                while (!(registerPage.NewsletterState().isSelected()))
                    registerPage.NewsletterState().click();
            } else {
                while ((registerPage.NewsletterState().isSelected()))
                    registerPage.NewsletterState().click();
                while (!(registerPage.NewsletterState().isSelected()))
                    registerPage.NewsletterState().click();
                while ((registerPage.NewsletterState().isSelected()))
                    registerPage.NewsletterState().click();
            }
    }
    @And ("user fill password and confirm password fields with \\(Hook.validPassword) value")
    public void user_fill_password_and_confirm_password_fields()
    {
            registerPage.PasswordField().sendKeys(Hook.validPassword);
            registerPage.ConfirmPasswordField().sendKeys(Hook.validPassword);
    }
    @And("user click on register button")
    public void userClickOnRegisterButton()
    {
        registerPage.register_button().click();
    }
    @Then("^user should see \"(.*?)\" message")
    public void userShouldSeeMessage(String message)
    {
            verifyRegistration.assertEquals(afterRegistrationPage.message().getText(), message, "Registration Process Failed_1");
    }
}
