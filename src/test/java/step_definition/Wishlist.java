package step_definition;

import Pages.AnyProductPage;
import Pages.WishlistPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class Wishlist
{
    AnyProductPage anyProductPage=new AnyProductPage();
    WishlistPage wishlistPage=new WishlistPage();
    SoftAssert productsAddedToWishlist=new SoftAssert();
    ArrayList<String> addedProductToWishlist= new ArrayList<>();
    ArrayList<String> actualProductInWishlist= new ArrayList<>();
    @And("user click on add to wishlist")
    public void userClickOnAddToWishlist()
    {
        anyProductPage.addToWishlistButton().click();
        while (anyProductPage.loadingProgress().isDisplayed())
        {
            //wait until product added to wishlist
        }
        while(anyProductPage.isAddedToCartSuccessNotification())
        {
            //wait until product added to wishlist notification disappear
        }
        addedProductToWishlist.add(anyProductPage.productName().getText());
    }

    @Then("user should found the product added to wishlist in the wishlist")
    public void userShouldFoundTheProductAddedToWishlistInTheWishlist()
    {
        anyProductPage.wishlist().click();
        int numberOfItemsInWishlist=wishlistPage.productName().size();
        for(int i=0;i<numberOfItemsInWishlist;i++)
        {
            actualProductInWishlist.add(wishlistPage.productName().get(i).getText());
        }
        for(int i=0;i<numberOfItemsInWishlist;i++)
        {
            productsAddedToWishlist.assertTrue(actualProductInWishlist.contains(addedProductToWishlist.get(i)));
            productsAddedToWishlist.assertAll();
        }

    }
}
