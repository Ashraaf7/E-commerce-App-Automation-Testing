package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import step_definition.Hook;

import java.util.List;

public class SearchResultPage
{
    public List <WebElement> productList ()
    {
        List <WebElement> productTitles = Hook.driver.findElements(By.cssSelector("h2[class=\"product-title\"] a"));
        return productTitles;
    }
}
