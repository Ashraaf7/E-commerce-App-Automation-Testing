package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import step_definition.Hook;

import java.util.List;

public class ShoppingCartPage
{
    public List<WebElement> productName ()
    {
        List <WebElement> productName = Hook.driver.findElements(By.xpath("//div[@class=\"table-wrapper\"]//tbody/tr//td[@class=\"product\"]/a"));
        return productName;
    }
    public WebElement termsOfService ()
    {
        WebElement termsOfService = Hook.driver.findElement(By.xpath("//input[@id=\"termsofservice\"]"));
        return termsOfService;
    }
    public WebElement checkoutButton ()
    {
        WebElement checkoutButton = Hook.driver.findElement(By.xpath("//button[@id=\"checkout\"]"));
        return checkoutButton;
    }
    public Select country ()
    {
        WebElement countryList= Hook.driver.findElement(By.xpath("//select[@id=\"BillingNewAddress_CountryId\"]"));
        Select country = new Select(countryList);
        return country;
    }
    public WebElement city ()
    {
        WebElement city = Hook.driver.findElement(By.xpath("//input[@id=\"BillingNewAddress_City\"]"));
        return city;
    }
    public WebElement address ()
    {
        WebElement address = Hook.driver.findElement(By.xpath("//input[@id=\"BillingNewAddress_Address1\"]"));
        return address;
    }
    public WebElement zipCode ()
    {
        WebElement zipCode = Hook.driver.findElement(By.xpath("//input[@id=\"BillingNewAddress_ZipPostalCode\"]"));
        return zipCode;
    }
    public WebElement phoneNumber ()
    {
        WebElement phoneNumber = Hook.driver.findElement(By.xpath("//input[@id=\"BillingNewAddress_PhoneNumber\"]"));
        return phoneNumber;
    }
    public WebElement firstContinueButton ()
    {
        WebElement firstContinueButton = Hook.driver.findElement(By.xpath("//button[@onclick=\"Billing.save()\"]"));
        return firstContinueButton;
    }
    public WebElement secondContinueButton ()
    {
        WebElement secondContinueButton = Hook.driver.findElement(By.xpath("//button[@onclick=\"ShippingMethod.save()\"]"));
        return secondContinueButton;
    }
    public WebElement thirdContinueButton ()
    {
        WebElement thirdContinueButton = Hook.driver.findElement(By.xpath("//button[@onclick=\"PaymentMethod.save()\"]"));
        return thirdContinueButton;
    }
    public WebElement fourthContinueButton ()
    {
        WebElement fourthContinueButton = Hook.driver.findElement(By.xpath("//button[@onclick=\"PaymentInfo.save()\"]"));
        return fourthContinueButton;
    }
    public WebElement confirmOrderButton ()
    {
        WebElement confirmOrderButton = Hook.driver.findElement(By.xpath("//button[@onclick=\"ConfirmOrder.save()\"]"));
        return confirmOrderButton;
    }
    public WebElement confirmedOrderTextElement ()
    {
        WebElement confirmedOrderTextElement = Hook.driver.findElement(By.xpath("//div[@class=\"page-body checkout-data\"]/div/div/strong"));
        return confirmedOrderTextElement;
    }
}
