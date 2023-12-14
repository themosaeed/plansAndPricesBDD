package customCucumberSteps;

import com.shaft.driver.SHAFT;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import pages.SubscriptionPage;

public class PriceAndPlans {
    private SHAFT.GUI.WebDriver driver;
    private SubscriptionPage subscriptionPage;



    @Before
    public void init(){
        driver = new SHAFT.GUI.WebDriver();
        subscriptionPage = new SubscriptionPage(driver);
    }


    @Given("I Navigate to STC TV Website")
    public void navigateToSubPage(){
        subscriptionPage.openPortal();
    }

    @When("I Select {string}")
    public void selectMarket(String market){
        subscriptionPage.switchMarket(market);
    }



    @And("I Change {string}")
    public void changeLanguage(String Language){
        subscriptionPage.switchLanguage(Language);
    }

    @Then("I Should see lite plan name and price in my currency and selected language")
    public void checkLitePlanNameAndPrice(){
        String currentLanguage = subscriptionPage.getCurrentLanguage();
        String ExpectedPrice = subscriptionPage.ExpectedCountryLitePlanPrice();

        driver.assertThat().element(SubscriptionPage.LITEPLANName(currentLanguage)).exists().perform();
        driver
                .assertThat()
                .element(SubscriptionPage.LITEPLANPrice(currentLanguage)).text()
                .isEqualTo(ExpectedPrice)
                .perform();

    }

    @And("I Should see Classic plan name and price in my currency and selected language")
    public void checkClassicPlanNameAndPrice(){
        String currentLanguage = subscriptionPage.getCurrentLanguage();
        String ExpectedPrice = subscriptionPage.ExpectedCountryClassicPlanPrice();

        driver.assertThat().element(SubscriptionPage.CLASSICPLANName(currentLanguage)).exists().perform();
        driver
                .assertThat()
                .element(SubscriptionPage.CLASSICPlanPrice(currentLanguage)).text()
                .isEqualTo(ExpectedPrice)
                .perform();

    }

    @And("I Should see permium name and price in my currency and selected language")
    public void checkPremiumPlanNameAndPrice(){
        String currentLanguage = subscriptionPage.getCurrentLanguage();
        String ExpectedPrice = subscriptionPage.ExpectedCountryPremiumPlanPrice();

        driver.assertThat().element(SubscriptionPage.PREMIUMPLANName(currentLanguage)).exists().perform();

        driver
                .assertThat()
                .element(SubscriptionPage.PREMIUMPlanPrice(currentLanguage)).text()
                .isEqualTo(ExpectedPrice)
                .perform();

    }

    @After
    public void teardown() {
        driver.quit();
    }

}
