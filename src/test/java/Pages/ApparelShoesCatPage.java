package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import step_definition.Hook;

import java.util.List;

public class ApparelShoesCatPage
{
    public WebElement redColorFilter ()
    {
        WebElement redColorFilter= Hook.driver.findElement(By.xpath("//label[text()=\" Red \"]//preceding-sibling::input"));
        return redColorFilter;
    }
    public List<WebElement> productList ()
    {
        List <WebElement> productTitles = Hook.driver.findElements(By.cssSelector("h2[class=\"product-title\"] a"));
        return productTitles;
    }
    public String displayFlag ()
    {
        String displayFlag= Hook.driver.findElement(By.xpath("//div[@class=\"ajax-products-busy\"]")).getAttribute("style");
        return displayFlag;
    }
}
