package step_definition;

import Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;

public class SwitchCurrency
{
    HomePage homePage=new HomePage();
    SoftAssert productsPrices=new SoftAssert();
    @Given("user change current currency to EURO")
    public void userChangeCurrentCurrencyToEURO()
    {
        homePage.switchCurrencies().selectByVisibleText("Euro");
    }

    @Then("user should found all products prices in EURO")
    public void userShouldFoundAllProductsPricesInEURO()
    {
        int numberOfProducts=homePage.productPrices().size();
        for(int i=0;i<numberOfProducts;i++)
        {
            productsPrices.assertEquals(homePage.productPrices().get(i).getText().substring(0,1),"€","One Of Products Prices In Different Currency From The Selected One");
            productsPrices.assertAll();
        }
    }

    @Given("user change current currency to US Dollar")
    public void userChangeCurrentCurrencyToUSDollar()
    {
        homePage.switchCurrencies().selectByVisibleText("US Dollar");
    }

    @Then("user should found all products prices in US Dollar")
    public void userShouldFoundAllProductsPricesInUSDollar()
    {
        int numberOfProducts=homePage.productPrices().size();
        for(int i=0;i<numberOfProducts;i++)
        {
            productsPrices.assertEquals(homePage.productPrices().get(i).getText().substring(0,1),"$","One Of Products Prices In Different Currency From The Selected One");
            productsPrices.assertAll();
        }
    }
}