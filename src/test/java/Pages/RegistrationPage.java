package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import step_definition.Hook;

public class RegistrationPage
{
    public WebElement genderMale ()
    {
        WebElement genderMale= Hook.driver.findElement(By.cssSelector("input[value=\"M\"]"));
        return genderMale;
    }
    public WebElement genderFemale ()
    {
        WebElement genderFemale= Hook.driver.findElement(By.cssSelector("input[value=\"F\"]"));
        return genderFemale;
    }
    public WebElement firstName ()
    {
        WebElement firstName= Hook.driver.findElement(By.cssSelector("input[id=\"FirstName\"]"));
        return firstName;
    }
    public WebElement lastName ()
    {
        WebElement lastName= Hook.driver.findElement(By.cssSelector("input[id=\"LastName\"]"));
        return lastName;
    }
    public Select DateOfBirthDay ()
    {
        WebElement DateOfBirthDay= Hook.driver.findElement(By.cssSelector("select[name=\"DateOfBirthDay\"]"));
        Select Day = new Select(DateOfBirthDay);
        return Day;
    }
    public Select DateOfBirthMonth ()
    {
        WebElement DateOfBirthMonth= Hook.driver.findElement(By.cssSelector("select[name=\"DateOfBirthMonth\"]"));
        Select Month = new Select(DateOfBirthMonth);
        return Month;
    }
    public Select DateOfBirthYear ()
    {
        WebElement DateOfBirthYear= Hook.driver.findElement(By.cssSelector("select[name=\"DateOfBirthYear\"]"));
        Select Year = new Select(DateOfBirthYear);
        return Year;
    }
    public WebElement Email ()
    {
        WebElement Email= Hook.driver.findElement(By.cssSelector("input[id=\"Email\"]"));
        return Email;
    }
    public WebElement Company ()
    {
        WebElement Company= Hook.driver.findElement(By.cssSelector("input[id=\"Company\"]"));
        return Company;
    }
    public WebElement NewsletterState ()
    {
        WebElement NewsletterState= Hook.driver.findElement(By.cssSelector("input[id=\"Newsletter\"]"));
        return NewsletterState;
    }
    public WebElement PasswordField ()
    {
        WebElement PasswordField= Hook.driver.findElement(By.cssSelector("input[id=\"Password\"]"));
        return PasswordField;
    }
    public WebElement ConfirmPasswordField ()
    {
        WebElement ConfirmPasswordField= Hook.driver.findElement(By.cssSelector("input[id=\"ConfirmPassword\"]"));
        return ConfirmPasswordField;
    }
    public WebElement register_button ()
    {
        WebElement register_button= Hook.driver.findElement(By.cssSelector("button[id=\"register-button\"]"));
        return register_button;
    }
}
