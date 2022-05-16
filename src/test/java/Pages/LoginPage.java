package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import step_definition.Hook;

public class LoginPage
{
    public WebElement email ()
    {
        WebElement email= Hook.driver.findElement(By.cssSelector("input[class=\"email\"]"));
        return email;
    }
    public WebElement password ()
    {
        WebElement password= Hook.driver.findElement(By.cssSelector("input[class=\"password\"]"));
        return password;
    }
    public WebElement loginButton ()
    {
        WebElement loginButton= Hook.driver.findElement(By.cssSelector("button[class=\"button-1 login-button\"]"));
        return loginButton;
    }
    public WebElement forgotPassword ()
    {
        WebElement forgotPassword= Hook.driver.findElement(By.cssSelector("a[href=\"/passwordrecovery\"]"));
        return forgotPassword;
    }
}
