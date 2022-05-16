package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import step_definition.Hook;

import java.util.concurrent.TimeUnit;


public class AnyProductPage
{
    public boolean isAddToCartButton()
    {
        boolean isAddToCartButton=false;
        Hook.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try {
            Hook.driver.findElement(By.xpath("//button[@class=\"button-1 add-to-cart-button\"]"));
            isAddToCartButton=true;
        }catch (NoSuchElementException e)
        {
            isAddToCartButton=false;
        }
        Hook.driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        return isAddToCartButton;
    }
    public WebElement addToCartButton()
    {
        WebElement addToCartButton= Hook.driver.findElement(By.xpath("//button[@class=\"button-1 add-to-cart-button\"]"));
        return addToCartButton;
    }
    public boolean isAddedToCartSuccessNotification()
    {
        boolean isAddedToCartSuccessNotification=false;
        Hook.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try {
            Hook.driver.findElement(By.xpath("//div[@class=\"bar-notification success\"]"));
            isAddedToCartSuccessNotification=true;
        }
        catch (NoSuchElementException e)
        {
            isAddedToCartSuccessNotification=false;
        }
        Hook.driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        return isAddedToCartSuccessNotification;
    }
    public WebElement loadingProgress()
    {
        WebElement loadingProgress= Hook.driver.findElement(By.xpath("//div[@class=\"ajax-loading-block-window\"]"));
        return loadingProgress;
    }
    public boolean isProductHasAttributes()
    {
        boolean isProductHasAttributes=false;
        Hook.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try {
            Hook.driver.findElement(By.xpath("//div[contains(@class,'attributes')]"));
            isProductHasAttributes=true;
        }
        catch (NoSuchElementException e)
        {
            isProductHasAttributes=false;
        }
        Hook.driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        return isProductHasAttributes;
    }
    public boolean isProductGiftCard()
    {
        boolean isProductGiftCard=false;
        Hook.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try {
            Hook.driver.findElement(By.xpath("//div[@class=\"giftcard\"]"));
            isProductGiftCard=true;
        }
        catch (NoSuchElementException e)
        {
            isProductGiftCard=false;
        }
        Hook.driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        return isProductGiftCard;
    }
    public WebElement productName()
    {
        WebElement productName= Hook.driver.findElement(By.xpath("//div[@class=\"product-name\"]/h1"));
        return productName;
    }
    public WebElement shoppingCart()
    {
        WebElement shoppingCart= Hook.driver.findElement(By.xpath("//a[@class=\"ico-cart\"]"));
        return shoppingCart;
    }
    public boolean availability()
    {
        boolean availability=false;
        Hook.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try {
            availability= Hook.driver.findElement(By.xpath("//div[@class=\"availability\"]//following-sibling::span[@class=\"value\"]")).getText().equalsIgnoreCase("In stock");
        }
        catch (NoSuchElementException e)
        {
            availability=false;
        }
        Hook.driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        return availability;
    }
    public WebElement addToWishlistButton()
    {
        WebElement addToWishlistButton= Hook.driver.findElement(By.xpath("//div[@class=\"add-to-wishlist\"]/button"));
        return addToWishlistButton;
    }
    public WebElement wishlist()
    {
        WebElement wishlist= Hook.driver.findElement(By.xpath("//a[@href=\"/wishlist\" and @class=\"ico-wishlist\"]"));
        return wishlist;
    }
    public WebElement addToCompareList()
    {
        WebElement addToCompareList= Hook.driver.findElement(By.xpath("//div[@class=\"compare-products\"]/button"));
        return addToCompareList;
    }
    public WebElement compareList()
    {
        WebElement compareList = Hook.driver.findElement(By.xpath("//a[@href=\"/compareproducts\"]"));
        return compareList;
    }
}
