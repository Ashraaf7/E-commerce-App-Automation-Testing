package step_definition;

import Pages.AnyProductPage;
import Pages.CompareListPage;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class CompareList
{
    AnyProductPage anyProductPage=new AnyProductPage();
    CompareListPage compareListPage=new CompareListPage();
    SoftAssert productsAddedToCompareList=new SoftAssert();
    ArrayList<String> addedProductToCompareList= new ArrayList<>();
    ArrayList<String> actualProductInCompareList= new ArrayList<>();
    @And("user click on add to compare list")
    public void userClickOnAddToCompareList()
    {
        anyProductPage.addToCompareList().click();
        while (anyProductPage.loadingProgress().isDisplayed())
        {
            //wait until product added to compare list
        }
        while(anyProductPage.isAddedToCartSuccessNotification())
        {
            //wait until product added to compare list notification disappear
        }
        addedProductToCompareList.add(anyProductPage.productName().getText());
    }
    @Then("user should found the product added in the compare list")
    public void userShouldFoundTheProductAddedInTheCompareList()
    {
        anyProductPage.compareList().click();
        int numberOfItemsInCompareList=compareListPage.productName().size();
        for(int i=0;i<numberOfItemsInCompareList;i++)
        {
            actualProductInCompareList.add(compareListPage.productName().get(i).getText());
        }
        for(int i=0;i<numberOfItemsInCompareList;i++)
        {
            productsAddedToCompareList.assertTrue(actualProductInCompareList.contains(addedProductToCompareList.get(i)));
            productsAddedToCompareList.assertAll();
        }
    }
}
