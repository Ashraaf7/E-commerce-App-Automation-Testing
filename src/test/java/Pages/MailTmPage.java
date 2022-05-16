package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import step_definition.Hook;

public class MailTmPage
{
    public String emailAddressValue ()
    {
        WebElement emailAddressElement= Hook.driver.findElement(By.cssSelector("input[id=\"address\"]"));
        String emailAddressValue=emailAddressElement.getAttribute("value");
        return emailAddressValue;
    }
}
