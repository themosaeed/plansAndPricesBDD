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


    @Then("I Should see lite plan name and price in my currency and selected language")
    public void checkLitePlanNameAndPrice(){
        String currentLanguage = Hooks.subscriptionPage.getCurrentLanguage();
        String ExpectedPrice = Hooks.subscriptionPage.ExpectedCountryLitePlanPrice();

        Hooks.driver.assertThat().element(SubscriptionPage.LITEPLANName(currentLanguage)).exists().perform();
        Hooks.driver
                .assertThat()
                .element(SubscriptionPage.LITEPLANPrice(currentLanguage)).text()
                .isEqualTo(ExpectedPrice)
                .perform();

    }

    @And("I Should see Classic plan name and price in my currency and selected language")
    public void checkClassicPlanNameAndPrice(){
        String currentLanguage = Hooks.subscriptionPage.getCurrentLanguage();
        String ExpectedPrice = Hooks.subscriptionPage.ExpectedCountryClassicPlanPrice();

        Hooks.driver.assertThat().element(SubscriptionPage.CLASSICPLANName(currentLanguage)).exists().perform();
        Hooks.driver
                .assertThat()
                .element(SubscriptionPage.CLASSICPlanPrice(currentLanguage)).text()
                .isEqualTo(ExpectedPrice)
                .perform();

    }

    @And("I Should see permium name and price in my currency and selected language")
    public void checkPremiumPlanNameAndPrice(){
        String currentLanguage = Hooks.subscriptionPage.getCurrentLanguage();
        String ExpectedPrice = Hooks.subscriptionPage.ExpectedCountryPremiumPlanPrice();

        Hooks.driver.assertThat().element(SubscriptionPage.PREMIUMPLANName(currentLanguage)).exists().perform();

        Hooks.driver
                .assertThat()
                .element(SubscriptionPage.PREMIUMPlanPrice(currentLanguage)).text()
                .isEqualTo(ExpectedPrice)
                .perform();

    }


}
