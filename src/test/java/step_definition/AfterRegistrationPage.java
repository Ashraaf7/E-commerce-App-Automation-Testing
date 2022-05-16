package step_definition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AfterRegistrationPage
{
    public WebElement message ()
    {
        WebElement message= Hook.driver.findElement(By.cssSelector("div[class=\"result\"]"));
        return message;
    }
    public WebElement logout ()
    {
        WebElement logout = Hook.driver.findElement(By.cssSelector("a[class=\"ico-logout\"]"));
        return logout;
    }
}
