package step_definition;

import Pages.AnyCategoryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class DifferentTags
{
    AnyCategoryPage anyCategoryPage=new AnyCategoryPage();
    Random random = new Random();
    SoftAssert tagPage= new SoftAssert();
    int randomNumber;
    @Given("user select random tag")
    public void userSelectRandomTag()
    {
        int numberOfAvailableTags = anyCategoryPage.allAvailableTags().size();
        randomNumber=random.nextInt(numberOfAvailableTags);
        anyCategoryPage.allAvailableTags().get(randomNumber).click();
    }
    @Then("user should see relative products to the selected tag")
    public void userShouldSeeRelativeProductsToTheSelectedTag()
    {
        tagPage.assertTrue(anyCategoryPage.pageTitle().getText().contains(anyCategoryPage.allAvailableTags().get(randomNumber).getText()));
        tagPage.assertAll();
    }
}
