package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import step_definition.Hook;

import java.util.List;

public class HomePage
{
    public WebElement register ()
    {
        WebElement register_hyperlink= Hook.driver.findElement(By.cssSelector("a[class=\"ico-register\"]"));
        return register_hyperlink;
    }
    public WebElement login ()
    {
        WebElement login= Hook.driver.findElement(By.cssSelector("a[class=\"ico-login\"]"));
        return login;
    }
    public WebElement searchField ()
    {
        WebElement searchField= Hook.driver.findElement(By.cssSelector("input[id=\"small-searchterms\"]"));
        return searchField;
    }
    public WebElement searchButton ()
    {
        WebElement searchButton= Hook.driver.findElement(By.cssSelector("button[class=\"button-1 search-box-button\"]"));
        return searchButton;
    }
    public Select switchCurrencies()
    {
        WebElement switchCurrencies= Hook.driver.findElement(By.cssSelector("select[id=\"customerCurrency\"]"));
        Select Currencies = new Select(switchCurrencies);
        return Currencies;
    }
    public List<WebElement> productPrices ()
    {
        List <WebElement> productPrices = Hook.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));
        return productPrices;
    }
    public List<WebElement> categories ()
    {
        List <WebElement> categories = Hook.driver.findElements(By.xpath("//div[@class=\"header-menu\"]//child::ul[@class=\"top-menu notmobile\"]/li/a"));
        return categories;
    }
    public List<WebElement> categoriesHaveSub ()
    {
        List <WebElement> categoriesHaveSub = Hook.driver.findElements(By.xpath("//div[@class=\"header-menu\"]//child::ul[@class=\"top-menu notmobile\"]//li //a //following-sibling::div //preceding-sibling::a"));
        return categoriesHaveSub;
    }
    public List<WebElement> allSubCategories ()
    {
        List <WebElement> allSubCategories = Hook.driver.findElements(By.xpath("//div[@class=\"header-menu\"]//child::ul[@class=\"top-menu notmobile\"]//li//ul//li//a"));
        return allSubCategories;
    }
    public WebElement apparelCategory ()
    {
        WebElement apparelCategory= Hook.driver.findElement(By.xpath("(//div[@class=\"header-menu\"] //child::ul[@class=\"top-menu notmobile\"]//li //a //following-sibling::div //preceding-sibling::a)[3]"));
        return apparelCategory;
    }
    public WebElement shoesSubCategory ()
    {
        WebElement shoesSubCategory= Hook.driver.findElement(By.xpath("((//div[@class=\"header-menu\"] //child::ul[@class=\"top-menu notmobile\"]//li //a //following-sibling::div //preceding-sibling::a) [3] //following-sibling::ul //child::li) [1]//a"));
        return shoesSubCategory;
    }
}
