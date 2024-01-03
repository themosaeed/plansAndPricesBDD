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




    @Then("I Should see lite plan video Quality")
    public void validateLitePlanVideoQuality(){
        String expectedQuality = Hooks.subscriptionPage.ExpectedCountryLitePlanVideoQuality();
        Hooks.driver.assertThat().element(SubscriptionPage.LITEPLANVideoQuality()).text().isEqualTo(expectedQuality);
    }

    @And("I Should see Classic video Quality")
    public void validateClassicPlanVideoQuality(){
        String expectedQuality = Hooks.subscriptionPage.ExpectedCountryClassicPlanVideoQuality();
        Hooks.driver.assertThat().element(SubscriptionPage.ClassicPLANVideoQuality()).text().isEqualTo(expectedQuality);
    }

    @And("I Should see permium video Quality")
    public void validatePremiumPlanVideoQuality(){
        String expectedQuality = Hooks.subscriptionPage.ExpectedCountryPremiumPlanVideoQuality();
        Hooks.driver.assertThat().element(SubscriptionPage.PremiumPLANVideoQuality()).text().isEqualTo(expectedQuality);
    }

}
