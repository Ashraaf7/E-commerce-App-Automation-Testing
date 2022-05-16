package step_definition;

import Pages.HomePage;
import Pages.SearchResultPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Locale;

public class Search
{
    HomePage homePage=new HomePage();
    SearchResultPage searchResultPage=new SearchResultPage();
    SoftAssert searchResult= new SoftAssert();
    String searchTerm=null;
    @Given("user click on search field")
    public void userClickOnSearchField()
    {
        homePage.searchField().click();
    }
    @And("^user type what he or she want to search \"(.*?)\"")
    public void userTypeWhatHeOrSheWantToSearch(String searchTerm)
    {
        homePage.searchField().sendKeys(searchTerm);
        this.searchTerm=searchTerm;
    }
    @And("user click on search button")
    public void userClickOnSearchButton()
    {
        homePage.searchButton().click();
    }
    @Then("user could find relative results")
    public void userCouldFindRelativeResults()
    {
        int numberOfItems =searchResultPage.productList().size();
        int check;
        searchResult.assertFalse(numberOfItems<=0,"No Relevant Search Items For This Search Term");
        searchResult.assertAll();
        ArrayList<String> productListS=new ArrayList();
        for(int i =0;i<numberOfItems;i++)
        {
            productListS.add(searchResultPage.productList().get(i).getText());
            check= productListS.get(i).toUpperCase().indexOf(searchTerm.toUpperCase());
            searchResult.assertFalse( check==-1,"One Of Search Results Is Irrelevant To Search Term");
            searchResult.assertAll();
        }
    }
}
