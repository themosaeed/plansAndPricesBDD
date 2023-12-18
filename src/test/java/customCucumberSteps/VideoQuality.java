package customCucumberSteps;

import com.shaft.driver.SHAFT;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RedeemGiftPage;
import pages.SubscriptionPage;

public class VideoQuality {
    private SHAFT.GUI.WebDriver driver;
    private SubscriptionPage subscriptionPage;


    @Before
    public void init(){
        driver = new SHAFT.GUI.WebDriver();
        subscriptionPage = new SubscriptionPage(driver);
        subscriptionPage.openPortal();
    }

    @Given("I change {string}")
    public void changeMarket(String market){
        subscriptionPage.switchMarket(market);
    }

    @When("I Choose {string}")
    public void changeLanguage(String Language){
        subscriptionPage.switchLanguage(Language);
    }


    @Then("I Should see lite plan video Quality")
    public void validateLitePlanVideoQuality(){
        String expectedQuality = subscriptionPage.ExpectedCountryLitePlanVideoQuality();
        driver.assertThat().element(SubscriptionPage.LITEPLANVideoQuality()).text().isEqualTo(expectedQuality);
    }

    @And("I Should see Classic video Quality")
    public void validateClassicPlanVideoQuality(){
        String expectedQuality = subscriptionPage.ExpectedCountryClassicPlanVideoQuality();
        driver.assertThat().element(SubscriptionPage.ClassicPLANVideoQuality()).text().isEqualTo(expectedQuality);
    }

    @And("I Should see permium video Quality")
    public void validatePremiumPlanVideoQuality(){
        String expectedQuality = subscriptionPage.ExpectedCountryPremiumPlanVideoQuality();
        driver.assertThat().element(SubscriptionPage.PremiumPLANVideoQuality()).text().isEqualTo(expectedQuality);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
