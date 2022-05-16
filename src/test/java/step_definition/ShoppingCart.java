package step_definition;

import Pages.AnyCategoryPage;
import Pages.AnyProductPage;
import Pages.ShoppingCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Random;

public class ShoppingCart
{
    AnyCategoryPage anyCategoryPage=new AnyCategoryPage();
    AnyProductPage anyProductPage=new AnyProductPage();
    ShoppingCartPage shoppingCartPage=new ShoppingCartPage();
    Random random = new Random();
    int x=5;
    SoftAssert productsAddedToCart=new SoftAssert();
    SelectRandomCategory selectRandomCategory=new SelectRandomCategory();
    ArrayList <String> addedProductToCart= new ArrayList<>();
    ArrayList <String> productsInCart= new ArrayList<>();
    @Then("user click on random product")
    public void userClickOnRandomProduct()
    {
        int numberOFAvailableProducts=anyCategoryPage.productListInStock().size();
        int randomNumber = random.nextInt(numberOFAvailableProducts);
        anyCategoryPage.productListInStock().get(randomNumber).click();
    }
    @And("user check if the product have attributes")
    public void userCheckIfTheProductHaveAttributes()
    {
        while((anyProductPage.isProductHasAttributes())||(anyProductPage.isProductGiftCard())||(!(anyProductPage.isAddToCartButton()))||(!(anyProductPage.availability()))||(addedProductToCart.contains(anyProductPage.productName().getText())))
        {
            selectRandomCategory.userSelectRandomCategory();
            selectRandomCategory.userShouldRedirectedToThePageOfTheSelectedCategory();
            this.userClickOnRandomProduct();
        }
    }
    @And("user click on add to cart")
    public void userClickOnAddToCart()
    {
        anyProductPage.addToCartButton().click();
        while (anyProductPage.loadingProgress().isDisplayed())
        {
            //wait until product added to cart
        }
        while(anyProductPage.isAddedToCartSuccessNotification())
        {
            //wait until product added to cart notification disappear
        }
        addedProductToCart.add(anyProductPage.productName().getText());
    }
    @Then("user should found the product added to cart in shopping cart")
    public void userShouldFoundTheProductAddedToCartInShoppingCart()
    {
        while (anyProductPage.loadingProgress().isDisplayed())
        {
            //wait until product added to cart
        }
        while(anyProductPage.isAddedToCartSuccessNotification())
        {
            //wait until product added to cart notification disappear
        }
        anyProductPage.shoppingCart().click();
        while (anyProductPage.loadingProgress().isDisplayed())
        {
            //wait until product added to cart
        }
        int actualNumberOfProductInCart=shoppingCartPage.productName().size();
        for(int i=0;i<actualNumberOfProductInCart;i++) {
            productsInCart.add(shoppingCartPage.productName().get(i).getText());
        }
        for(int i=0;i<actualNumberOfProductInCart;i++)
        {
            productsAddedToCart.assertTrue(productsInCart.contains(addedProductToCart.get(i)));
            productsAddedToCart.assertAll();
        }
    }
}
