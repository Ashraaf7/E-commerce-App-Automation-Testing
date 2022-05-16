package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import step_definition.Hook;

import java.util.List;

public class RedShoesPage
{
    public List<WebElement> availableColors()
    {
        List <WebElement> availableColors = Hook.driver.findElements(By.xpath("//span[@class=\"attribute-square-container\"]"));
        return availableColors;
    }
}
