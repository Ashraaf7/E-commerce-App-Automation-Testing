package step_definition;

import Pages.ApparelShoesCatPage;
import Pages.HomePage;
import Pages.RedShoesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class FilterWColor
{
    HomePage homePage=new HomePage();
    ApparelShoesCatPage apparelShoesCatPage=new ApparelShoesCatPage();
    RedShoesPage redShoesPage=new RedShoesPage();
    SoftAssert relevantProduct= new SoftAssert();
    @Given("user select category that have a color option filter")
    public void userSelectCategoryThatHaveAColorOptionFilter()
    {
        Actions action = new Actions(Hook.driver);
        //Move mouse to Apparel category
        action.moveToElement(homePage.apparelCategory()).perform();
        //Select shoes sub category
        homePage.shoesSubCategory().click();
    }
    @And("user select color filter red")
    public void userSelectColorFilterRed()
    {
        while(!(apparelShoesCatPage.redColorFilter().isSelected()))
        {
            apparelShoesCatPage.redColorFilter().click();
        }
        while(apparelShoesCatPage.displayFlag().equalsIgnoreCase("display: block;")) //wait until page loading
        {
        }
    }
    @Then("user should see relative products to the selected color")
    public void userShouldSeeRelativeProductsToTheSelectedColor()
    {
        boolean isColorFounded=false;
        int numberOfItems =apparelShoesCatPage.productList().size();
        relevantProduct.assertTrue(numberOfItems>0,"No Products Available For This Filter");
        relevantProduct.assertAll();
        apparelShoesCatPage.productList().get(0).click(); //click on first item in page
        int numberOfColors= redShoesPage.availableColors().size();
        //start verifying that this product has the selected color
        for(int i =0;i<numberOfColors;i++)
        {
            if(redShoesPage.availableColors().get(i).getAttribute("title").equalsIgnoreCase("Red"));
            {
                isColorFounded=true;
                break;
            }
        }
        relevantProduct.assertTrue(isColorFounded,"This Product Didn't Have A Red Color Variant");
        relevantProduct.assertAll();
    }
}
