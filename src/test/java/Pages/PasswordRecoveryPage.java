package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import step_definition.Hook;

public class PasswordRecoveryPage
{
    public WebElement Email ()
    {
        WebElement Email= Hook.driver.findElement(By.cssSelector("input[id=\"Email\"]"));
        return Email;
    }
    public WebElement RecoverButton()
    {
        WebElement RecoverButton= Hook.driver.findElement(By.cssSelector("button[class=\"button-1 password-recovery-button\"]"));
        return RecoverButton;
    }
    public WebElement message()
    {
        WebElement message= Hook.driver.findElement(By.cssSelector("p[class=\"content\"]"));
        return message;
    }
}
