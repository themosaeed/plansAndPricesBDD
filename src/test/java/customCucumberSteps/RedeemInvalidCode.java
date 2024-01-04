package customCucumberSteps;

import com.shaft.driver.SHAFT;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Hook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import pages.RedeemGiftPage;
import pages.SubscriptionPage;

public class RedeemInvalidCode {


    @Given("I Navigate to STC  Website")
    public void navigateToSubPage(){
        Hooks.subscriptionPage.openPortal();
    }

    @When("I Change page to redeem code page")
    public void moveToRedeemCodePage(){
        Hooks.subscriptionPage.moveToRedeemGiftPage();
    }

    @And("I enter invalid redeem code")
    public void enterInvalidRedeemCode(){
        Hooks.redeemGiftPage.inputInvalidRedeemCode();
    }

    @Then("I Should see an error message")
    public void validateRedeemCodeErrorMsg(){
        Hooks.driver.assertThat().element(RedeemGiftPage.redeemCodeErrorMessage()).exists().perform();
    }

}
